from typing import Generic, Optional, TypeVar

T = TypeVar("T")


class Node(Generic[T]):
    def __init__(self, value: T):
        self.value = value
        self.next: Optional[Node[T]] = None
        self.prev: Optional[Node[T]] = None


class Queue(Generic[T]):
    def __init__(self):
        self.length: int = 0
        self.head: Optional[Node[T]] = None
        self.tail: Optional[Node[T]] = None

    def enqueue(self, value: T) -> None:
        node = Node(value)
        if not self.head:
            self.head = self.tail = node
        else:
            node.next = self.head
            self.head.prev = node
            self.head = node
        self.length += 1

    def dequeue(self) -> Optional[T]:
        if not self.head:
            return None

        return_value = self.head.value
        if not self.head.next:
            self.head = self.tail = None
        else:
            self.head.next.prev = None
            temp = self.head.next
            del self.head
            self.head = temp
        self.length -= 1
        return return_value

    def peek(self) -> Optional[T]:
        if not self.head:
            return None
        return self.head.value

    def is_empty(self) -> bool:
        return self.length == 0

    def printq(self) -> None:
        if not self.head:
            return
        curr: Optional[Node] = self.head
        while curr:
            print(curr.value)
            curr = curr.next

    def reverse(self) -> None:
        if not self.head or not self.head.next:
            return
        prev = None
        curr = self.head
        while curr:
            curr.prev = curr.next
            curr.next = prev
            prev = curr
            curr = curr.prev

        self.tail = self.head
        self.head = prev


q = Queue()
print(q.is_empty())
q.enqueue(4)
q.enqueue(5)
q.enqueue(3)
q.enqueue(2)
print(q.is_empty())
q.printq()
print("Reverse")
q.reverse()
q.printq()
