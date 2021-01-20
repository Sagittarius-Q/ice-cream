package com.location.iceCream.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
public class IceCreamServiceModel {
    private Long id;
    @Size(min = 3, max = 30, message
            = "Name must be between 3 and 30 characters")
    private String name;
    private SellerServiceModel owner;
    private float price;
    @Size(min = 10, max = 200, message
            = "Description must be between 10 and 200 characters")
    private String description;
    @NotNull
    private List<ImageServiceModel> image;
    private int rate;
    private List<CommentServiceModel> comments;
}
