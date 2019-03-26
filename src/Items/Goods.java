package Items;

public class Goods extends Item  implements Piece{
    private int amount;
    private Category type;

    public Goods(String name, double price, int amount, Category type) {
        super(name, price);
        this.amount = amount;
        this.type = type;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public double getTotalPrice() {
        return amount;
    }
}
