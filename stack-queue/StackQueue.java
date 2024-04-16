public class StackQueue{
  private int length = 0;
  private int capacity;
  private ArrayStack addStack;
  private ArrayStack removeStack;
  
  public StackQueue(int capacity){
    this.capacity = capacity;
    addStack = new ArrayStack(capacity);
    removeStack = new ArrayStack(capacity);
  }
  public void enqueue(int item){
    this.addStack.push(item);
  }
  public int dequeue(){
    if (this.removeStack.tail == 0){
      if (this.addStack.tail == 0) {
        throw new IllegalStateException("The queue is empty");
      }
      while (this.addStack.tail != 0){
        this.removeStack.push(this.addStack.pop());
      }
    } 
    return this.removeStack.pop();
  }
}