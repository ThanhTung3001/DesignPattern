package com.example.springweb.Reponsitory;

import com.example.springweb.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductReponsitory extends JpaRepository<ProductEntity, Long> {
    @Query("select p from ProductEntity p where p.categoryEntity.id = :#{#id}")
    public List<ProductEntity>findAllByIdCategory(@Param("id") Long id);
    @Query("select p from ProductEntity p where p.id = :#{#id}")
    public ProductEntity findAllById(@Param("id") Long id);
    @Query(value = "select p.timeInsurance from ProductEntity p where p.id=:#{#productId}")
    public Integer findTimeByProductId(Long productId);
   // public List<ProductEntity>findTop3ById();

}
