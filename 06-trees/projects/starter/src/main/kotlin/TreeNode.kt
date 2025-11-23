package main.kotlin

import ArrayListQueue

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T : Any>(
    val value: T,
) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) =
        children.add(child)

    fun forEachDepthFirstSearch(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirstSearch(visit)
        }
    }

    fun forEachLevelOrderTraversal(visit: Visitor<T>) {
        val queue = ArrayListQueue<TreeNode<T>>()
        var node: TreeNode<T>? = this
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null

        forEachLevelOrderTraversal {
            if (it.value == value) {
                result = it
            }
        }

        return result
    }

    fun childrens(): List<TreeNode<T>> {
        return children.toList()
    }
}
