package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.Item;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            item.setId((Integer) session.save(item));
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new IllegalStateException("Error add item");
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int ckeck;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            ckeck = session.createQuery("UPDATE Item SET name = :name where id = :id", Item.class)
                    .setParameter("name", item.getName())
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new IllegalStateException("Error replace item");
        }
        return ckeck != 0;
    }

    @Override
    public boolean delete(int id) {
        int ckeck;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            ckeck = session.createQuery("DELETE Item WHERE id = :id", Item.class)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new IllegalStateException("Error delete item");
        }
        return ckeck != 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            list = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new IllegalStateException("Error find all items");
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            list = session.createQuery("from Item as i where i.name = :name", Item.class)
                    .setParameter("name", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new IllegalStateException("Error find all items by name");
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            item = session.createQuery("from Item where id = :id", Item.class)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new IllegalStateException("Error find item by id");
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
