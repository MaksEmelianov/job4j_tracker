package ru.job4j.poly;

public class Service {

    private DbStore store;

    public Service(DbStore dbStore) {
        this.store = dbStore;
    }

    public void extract() {
        store.save("Maks");
    }

    public static void main(String[] args) {
        DbStore dbStore1 = new DbStore();
        Store dbStore2 = new DbStore();
        Store fileStore = new FileStore();
        Service service = new Service(dbStore1);
        service.extract();
    }
}
