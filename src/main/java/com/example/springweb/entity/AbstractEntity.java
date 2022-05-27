package com.example.springweb.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Builder
@Setter
@Getter
public class AbstractEntity {
    public Long id;
    public Date createData= new Date();
    public Date modifyDate;
    public String createBy;

    public String modifyBy;
}
