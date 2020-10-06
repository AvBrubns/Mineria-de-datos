package src;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {
  public List<List<String>> transactions;
  public List<String> elements;
  public Reader() {
    transactions = new ArrayList<>();
    elements = new ArrayList<>();
  }
  /* Lee un archivo, generando la lista de transacciones y la lista de elementos */
  public void read(String path) {
    try {
      File file = new File(path);
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        List<String> item = new ArrayList<>();
        item.addAll(Arrays.asList(line.split(",")));
        this.transactions.add(item);
        this.buildElements(line);
      }
    }catch(Exception e) {
      System.out.println("El archivo no tiene un formato válido");
    }
  }

  /* Construye una lista con los elementos base */
  public void buildElements(String line) {
    for(String item: line.split(",")) {
      if (!this.elements.contains(item)) {
        this.elements.add(item);
      }
    }
  }
}
