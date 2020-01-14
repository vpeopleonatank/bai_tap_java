package Stock;

public class Stock {
    public Stock(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfStock() {
        return nameOfStock;
    }

    public void setNameOfStock(String nameOfStock) {
        this.nameOfStock = nameOfStock;
    }

    public Stock(int id, String nameOfStock) {
        this.id = id;
        this.nameOfStock = nameOfStock;
    }

    int id;
    String nameOfStock;
}
