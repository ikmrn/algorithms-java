public class Main {
  public static void main(String[] args) {
    var ring = new RingBuffer(5);
    ring.append(1);
    ring.append(2);
    ring.append(3);
    ring.append(4);
    ring.append(5);
    ring.append(6);
    ring.prepend(7);
    ring.prepend(8);
    ring.prepend(9);
    ring.prepend(10);
    // ring.prepend(11);
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeFirst());
    System.out.println(ring.removeLast());
    System.out.println(ring.removeLast());
    System.out.println(ring.removeLast());
    ring.append(3);
    ring.prepend(2);
    ring.prepend(1);
    ring.prepend(-1);
    ring.prepend(-2);
    ring.prepend(-3);
    ring.prepend(-4);
    ring.prepend(-5);
    ring.prepend(-6);
    ring.prepend(-7);
    ring.prepend(-8);
    System.out.println(ring);
  }
}