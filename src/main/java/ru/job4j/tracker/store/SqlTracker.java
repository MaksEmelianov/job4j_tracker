package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

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
                .prepareStatement("insert into items (name, created) values (?, ?);",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getNow()));
            result = statement.executeUpdate() == 1 ? item : null;
            try (var keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Error add item");
        }
        return result;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result;
        try (PreparedStatement statement = connection
                .prepareStatement("update items set name = ?, created = ? where id = ?;")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getNow()));
            statement.setInt(3, id);
            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Error replace item");
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result;
        try (PreparedStatement statement = connection
                .prepareStatement("delete from items where id = ?;")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Error delete item");
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from items")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(getItem(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("Error find all items");
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(getItem(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                     connection.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                result = getItem(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
