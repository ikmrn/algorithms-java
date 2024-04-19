class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


head = LinkedList(0)
head.next = LinkedList(1)
head.next.next = LinkedList(2)
head.next.next.next = LinkedList(3)
head.next.next.next.next = LinkedList(4)
head.next.next.next.next.next = LinkedList(5)

curr = head
while curr:
    print(curr.value)
    curr = curr.next


def shiftLinkedList(head, k):
    curr = head
    k_node_prev = head
    count = 0
    while curr.next:
        if count < k + 1:
            count += 1
            curr = curr.next
            continue

        k_node = k_node_prev.next
        curr = curr.next
    if count != k:
        return
    k_node = k_node_prev.next
    k_node_prev.next = None

    print(k_node.value)
    print(curr.value)


shiftLinkedList(head, 2)
