package com.example.ae.repositories.Base;


import java.util.List;
import java.util.Optional;

public interface BaseRepoInterface<T> {
    T save(T object);
    List<T> findAll();
    Optional<T> findById(Long id);
    void deleteById(Long id);
    T updateById(Long id, T objectDetails);

}
