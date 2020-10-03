package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Apriori {
    List<List<String>> transactions;
    List<String> elements;
    List<Itemset> itemset;
    Integer k;
    double TRESHOLDER = 0.43;
    public Apriori(List<List<String>> transactions, List<String> elements) {
        this.transactions = transactions;
        this.elements = elements;
        this.k = 2;
        this.itemset = new ArrayList<>();
    }

    public void loop() {
        Itemset temp;
        while(true) {
            List<List<String>> result = new ArrayList<>();
            combinations(elements, k, 0, new String [2], result);
            System.out.println(result);
            break;
        }
    }

    /*
    * String[] elements: Lista de elementos
    * int len: Tamaño para la contruccion de conjuntos
    * String result: Arreglo que almacena los resultados
    * */
    public void combinations(List<String> elements, int len, int startPosition, String[] group, List<List<String>> result) {
        if (len == 0){
            List<String> temp = new ArrayList<>();
            Collections.addAll(temp, group);
            result.add(temp);
            return;
        }
        for (int i = startPosition; i <= elements.size()-len; i++){
            group[group.length - len] = elements.get(i);
            combinations(elements, len-1, i+1, group, result);
        }
    }
}
