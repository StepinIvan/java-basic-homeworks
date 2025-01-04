package ru.otus.java.basic.homeworks.homework_11;

import java.util.HashMap;
import java.util.Map;

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
        return person.position == Position.MANAGER || person.position == Position.DIRECTOR ||
                person.position == Position.BRANCH_DIRECTOR || person.position == Position.SENIOR_MANAGER;
    }
    public boolean isEmployee(Long id) {
        Person person = findById(id);
        if (person == null) throw new NullPointerException("Данного сотрудника нет в базе данных");
        return !isManager(person);
    }
}
