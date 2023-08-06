public class Product {
    private String name;
    private double price;
    private int stock;
    private boolean isSpecial;
    private boolean isBook;

    public Product(String name, double price, int stock, boolean isSpecial, boolean isBook) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.isSpecial = isSpecial;
        this.isBook = isBook;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public boolean isBook() {
        return isBook;
    }

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        } else {
            throw new IllegalStateException("Product is out of stock");
        }
    }
}

