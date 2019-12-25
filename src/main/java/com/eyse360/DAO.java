package com.eyse360;

import com.eyse360.models.Bar;
import com.eyse360.models.BarUser;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    T get(T t);

    T getById(int id);

    List<T> getAll();

    int save(T t);

    void update(T t);

    void delete(T t);
}
