package com.eyse360.controllers;

import com.eyse360.DAO;
import com.eyse360.models.Check;

import java.util.List;
import java.util.Optional;

public class CheckDAO implements DAO<Check> {
    @Override
    public Optional<Check> get(Check check) {
        return Optional.empty();
    }

    @Override
    public List<Check> getAll() {
        return null;
    }

    @Override
    public int save(Check check) {
        return 0;
    }

    @Override
    public void update(Check check) {

    }

    @Override
    public void delete(Check check) {

    }
}
