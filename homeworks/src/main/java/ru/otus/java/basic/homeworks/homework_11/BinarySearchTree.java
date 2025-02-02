package ru.otus.java.basic.homeworks.homework_11;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree implements SearchTree<Integer> {
    private Node rootNode;

    public BinarySearchTree(List<Integer> sortedList) {
        rootNode = buildTree(sortedList, 0, sortedList.size() - 1);
    }

    private Node buildTree(List<Integer> sortedList, int leftBoarder, int rightBoarder) {
        if (leftBoarder > rightBoarder) {
            return null;
        }
        int middle = leftBoarder + (rightBoarder - leftBoarder) / 2;
        Node node = new Node(sortedList.get(middle));
        node.leftChild = buildTree(sortedList, leftBoarder, middle - 1);
        node.rightChild = buildTree(sortedList, middle + 1, rightBoarder);
        return node;
    }

    @Override
    public Integer find(Integer element) {
        return findRecursive(rootNode, element);
    }

    private Integer findRecursive(Node node, Integer element) {
        if (node == null) {
            return null;
        }
        if (element < node.value) {
            return findRecursive(node.leftChild, element);
        } else if (element > node.value) {
            return findRecursive(node.rightChild, element);
        } else {
            return node.value;
        }
    }

    @Override
    public List<Integer> getSortedList() {
        List<Integer> sortedList = new ArrayList<>();
        traverseInOrder(rootNode, sortedList);
        return sortedList;
    }

    private void traverseInOrder(Node node, List<Integer> sortedList) {
        if (node != null) {
            traverseInOrder(node.leftChild, sortedList);
            sortedList.add(node.value);
            traverseInOrder(node.rightChild, sortedList);
        }
    }
}
