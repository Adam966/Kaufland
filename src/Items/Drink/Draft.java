package Items.Drink;

public class Draft extends Drink implements DraftInterference{
    private double volume;

    public Draft(String name, double price, boolean sweet, double volume) {
        super(name, price, sweet);
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public double getTotalPrice() {
        return volume * getPrice();
    }
}
