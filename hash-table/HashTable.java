import java.util.Iterator;

public class HashTable {
  int capacity;
  private LinkedList<Entry>[] entries;

  public HashTable(int capacity) {
    this.capacity = capacity;
    entries = new LinkedList[capacity];
  }

  private class Entry {
    private int key;
    private String value;

    public Entry(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public void put(int key, String value) {
    int index = hash(key);
    if (entries[index] == null) {
      entries[index] = new LinkedList<>();
    }
    HashTable.LinkedList<Entry> bucket = entries[index];
    for (var entry : bucket) {
      if (entry.key == key) {
        entry.value = value;
        return;
      }
    }
    var entry = new Entry(key, value);
    bucket.add(entry);
  }

  public String get(int key) {

    var entry = getEntry(key);
    return (entry == null) ? null : entry.value;
  }

  public void remove(int key) {
    var entry = getEntry(key);
    if (entry == null) {
      throw new IllegalStateException();
    }
    getBucket(key).removeAt(entry);
  }

  private int hash(int key) {
    return key % capacity;
  }

  public void show() {
    for (int i = 0; i < capacity; ++i) {
      System.out.println("Bucket " + i + ":");
      if (entries[i] != null) {
        Node<Entry> current = entries[i].head;
        while (current != null) {
          System.out.println("Key: " + current.data.key + ", Value: " + current.data.value);
          current = current.next;
        }
      }
    }
  }

  private LinkedList<Entry> getBucket(int key) {
    return entries[hash(key)];
  }

  private Entry getEntry(int key) {
    var bucket = getBucket(key);
    if (bucket != null) {
      for (var entry : bucket) {
        if (entry.key == key) {
          return entry;
        }
      }
    }
    return null;
  }

  private class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  private class LinkedList<T> implements Iterable<T> {
    public Node<T> head;
    private Node<T> tail;

    public LinkedList() {
      this.head = null;
    }

    public void add(T data) {
      Node<T> node = new Node<>(data);
      if (head == null) {
        head = tail = node;
        return;
      }
      tail.next = node;
      tail = node;
    }

    public void removeAt(T entry) {
      if (head == null) {
        throw new IllegalStateException("List is empty");
      }
      if (head.next == null) {
        head = tail = null;
        return;
      }
      if (entry.equals(head.data)) {
        head = head.next;
        return;
      }
      Node<T> curr = head.next;
      Node<T> prev = head;
      while (curr != null) {
        if (entry.equals(curr.data)) {
          if (curr.next == null) {
            curr = null;
            prev.next = null;
            return;
          }
          prev.next = curr.next;
          curr = null;

        }
        prev = curr;
        curr = curr.next;
      }
    }

    @Override
    public Iterator<T> iterator() {
      return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
      private Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new IllegalStateException("No next element");
        }
        T data = current.data;
        current = current.next;
        return data;
      }
    }
  }

}