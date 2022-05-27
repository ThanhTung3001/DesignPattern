package com.example.springweb.Service.imp;

import com.example.springweb.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IBillRepository extends JpaRepository<BillEntity,Long> {
    @Query(value = "SELECT * FROM product  p ,bill  b,bill_product  bp  where p.id=bp.product_id and b.id=bp.bill_id and bill_id=?1 and product_id=?2 and b.user_id=?3",nativeQuery = true)
    Set<BillEntity> findAllByIdAndProductIdAndUserId(Long billId, Long productId, Long userId);
    @Query(value = "select  b.id from bill  b ,bill_product  bp , product  p, user  u where u.user_id=b.user_id and b.id=bp.bill_id and bp.product_id=p.id and u.user_id=?1 and bp.product_id=?2",nativeQuery = true)
    List<Integer> findBillIdByUserIdAndProductId(Long UserId, Long productId);

    List<BillEntity>findAllByUserUserId(Long id);

    
}
