package src;

import java.util.List;

public class Item {
    List<String> group;
    Integer occurrences;

    public Item(List<String> group, Integer occurrences) {
        this.group = group;
        this.occurrences = occurrences;
    }

    public float support() {
        return (float) 0.0;
    }
}
