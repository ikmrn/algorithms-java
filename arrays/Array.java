public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
      items = new int[length];
    }

    public void insert(int item){
      // If the array is full, resize it
      if (items.length == count){
        // Create a new array
        int [] newItems = new int [count * 2];

        // Copy all the existing items
        for (int i = 0; i < count; ++i){
          newItems[i] = items[i];
        }
        // Add the new item at the end
        items = newItems;
      }
      items[count++] = item;
    }

    public void removeAt(int idx){
      if (idx >= count || idx < 0){
        throw new IllegalArgumentException();
      }
      for (int i = idx; i < count; ++i){
        items[i] = items[i + 1];
      }
      count--;
    }

    public int indexOf(int item){
      for (int i = 0; i < count; ++i){
        if (items[i] == item){
          return i;
        }
      }
      return -1;
    }

    public void print() {
    for (int i  = 0; i < count; ++i){
        System.out.println(items[i]);
      }
  }
}