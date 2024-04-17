

public class Main{
  public static void main(String[] args){
    HashTable h = new HashTable(5);
    h.put(6, "A");
    h.put(8, "B");
    h.put(11, "C");
    h.put(6, "A+");
    h.show();
    System.out.println();
    h.remove(6);
    h.show();
    System.out.println();
    h.remove(11);
    h.show();
  }
}