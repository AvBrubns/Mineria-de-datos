package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Apriori {
    List<List<String>> transactions;
    List<String> elements;
    List<Itemset> itemsets;
    Integer k;
    double TRESHOLDER = 0.43;
    public Apriori(List<List<String>> transactions, List<String> elements) {
        this.transactions = transactions;
        this.elements = elements;
        this.k = 2;
        this.itemsets = new ArrayList<>();
    }

    public void loop() {
        Itemset temp;
        while(true) {
            Itemset itemset = new Itemset();
            combinations(elements, k, 0, new String [k], itemset);
            itemsets.add(itemset);
            //System.out.println(transactions.get(0).get(0));
            for(Item item : itemset.list) {
                contain(item);
                System.out.println(item.occurrences);
            }

            break;
        }
    }

    /*
    * String[] elements: Lista de elementos
    * int len: Tamaño para la contruccion de conjuntos
    * String result: Arreglo que almacena los resultados
    * */
    public void combinations(List<String> elements, int len, int startPosition, String[] group, Itemset itemset) {
        if (len == 0){
            List<String> temp = new ArrayList<>();
            Collections.addAll(temp, group);
            Item item = new Item(temp, 0);
            itemset.list.add(item);
            return;
        }
        for (int i = startPosition; i <= elements.size()-len; i++){
            group[group.length - len] = elements.get(i);
            combinations(elements, len-1, i+1, group, itemset);
        }
    }

    public void contain(Item item) {
        for(List<String> transaction : transactions) {
            Itemset temp = new Itemset();
            int occurrence = 0;
            combinations(transaction, k, 0, new String[k], temp);
            for(Item itemTemp: temp.list) {
                if(itemTemp.group.equals(item.group)) {
                    item.occurrences++;
                }
            }
            //System.out.println(item.group + "," +item.occurrences);
        }
    }
}
