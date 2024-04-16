import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    LinkList list = new LinkList();
  list.addLast(2);
  list.addLast(12);
  list.addFirst(5);
  list.print();


  System.out.println("Reverse");
  list.reverse();
  list.print();
}}