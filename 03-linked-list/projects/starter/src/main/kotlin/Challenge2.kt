package main.kotlin

// Given a linked list, find the middle node of the list. For example:
// 1 -> 2 -> 3 -> 4 -> 5
fun <T : Any> LinkedList<T>.getMiddle(): Node<T>? {
    var slow = this.nodeAt(0)
    var fast = this.nodeAt(0)

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
            slow = slow?.next
        }
    }

    return slow
}


