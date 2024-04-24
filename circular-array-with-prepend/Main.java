public class Main {
  public static void main(String[] args) {
    CircularArray c = new CircularArray(5);
    c.append(1);
    c.append(2);
    c.append(3);
    c.append(5);
    System.out.println(c.toStringPrint());
    System.out.println(c.removeLast());
    c.prepend(7);
    c.prepend(8);
    c.prepend(9);
    c.prepend(42);
    c.prepend(42);
    c.prepend(42);
    c.prepend(42);
    // c.prepend(8);

    System.out.println(c.toStringPrint());
  }
}