package ru.otus.java.basic.homeworks.homework_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PersonDataBase {
    private Map<Long, Person> persons;

    public PersonDataBase() {
        this.persons = new HashMap<>();
    }

    public Person findById(Long id) {
        return persons.get(id);
    }
    public void add(Person person) {
        persons.put(person.id, person);
    }
    public boolean isManager(Person person) {
        Set<Position> managementPositions = Set.of(Position.MANAGER, Position.DIRECTOR,
                Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER);
        return managementPositions.contains(person.position);
    }
    public boolean isEmployee(Long id) {
        Person person = findById(id);
        if (person == null) throw new IllegalArgumentException("Данного сотрудника нет в базе данных");
        return !isManager(person);
    }
}
