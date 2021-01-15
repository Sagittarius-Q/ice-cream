package com.location.iceCream.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String description;

    @OneToMany
    @JoinColumn
    private List<ImageModel> image;
    private int rate;
    @OneToMany
    @JoinColumn(name ="ice_comment")
    private List<Comment> comments;

}
