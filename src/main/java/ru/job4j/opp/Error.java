package ru.job4j.opp;

public class Error {

    private boolean active;
    private int status;
    protected String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error error404 = new Error(true, 404, "Page Not Found");
        Error error400 = new Error(true, 400, "Bad Request");
        Error error403 = new Error(true, 403, "Forbidden");
        Error errorNull = new Error();
        error404.printInfo();
        error403.printInfo();
        error400.printInfo();
        errorNull.printInfo();
    }

    public void printInfo() {
        System.out.println("Статус ошибки: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Сообщение: " + message);
    }
}
