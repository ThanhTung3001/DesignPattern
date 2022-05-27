package com.example.springweb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Long id;

    public String link;

    @ManyToMany(mappedBy = "images",cascade = CascadeType.ALL)
    public List<ProductEntity>productEntities;

    public ImageEntity(){

    }
    public ImageEntity(String link){
         this.link =link;
    }

}
