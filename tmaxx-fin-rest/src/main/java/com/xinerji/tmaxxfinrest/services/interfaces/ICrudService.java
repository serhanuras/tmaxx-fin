package com.xinerji.tmaxxfinrest.services.interfaces;

import java.util.List;
import java.util.Set;

public interface ICrudService<T, Id> {
  List<T> findAll();

  T findById(Id id);

  T save(T object);

  void delete(T object);

  void deleteById(Id id);
}
