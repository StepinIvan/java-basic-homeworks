package ru.otus.java.basic.homeworks.homework_11;

import java.util.List;

public interface SearchTree<Integer> {
    /**
     * @param element to find
     * @return element if exists, otherwise - null
     */
    Integer find(Integer element);

    List<Integer> getSortedList();
}
