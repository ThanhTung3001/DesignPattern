package com.example.springweb.Service.imp;

import com.example.springweb.Reponsitory.IPromotionRepository;
import com.example.springweb.Service.IPromotionService;
import com.example.springweb.entity.PromotionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    IPromotionRepository iPromotionRepository ;


    @Override
    public void Delete(Long id) {
        iPromotionRepository.deleteById(id);
    }

    @Override
    public PromotionEntity Add(PromotionEntity promotionEntity) {
        return iPromotionRepository.save(promotionEntity);
    }

    @Override
    public List<PromotionEntity> getAll() {
        return iPromotionRepository.findAll();
    }
}
