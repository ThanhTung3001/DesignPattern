package com.example.springweb.Service;

import com.example.springweb.entity.InsuranceEntity;

public interface ISuranceService {

    boolean checkInsurance(Long id,Long billId,Long userId);

    public  void save(InsuranceEntity insuranceEntity);
}
