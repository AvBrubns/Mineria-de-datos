import src.Apriori;
import src.Reader;

import java.util.List;

class Main {
  public static void main(String[] args) {
    Reader reader = new Reader();
    reader.read("transacciones.txt");
    Apriori ap = new Apriori(reader.transactions, reader.elements);
    //System.out.println(reader.transactions);
    ap.loop();
  }
}