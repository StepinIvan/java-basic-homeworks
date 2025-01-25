package ru.otus.java.basic.homeworks.homework_11;

import lombok.Getter;

public class Node {
    Integer value;
    Node leftChild;
    Node rightChild;

    Node(Integer value) {
        this.value = value;
    }
}
