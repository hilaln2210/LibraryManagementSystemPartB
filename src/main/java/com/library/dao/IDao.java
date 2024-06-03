package com.library.dao;

import java.util.List;

public interface IDao<T> {
    void add(T t);
    T get(int id);
    List<T> getAll();
    void delete(int id);
}
