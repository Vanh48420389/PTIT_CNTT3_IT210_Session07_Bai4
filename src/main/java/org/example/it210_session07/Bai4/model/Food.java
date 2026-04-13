package org.example.it210_session07.Bai4.model;

public class Food {
    private int id;
    private String name;
    private double price;
    private String category;
    private String imageName;
    private String physicalPath;

    public Food() {

    }

    public int getId() {
        return id;
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

    public String getPhysicalPath() {
        return physicalPath;
    }

    public Food(int id, String name, double price, String category, String imageName, String physicalPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.imageName = imageName;
        this.physicalPath = physicalPath;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPhysicalPath(String physicalPath) {
        this.physicalPath = physicalPath;
    }
}
