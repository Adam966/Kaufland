import Bill.Bill;
import Exeptions.BillExeptions;
import Items.Category;
import Items.Drink.Bottle;
import Items.Drink.Draft;
import Items.Drink.Drink;
import Items.Food.Food;
import Items.Food.Fruit;
import Items.Food.Pastry;
import Items.Goods;
import Items.Item;

public class Application {
    private static Application app = new Application();

    private Application() {
    }

    public static Application getInstance() {
        return app;
    }

    public void example() throws BillExeptions {
        Bill bill = new Bill();
        Bottle milk = new Bottle("milk 1,5", 0.59, 2);
        bill.addItem(milk);
        Item pizza = new Pastry("Gazdovska", 1.10, 280, 2);
        bill.addItem(pizza);
        Food apple = new Fruit("Red apple", 0.59, 520, 500);
        bill.addItem(apple);
        Goods pencil = new Goods("Pencil 0.5", 0.60, 1, Category.SCHOOL);
        bill.addItem(pencil);
        Draft vinea = new Draft("White vinea", 1.20, true, 0.3);
        bill.addItem(vinea);
        Draft beer = new Draft("Birrel Lemon", 5.20, true, 0.5);
        bill.addItem(beer);
        bill.getFinalPrice();
        bill.end();
        System.out.println(bill.countBill());
        System.out.println(bill.getFinalPrice());
        bill.print();

    }
}
