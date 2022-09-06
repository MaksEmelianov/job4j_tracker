package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book philosophyJava = new Book("Philosophy java", 1168);
        Book grokkingAlgorithms = new Book("Grokking algorithms", 288);
        Book headJava = new Book("Head First Java", 688);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = philosophyJava;
        books[2] = grokkingAlgorithms;
        books[3] = headJava;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount() + " pages");
        }
        System.out.println();
        System.out.println("Replace cleanCode to headJava.");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount() + " pages");
        }
        System.out.println();
        System.out.println("Shown only book - \"Clean code\"");
        for (Book bk : books) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getCount() + " pages");
            }
        }
    }
}
