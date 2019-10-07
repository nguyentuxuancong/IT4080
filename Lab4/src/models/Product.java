package models;

public class Product {
    private int ProductId;
    private String Name;
    private int quantity;
    private int price;
    private int catogoryId;

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCatogoryId() {
        return catogoryId;
    }

    public void setCatogoryId(int catogoryId) {
        this.catogoryId = catogoryId;
    }
}
