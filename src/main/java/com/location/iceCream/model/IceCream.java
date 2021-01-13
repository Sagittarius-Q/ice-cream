package com.location.iceCream.model;

import lombok.Data;


import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class IceCream {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "seller_iceCream")
    private Seller owner;
    private String description;
    @OneToMany
    @JoinColumn(name = "ice_image")
    private List<ImageModel> image;
    private int rate;
    @OneToMany
    @JoinColumn(name ="ice_comment")
    private List<Comment> comments;

}
