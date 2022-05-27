package com.example.springweb.Service.imp;

import com.example.springweb.ConvertDto.ConvertDto;
import com.example.springweb.Reponsitory.ICategoryReponsitory;
import com.example.springweb.Service.ICategoryService;
import com.example.springweb.dto.CategoryDto;
import com.example.springweb.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ConvertDto convertDto;
     @Autowired
     private ICategoryReponsitory iCategoryReponsitory;
    @Override
    public List<CategoryDto> findAll() {
              List<CategoryEntity>list=iCategoryReponsitory.findAll();
       return convertDto.toCategoryEntities(list);
    }

    @Override
    public CategoryEntity Add(CategoryEntity categoryEntity) {

        return iCategoryReponsitory.save(categoryEntity);
    }

    @Override
    public void DeleteById(Long id) {
        iCategoryReponsitory.deleteById(id);
    }

    @Override
    public void Create(CategoryEntity item) {

    }

    @Override
    public void Update(CategoryEntity update, Long id) {

    }

    @Override
    public List<CategoryEntity> findById(Long id) {
        return null;
    }

    @Override
    public List<CategoryEntity> findAdd() {
        return null;
    }
}
