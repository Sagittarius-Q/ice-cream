package com.location.iceCream.model.dto;

import lombok.Data;


import java.util.List;
@Data
public class IceCreamServiceModel {
    private Long id;
    private String name;
    private SellerServiceModel owner;
    private float price;
    private String description;
    private byte[] image;
    private int rate;
    private List<CommentServiceModel> comments;
}
