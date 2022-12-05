package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private final static String TABLE_NAME = "items";
    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        Item result;
        try (PreparedStatement statement = connection
                .prepareStatement("insert into ? (name, time) values (?, ?);",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, TABLE_NAME);
            statement.setString(2, item.getName());
            statement.setTimestamp(3, Timestamp.valueOf(item.getNow()));
            result = statement.executeUpdate() == 1 ? item : null;
            try (var keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error add item");
        }
        return result;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result;
        try (PreparedStatement statement = connection
                .prepareStatement("update ? set name = ?, time = ? where id = ?;")) {
            statement.setString(1, TABLE_NAME);
            statement.setString(2, item.getName());
            statement.setTimestamp(3, Timestamp.valueOf(item.getNow()));
            statement.setInt(4, id);
            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Error replace item");
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result;
        try (PreparedStatement statement = connection
                .prepareStatement("delete from ? where id = ?;")) {
            statement.setString(1, TABLE_NAME);
            statement.setInt(2, id);
            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Error delete item");
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from ?")) {
            statement.setString(1, TABLE_NAME);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(getItem(rs));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error find all items");
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from ? where name = ?")) {
            statement.setString(1, TABLE_NAME);
            statement.setString(2, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(getItem(rs));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error find by name item");
        }
        return result;
    }

    private Item getItem(ResultSet rs) throws SQLException {
        return new Item(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getTimestamp("created").toLocalDateTime());
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from ? where id = ?")) {
            statement.setString(1, TABLE_NAME);
            statement.setInt(2, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = getItem(rs);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error find by id item");
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
