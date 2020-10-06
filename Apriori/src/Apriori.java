package src;

import java.util.ArrayList;
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
        this.k = 1;
        this.itemsets = new ArrayList<>();
    }

    /*
    * Valida que la lista de transacciones tenga al menos 2 elementos y que la lista de elementos sea distito de cero
    * Muestra el conjunto de elementos que cumplen el humbral con k como numero de interaciones.
    * */
    public void loop() {
        if (this.transactions.size() < 2 || this.elements.size() == 0) {
            System.out.println("El archivo de transacciones no cumple con los requisitos.");
            return;
        }
        boolean status = false;
        while(!status) {
            Itemset tempItemset = new Itemset();
            Itemset newItemset = new Itemset();
            combinations(elements, k, 0, new String [k], tempItemset);
            for(Item item : tempItemset.list) {
                contain(item);
                item.calculateSupport(transactions.size());
                if(item.support >= TRESHOLDER) {
                    newItemset.list.add(item);
                }
            }
            if (newItemset.list.isEmpty()) {
                status = true;
            }else {
                if(itemsets.size() > 2) {
                    itemsets.remove(0);
                }
                itemsets.add(newItemset);
                k++;
            }
        }
        itemsets.get(1).printInfo();
    }

    /*
    * Genera las combinaciones a partir de la lista de elementos
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

    /*
    * contain: determina si el item esta dentro de la transaccion (ocurrencias)
    * */
    public void contain(Item item) {
        for(List<String> transaction : transactions) {
            Itemset temp = new Itemset();
            combinations(transaction, k, 0, new String[k], temp);
            for(Item itemTemp: temp.list) {
                if(itemTemp.group.equals(item.group)) {
                    item.occurrences++;
                }
            }
        }
    }
}
