package main.kotlin

import BinaryNode

class BinarySearchTree<T : Comparable<T>> {
    public var root: BinaryNode<T>? = null

    override fun toString(): String {
        return root.toString()
    }

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        // If node empty return new Node
        node ?: return BinaryNode(value)

        // Else compare root value
        // If less than root value, insert in left tree
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else { // Else insert in right tree
            node.rightChild = insert(node.rightChild, value)
        }

        return node
    }

    public fun contains(value: T): Boolean {
        root ?: return false

        var node = root

        while (node != null) {
            // if matched return
            if (value == node.value) return true

            // if value is less than root.val, look in left tree
            if (value < node.value) {
                node = node.leftChild
            } else {
                node = node.rightChild
            }
        }
        return false
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    @Suppress("ReturnCount")
    private fun remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null

        when {
            value == node.value -> {
                // If leaf node
                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }

                // If one child, return another child to re-connect subtree
                if (node.leftChild == null) {
                    return node.rightChild
                }
                if (node.rightChild == null) {
                    return node.leftChild
                }

                // If there are two childs, look for min in right subtree and swap.
                // Then remove min value
                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }
}
