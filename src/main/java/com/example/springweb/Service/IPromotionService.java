package com.example.springweb.Service;

import com.example.springweb.entity.PromotionEntity;

import java.util.List;

public interface IPromotionService {
    public void Delete(Long id);
    public PromotionEntity Add(PromotionEntity promotionEntity);

    public List<PromotionEntity>getAll();

}
