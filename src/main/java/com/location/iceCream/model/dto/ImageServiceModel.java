package com.location.iceCream.model.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class ImageServiceModel {
    private Long id;
    private String name;
    private MultipartFile image;
    private IceCreamServiceModel iceCream;
}
