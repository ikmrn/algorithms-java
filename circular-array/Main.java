
public class Main{
  public static void main(String[] args){
    CircularArray queue = new CircularArray(5);
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(23);
    System.out.println(queue);
    System.out.println(queue);
    var front = queue.dequeue();
    front = queue.dequeue();
    front = queue.dequeue();
    queue.enqueue(24);
    queue.enqueue(25);
    queue.enqueue(26);
    queue.enqueue(27);
    queue.enqueue(28);
    queue.enqueue(29);
    
    


    System.out.println(queue);


  }
}