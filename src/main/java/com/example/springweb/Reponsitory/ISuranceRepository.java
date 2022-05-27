package com.example.springweb.Reponsitory;

import com.example.springweb.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuranceRepository extends JpaRepository<InsuranceEntity,Long> {
   /* @Query(value = "select b.timeSell from BillEntity b where ProductEntity.id=:#{#productId} and b.id=:#{#billId} and UserEntity .userId=:#{#userID}")
    Date findDateBy(Long productId,Long billId,Long userID);*/

}
