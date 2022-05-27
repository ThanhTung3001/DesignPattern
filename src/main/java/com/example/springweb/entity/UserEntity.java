package com.example.springweb.entity;

import lombok.*;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Builder
@Entity
@Table(name = "user")
@Getter
@Setter

public class UserEntity{
    //Jpa hibernate ->
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String userName;
    @Column
    private String passWord;
    @Column
    private String fullName;
    @Column
    private String phoneNumber;

    @Column
    private String avatar;

    @ManyToMany(fetch=FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roleEntities=new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<BillEntity>billEntities=new HashSet<>();
    @OneToMany(mappedBy = "userIS")
    private Set<InsuranceEntity>insuranceEntities=new HashSet<>();
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String token = createToken();

    @Transient
    public String createToken (){
        Random random = ThreadLocalRandom.current();
        byte[] randomBytes = new byte[32];
        random.nextBytes(randomBytes);
        String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
        return  encoded;
    }
}