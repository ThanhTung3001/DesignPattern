package com.example.springweb.Reponsitory;

import com.example.springweb.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryReponsitory extends JpaRepository<CategoryEntity, Long> {


}
