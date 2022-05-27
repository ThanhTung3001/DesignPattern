package com.example.springweb.entity;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long total;
    @Column
    private Date timeSell=new Date();
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private UserEntity user;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "bill_product",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    private Set<ProductEntity> productEntities=new HashSet<>();


    private String status ="Buy";

    private boolean StatusDelivery;
}