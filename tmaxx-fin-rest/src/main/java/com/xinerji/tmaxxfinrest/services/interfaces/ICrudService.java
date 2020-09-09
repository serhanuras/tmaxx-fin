package com.xinerji.tmaxxfinrest.services.interfaces;

import java.util.Set;

public interface ICrudService<T,Id> {
    Set<T> findAll();

    T findById(Id id);

    T save(T object);

    void delete(T object);

    void deleteById(Id id);
}
