package ru.otus.java.basic.homeworks.homework_7;

public interface Transport {
    String getIdentifier();
    void setUser(Human user);
    boolean useTransport(Landscape landscape, int distance);
}
