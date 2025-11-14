package main.kotlin

import linkedlist.LinkedList

// Print LinkedList in reverse using stack

fun <T : Any> LinkedList<T>.printInReverse() {
    val stack: Stack<T> = StackImpl()
    for (item in this) {
        stack.push(item)
    }
    while (!stack.isEmpty) {
        println(stack.pop())
    }
}
