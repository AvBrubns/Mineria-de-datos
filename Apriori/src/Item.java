package src;

import java.text.DecimalFormat;
import java.util.List;

public class Item {
    List<String> group;
    Integer occurrences;
    double support;

    public Item(List<String> group, Integer occurrences) {
        this.group = group;
        this.occurrences = occurrences;
    }

    /* Calcula la cobertura del item a partir del numero de transacciones */
    public void calculateSupport(Integer transactions) {
        this.support = Math.round(((double) occurrences / (double) transactions) * 100) / Math.pow(10, 2);
    }
}
