package com.example.springweb.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@ToString
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_sell;
    @Column
    private String name;
    @Column
    private Long price;
    @Column
    private int quantity;
    @Column
    private String image;
    @Column
    private  int timeInsurance;
    @Size(min=100,max=4000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CategoryEntity categoryEntity;
    @ManyToMany(mappedBy = "productEntities")
    @EqualsAndHashCode.Exclude
    private Collection<BillEntity> billEntities;
    @ManyToMany(mappedBy = "productE")
    @EqualsAndHashCode.Exclude
    private Set<InsuranceEntity> insuranceEntities=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_img",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "img_id"))
    public List<ImageEntity> images= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "product_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "Size_id")
    )
    public List<SizeEnity> sizeEnities = new ArrayList<>();
}
