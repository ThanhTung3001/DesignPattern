package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;

    private String userName;

    private String fullName;

    private String phoneNumber;

    private String address;

    private String email;

    private String avatar;
}
