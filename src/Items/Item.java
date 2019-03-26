package Items;

public abstract class Item implements ItemInterference {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalPrice() {
        return price;
    }

    public double getPrice() {
        return price;
    }
}
