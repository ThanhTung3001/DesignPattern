package com.example.springweb.Service;

import java.util.List;

public interface AbstractService<T> {
    void Create(T item);
    void Update(T update,Long id);
    List<T> findById(Long id);
    List<T> findAdd();
}
