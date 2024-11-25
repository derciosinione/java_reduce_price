public class ClassConfortPrice {
    public int id;
    public long price;
    public boolean isAvailable;

    public ClassConfortPrice(Integer price, boolean isAvailable) {
        this.price = price;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "{price=" + price + ", isAvailable=" + isAvailable + "}";
    }
}
