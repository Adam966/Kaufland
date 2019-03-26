package Items.Food;

public class Fruit extends Food {
    private double weight;

    public Fruit(String name, double price, int calories, double weight) {
        super(name, price, calories);
        this.weight = weight;
    }

    public Fruit(String name, double price, double weight) {
        this(name,price,-1, weight);
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() * weight;
    }
}
