package main.kotlin

// Check Balanced Paranthesis

fun String.checkParanthesis(): Boolean {
    val stack = StackImpl<Char>()

    this.forEach { c ->
        when (c) {
            '(' -> {
                stack.push('(')
            }
            ')' -> {
                stack.pop() ?: return false
            }
            else -> { }
        }
    }
    return stack.isEmpty
}
