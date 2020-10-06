package src;

import java.util.ArrayList;
import java.util.List;

public class Itemset {
    List<Item> list;
    public Itemset() {
        list = new ArrayList<>();
    }
    /* Imprime los datos de item con un formato especifico */
    public void printInfo() {
        for(Item item : list) {
            System.out.println(item.group + " -> " + item.occurrences + "   " + item.support);
        }
    }
}
