package com.eyse360.controllers;

import com.eyse360.DAO;
import com.eyse360.models.BarUser;

import java.util.List;
import java.util.Optional;

public class BarUserDAO implements DAO<BarUser> {
    @Override
    public Optional<BarUser> get(BarUser barUser) {
        return Optional.empty();
    }

    @Override
    public List<BarUser> getAll() {
        return null;
    }

    @Override
    public int save(BarUser barUser) {
        return 0;
    }

    @Override
    public void update(BarUser barUser) {

    }

    @Override
    public void delete(BarUser barUser) {

    }
}
