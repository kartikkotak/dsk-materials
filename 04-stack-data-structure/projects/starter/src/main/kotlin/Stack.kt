package main.kotlin

interface Stack<T : Any> {
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0
    fun peek(): T?
    fun push(element: T)
    fun pop(): T?
}

class StackImpl<T : Any> : Stack<T> {

    companion object {
        fun <T: Any> create(items: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }

    private val elements = arrayListOf<T>()
    override val count: Int
        get() = elements.size

    override fun peek(): T? {
        return elements.lastOrNull()
    }

    override fun push(element: T) {
        elements.add(element)
    }

    override fun pop(): T? {
        return elements.removeLastOrNull()
    }

    override fun toString(): String {
        return buildString {
            appendLine("----top----")
            elements.asReversed().forEach {
                appendLine("$it")
            }
            appendLine("-----------")
        }
    }
}

fun <T : Any> stackOf(vararg elements: T): Stack<T> {
    return StackImpl.create(elements.asList())
}
