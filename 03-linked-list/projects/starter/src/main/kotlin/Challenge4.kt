package main.kotlin

// Challenge 4: Merging two linked lists

fun <T : Comparable<T>> LinkedList<T>.mergeSorted(otherList: LinkedList<T>): LinkedList<T> {
    if (this.isEmpty()) return otherList
    if (otherList.isEmpty()) return this

    val result: LinkedList<T> = LinkedList<T>()
    var node1 = this.nodeAt(0)
    var node2 = otherList.nodeAt(0)

    while (node1 != null && node2 != null) {
        if (node1.value < node2.value) {
            result.append(node1.value)
            node1 = node1.next
        } else if (node2.value < node1.value) {
            result.append(node2.value)
            node2 = node2.next
        } else {
            result.append(node1.value)
            result.append(node2.value)
            node1 = node1.next
            node2 = node2.next
        }
    }

    while (node1 != null) {
        result.append(node1.value)
        node1 = node1.next
    }

    while (node2 != null) {
        result.append(node2.value)
        node2 = node2.next
    }

    return result
}
