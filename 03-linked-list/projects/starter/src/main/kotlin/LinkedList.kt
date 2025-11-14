package main.kotlin

class LinkedList<T : Any>: Iterable<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) { return "Empty list" }
        return head.toString()
    }

    fun push(value: T): Node<T>? {
        var current = Node(value = value, next = head)
        head = current
        if (tail == null) {
            tail = head
        }
        size++
        return head
    }

    fun append(value: T): Node<T>? {
        if (tail == null) {
            return push(value)
        }
        var node = Node(value, null)
        tail!!.next = node
        tail = node

        size++

        return node
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (isEmpty()) { return null }
        val value = head!!.value
        head = head!!.next
        if (isEmpty()) { tail = null }
        size--
        return value
    }

    fun removeLast(): T? {
        if (head == null || head?.next == null) {
            return pop()
        }
        size--
        var prev = head
        var current = head

        var next = current?.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev?.next = null
        tail = prev
        return current?.value
    }

    fun removeAfter(node: Node<T>): T? {
        val next = node.next
        node.next = next?.next

        if (next == tail) {
            tail = node
            tail!!.next = null
        }

        if (next == null) {
            size--
        }

        return next?.value
    }

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }
}
