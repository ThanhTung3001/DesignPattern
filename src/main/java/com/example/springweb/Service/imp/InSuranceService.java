package com.example.springweb.Service.imp;

import com.example.springweb.Reponsitory.IProductReponsitory;
import com.example.springweb.Reponsitory.ISuranceRepository;
import com.example.springweb.Service.IBillService;
import com.example.springweb.Service.ISuranceService;
import com.example.springweb.entity.InsuranceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class InSuranceService implements ISuranceService {

   @Autowired
    ISuranceRepository iSuranceRepository;
   @Autowired
    IProductReponsitory iProductReponsitory;
   @Autowired
    IBillService iBillService;
    @Override
    public boolean checkInsurance(Long id,Long billId,Long userId) {
        Integer timeSurance=iProductReponsitory.findTimeByProductId(id);
        System.out.println(timeSurance);
        AtomicLong timeS=iBillService.getTimeInSurance(id,billId,userId);
        if(timeS.intValue()==-1){
            return false;
        }
        if(timeS.intValue()-timeSurance>0){
            return false;
        }
        return true;
    }

    @Override
    public void save(InsuranceEntity insuranceEntity) {
        iSuranceRepository.save(insuranceEntity);
    }
}
