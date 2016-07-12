package Inheritance.Pr02BookShop.models;

public class Book {
    private String title;
    private String author;
    private Double price;

    public Book(String author, String title, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] name = author.split("\\s+");
        if (name.length > 1) {
            if (startsWhitNum(name[1])) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }


        this.author = author;
    }

    public Double getPrice() {
        return this.price;
    }

    private void setPrice(Double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    private static boolean startsWhitNum(String string) {
        char firstLetter = string.charAt(0);
        return Character.isDigit(firstLetter);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
