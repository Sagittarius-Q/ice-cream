package com.location.iceCream.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ImageModel {
    @Id
    private Long id;
    private String name;
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "ice_image")
    private IceCream iceCream;
}
