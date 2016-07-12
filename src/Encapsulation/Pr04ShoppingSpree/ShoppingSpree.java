package Encapsulation.Pr04ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ShoppingSpree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        try {
            String[] peopleInfo = reader.readLine().split(";");
            for (String personInfo : peopleInfo) {
                String[] nameAndMoney = personInfo.split("=");
                String name = nameAndMoney[0];
                Double money = Double.parseDouble(nameAndMoney[1]);
                people.put(name, new Person(name, money));
            }

            String[] productInfo = reader.readLine().split(";");
            for (String singleProduct : productInfo) {
                String[] nameAndCost = singleProduct.split("=");
                String name = nameAndCost[0];
                Double cost = Double.parseDouble(nameAndCost[1]);
                products.put(name, new Product(name, cost));
            }

            String[] shoppingList = reader.readLine().split("\\s+");
            while (!shoppingList[0].toLowerCase().equals("end")) {
                String personName = shoppingList[0];
                String productName = shoppingList[1];
                people.get(personName).addProduct(products.get(productName));

                shoppingList = reader.readLine().split("\\s+");
            }

            people.values().stream().forEach(System.out::println);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Person {
    private String name;
    private Double money;
    private List<Product> productList;

    public Person(String name, Double money) {
        this.setName(name);
        this.setMoney(money);
        this.productList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        if (product.getCost() > this.getMoney()) {
            System.out.printf("%s can't afford %s\n", this.getName(), product);
        } else {
            this.productList.add(product);
            this.setMoney(this.getMoney() - product.getCost());
            System.out.printf("%s bought %s\n", this.getName(), product);
        }
    }

     @Override
     public String toString() {
         String returnString;
         if (productList.size() == 0) {
             returnString = String.format("%s - Nothing bought", this.getName());
         } else {
             StringBuilder str = new StringBuilder();
             for (int i = 0; i < getProductList().size() - 1; i++) {
                 str.append(getProductList().get(i).getName() + ", ");
             }

             str.append(getProductList().get(getProductList().size() - 1).getName());
             returnString = String.format("%s - %s", this.getName(), str);
         }

         return returnString;
     }
}

class Product {
    private String name;
    private Double cost;

    public Product(String name, Double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
