package Inheritance.Pr02BookShop.models;

public class GoldenEditionBook extends Book {


    public GoldenEditionBook(String author, String title, Double price) {
        super(author, title, price);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }

}
