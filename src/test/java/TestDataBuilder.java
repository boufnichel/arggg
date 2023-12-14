
public interface TestDataBuilder {
    static Product getProduct(double price){
        var book = new Product();
        book.setPrice(price);
        book.setStock(100);

      return book;
    }
    static Product getBook(double price){
        var book = new Product();
        book.setBook(true);
        book.setPrice(price);
        book.setStock(100);

      return book;
    }
}
