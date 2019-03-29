package Bill;

import Exeptions.BillExeptions;
import Items.Drink.DraftInterference;
import Items.Food.Fruit;
import Items.Globals;
import Items.Item;
import Items.Piece;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
    private List<Item> list;
    private boolean open;

    public Bill() {
        open = true;
        this.list = new ArrayList<>();
    }

    public List<Item> getList() {
        return list;
    }

    public void addItem(Item item) throws BillExeptions{
        if (item != null) {
            if (list.size() == Globals.MAXITEMS) {
                String massage = "Bill is full, maximum is " + Globals.MAXITEMS;
                throw new BillExeptions(massage);
            }
            list.add(item);
        }
    }

    public void removeItem(Item item) {
        if (list.contains(item))
            list.remove(item);
    }

    public int countBill() {
        return list.size();
    }

    public float getFinalPrice() {
        float price = 0;
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            price += item.getTotalPrice();
        }
        return price;
    }

    public void end() {
        if (open == true) {
            Date date = getDate();
            System.out.println(getDate());
            open = false;
        } else {
            System.out.println("Bill is closed.");
        }
    }

    public void print() {
        if (list.size() == 0) {
            System.out.println("Nothing to print.");
        } else {
            for (Item item : list) {
                if (item instanceof DraftInterference) {
                    System.out.println(item.getName()+" "+((DraftInterference) item).getVolume()+" ");
                    System.out.println(item.getPrice() +" "+item.getTotalPrice());
                }
                else if (item instanceof Fruit) {
                    System.out.println(item.getName()+" "+((Fruit) item).getWeight()+" ");
                    System.out.println(item.getPrice() +" "+item.getTotalPrice());
                }
                else if (item instanceof Piece) {
                    System.out.println(item.getName()+" "+((Piece) item).getAmount()+" ");
                    System.out.println(item.getPrice() +" "+item.getTotalPrice());
                }
            }

        }
    }

    public Date getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return date;
    }


    public float getUSDcurr(float USD, float price) {
        float USDprice = USD * price;
        return USDprice;
    }
}
