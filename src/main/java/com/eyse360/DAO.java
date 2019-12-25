package com.eyse360;

import com.eyse360.models.Bar;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(T t);

    List<T> getAll();

    int save(T t);

    void update(T t);

    void delete(T t);
}
