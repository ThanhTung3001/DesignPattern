package com.example.springweb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String code;

    private Date createDate = new Date();

    private Date End;

    private Long value;

    private int Amount;

}
