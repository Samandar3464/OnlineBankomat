package uz.pdp.service;

public interface BaseService {
    void show();

    boolean add(String name, byte percentage);

    boolean delete(int id);

    Object update(int id);
}
