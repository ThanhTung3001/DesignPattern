package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {
    private Long id;
    private Date timeInsuDate;
}
