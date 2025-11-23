package main.kotlin

import ArrayListQueue

/**
 * Challenge 1: Tree challenge
 * Print the values in a tree in an order based on their level.
 * Nodes belonging to the same level should be printed on the same line.
 * For example, consider the following tree:
 *
 */

data class NodeWithLevel<T : Any>(
    val level: Int,
    val node: TreeNode<T>
)

fun <T : Any>printEachLevel(tree: TreeNode<T>) {
    val queue = ArrayListQueue<TreeNode<T>>()
    queue.enqueue(tree)
    var nodesLeftInChildren = queue.count

    while (queue.isEmpty.not()) {
        nodesLeftInChildren = queue.count

        while (nodesLeftInChildren > 0) {
            val node = queue.dequeue()
            node?.let { node ->
                print("${node.value} ")
                node.childrens().forEach { queue.enqueue(it) }
                nodesLeftInChildren--
            } ?: break
        }

        println()
    }
}
