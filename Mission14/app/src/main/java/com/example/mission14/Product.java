package com.example.mission14;

public class Product {
    int pic;
    String name;
    String price;
    String contents;

    public Product(int pic, String name, String price, String contents) {
        this.pic = pic;
        this.name = name;
        this.price = price;
        this.contents = contents;
    }

    public int getPic() {
        return pic;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getContents() {
        return contents;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
