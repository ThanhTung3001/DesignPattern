package com.example.springweb.Service.imp;

import com.example.springweb.Reponsitory.IProductReponsitory;
import com.example.springweb.Service.IBillService;
import com.example.springweb.entity.BillEntity;
import com.example.springweb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BillService implements IBillService {

    @Autowired
    private IProductReponsitory iProductReponsitory;

    @Autowired
    private IBillRepository iBillRepository;
    @Override
    public void save(BillEntity billEntity) {
        iBillRepository.save(billEntity);
    }
    public static java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
    @Override
    public AtomicLong getTimeInSurance(Long productId, Long billId, Long userID) {
        AtomicLong dateFrom= new AtomicLong(-1);
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
        Date date = new Date();
        Set<BillEntity>sets=iBillRepository.findAllByIdAndProductIdAndUserId(billId,productId,userID);
        sets.forEach(billEntity -> {
            Date date1  = billEntity.getTimeSell();
        long  daysBetween = ChronoUnit.MONTHS.between(LocalDate.parse(formatter.format(date1)),
                    LocalDate.parse(formatter.format(date)));
             dateFrom.set(daysBetween);
        });
        return dateFrom;
    }
//xomg rồ truyeenmf lộn tham sso
    @Override
    public Integer findBillId(Long userId, Long productId) {

        List<Integer> result =iBillRepository.findBillIdByUserIdAndProductId(userId,productId);
        Integer data= result.get(result.size()-1);
        return data;
    }

    @Override
    public List<BillEntity> getAll() {
        return iBillRepository.findAll();
    }

    @Override
    public BillEntity UpdateById(BillEntity billEntity, Long id) {
        BillEntity billEntity1 = iBillRepository.findById(id).get();
        billEntity.setId(billEntity1.getId());

        return    iBillRepository.save(billEntity);
    }

    @Override
    public BillEntity findByIdBill(Long id) {
        return iBillRepository.findById(id).get();
    }
}
