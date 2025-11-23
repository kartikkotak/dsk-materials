package main.kotlin

import linkedlist.DoublyLinkedList
import ringbuffer.RingBuffer

interface Queue<T : Any> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0

    fun peek(): T?
}

class ArrayListQueue<T : Any> : Queue<T> {
    private val elements = mutableListOf<T>()
    override fun enqueue(element: T): Boolean {
        return elements.add(element)
    }

    override fun dequeue(): T? {
        return elements.removeFirstOrNull()
    }

    override val count: Int
        get() = elements.size

    override fun peek(): T? {
        return elements.firstOrNull()
    }

    override fun toString(): String {
        return elements.toString()
    }
}

class LinkedListQueue<T : Any> : Queue<T> {
    private val list: DoublyLinkedList<T> = DoublyLinkedList()
    private var size: Int = 0
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }

    override fun dequeue(): T? {
        val node = list.first ?: return null
        size--
        return list.remove(node)
    }

    override val count: Int
        get() = size

    override fun peek(): T? {
        return list.first?.value
    }

    override fun toString(): String {
        return list.toString()
    }
}

class RingBufferQueue<T : Any>(size: Int) : Queue<T> {
    private val ringBuffer: RingBuffer<T> = RingBuffer(size)

    override val count: Int
        get() = ringBuffer.count

    override fun peek(): T? {
        return ringBuffer.first
    }

    override fun enqueue(element: T): Boolean {
        return ringBuffer.write(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) null else ringBuffer.read()
    }
}