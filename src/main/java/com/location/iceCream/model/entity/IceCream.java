package com.location.iceCream.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;


import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class IceCream {
    @Id
    @SequenceGenerator(name = "ice", allocationSize = 1)
    @GeneratedValue(generator = "ice", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller owner;
    private float price;
    private String description;

    @OneToMany
    @JoinColumn
    private List<ImageModel> image;
    private int rate;
    @OneToMany
    @JoinColumn
    private List<Comment> comments;

}
