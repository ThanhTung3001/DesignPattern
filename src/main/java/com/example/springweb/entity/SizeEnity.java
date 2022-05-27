package com.example.springweb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "size")
public class SizeEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String size;
    @ManyToMany(mappedBy = "sizeEnities")
    public List<ProductEntity>productEntities;
    public  int numberOf;
    
    public String color;

}
