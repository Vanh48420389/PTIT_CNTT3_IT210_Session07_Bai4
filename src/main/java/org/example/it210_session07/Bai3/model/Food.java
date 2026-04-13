package org.example.it210_session07.Bai3.model;

public class Food {
    private String name;
    private double price;
    private String category;
    private String imageName;

    public Food() {

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Food(String name, double price, String category, String imageName) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
    }

    public void setId(int i) {
    }

    public void setPhysicalPath(String absolutePath) {
    }

    public String getId() {
    }
}
