package ru.gb.Bootcamp.Algorithms;

public class BinaryTree {

    private Node root;

    public boolean add(int value){
        if (root == null){
            root = new Node();
            root.value = value;
            return true;
        } else {
            return createNode(root, value);
        }
    }

    public boolean exist (int value){
        final Node node = findNode(root, value);
        return node != null;
    }

    private boolean createNode(Node node, int value){
        if (node.value == value){
            return false;
        }
        if (node.value > value){
            if (node.leftChild != null){
                return createNode(node.leftChild, value);
            } else {
                node.leftChild = new Node();
                node.leftChild.value = value;
                return true;
            }
        } else {
            if (node.rightChild != null){
                return createNode(node.rightChild, value);
            } else {
                node.rightChild = new Node();
                node.rightChild.value = value;
                return true;
            }
        }
    }

    private Node findNode(Node node, int value){
        if (node.value == value){
            return node;
        } else {
            if (node.value > value){
                if (node.leftChild != null){
                    return findNode(node.leftChild, value);
                } else {
                    return null;
                }
            } else {
                if (node.rightChild != null){
                    return findNode(node.rightChild, value);
                } else {
                    return null;
                }
            }
        }
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
    }
}
