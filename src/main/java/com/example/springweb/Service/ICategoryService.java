package com.example.springweb.Service;

import com.example.springweb.dto.CategoryDto;
import com.example.springweb.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService extends AbstractService<CategoryEntity>{
    public List<CategoryDto>findAll();

    public CategoryEntity Add(CategoryEntity categoryEntity);

    public  void DeleteById(Long id);

}
