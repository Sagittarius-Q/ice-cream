package com.location.iceCream.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.location.iceCream.model.entity.Comment;
import com.location.iceCream.model.entity.ImageModel;
import com.location.iceCream.model.entity.Seller;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
@Data
public class IceCreamServiceModel {
    private Long id;
    private String name;
    private SellerServiceModel owner;
    private float price;
    private String description;
    private List<ImageServiceModel> image;
    private int rate;
    private List<CommentServiceModel> comments;
}
