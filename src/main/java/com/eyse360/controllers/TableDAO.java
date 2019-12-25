package com.eyse360.controllers;

import com.eyse360.DAO;
import com.eyse360.models.Table;

import java.util.List;
import java.util.Optional;

public class TableDAO implements DAO<Table> {
    @Override
    public Optional<Table> get(Table table) {
        return Optional.empty();
    }

    @Override
    public List<Table> getAll() {
        return null;
    }

    @Override
    public int save(Table table) {
        return 0;
    }

    @Override
    public void update(Table table) {

    }

    @Override
    public void delete(Table table) {

    }
}
