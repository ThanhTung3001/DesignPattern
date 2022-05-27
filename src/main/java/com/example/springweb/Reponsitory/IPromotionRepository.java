package com.example.springweb.Reponsitory;

import com.example.springweb.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPromotionRepository extends JpaRepository<PromotionEntity,Long> {

}
