package com.eyse360;

import java.util.List;

public interface DAO<T> {
    T get(T t);

    T getById(int id);

    List<T> getAll();

    int save(T t);

    void update(T t);

    void delete(T t);
}
