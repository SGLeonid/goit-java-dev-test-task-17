package org.forestwizard.goitjavadevtesttask17.service;

import org.forestwizard.goitjavadevtesttask17.exception.DatabaseServiceException;

import java.util.List;

public interface ICrudService<T, K> {
    List<T> listAll();
    T add(T obj);
    void deleteById(K id) throws DatabaseServiceException;
    void update(T obj) throws DatabaseServiceException;
    T getById(K id) throws DatabaseServiceException;
}
