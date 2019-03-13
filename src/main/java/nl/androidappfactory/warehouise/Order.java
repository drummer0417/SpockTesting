package nl.androidappfactory.warehouise;

import java.util.ArrayList;
import java.util.List;

public class Order {


    String article;
    int amount;

    public Order(String article, int amount) {

        this.article = article;
        this.amount = amount;
    }

    public void fill(Warehouse warehouse) {

        System.out.println("fill warehouse");
        if (warehouse.hasInventory("Laptop", 10)) {
            warehouse.remove(article, amount);
//            warehouse.remove(article, amount);
//            warehouse.remove(article, amount);
//            warehouse.remove(article, amount);
        } else{
            article = null;
            amount = 0;
        }
    }

    public boolean filled() {

        boolean filled = article != null && article.length() > 0;
        System.out.println("order filled is: " + filled);
        return filled;
    }

    public String getArticle() {

        return article;
    }

    public void setArticle(String article) {

        this.article = article;
    }

    public int getAmount() {

        return amount;
    }

    public void setAmount(int amount) {

        this.amount = amount;
    }
}
