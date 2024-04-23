# This is the class of the input linked list.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def get_linked_list_len(head):
    count = 0
    curr = head
    while curr:
        count += 1
        curr = curr.next
    return count


def shiftLinkedList(head, k):
    if k == 0:
        return head
    list_len = get_linked_list_len(head)
    count = k % list_len
    if count < 0:
        count = list_len + count
    if count == 0:
        return head
    curr = head
    k_node_prev = head
    while curr.next:
        if count > 0:
            count -= 1
            curr = curr.next
            continue

        k_node_prev = k_node_prev.next
        curr = curr.next
    k_node = k_node_prev.next
    k_node_prev.next = None
    curr.next = head
    head = k_node
    return head
