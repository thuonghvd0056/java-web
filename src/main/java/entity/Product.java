package entity;

public class Product {
    private int id;
    private String price;
    private String frame;

    public  Product(){

    }
    public Product(int id, String price, String frame) {
        this.id = id;
        this.price = price;
        this.frame = frame;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }


}
