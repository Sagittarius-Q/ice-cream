package com.location.iceCream.model.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Data
public class ImageServiceModel {
    private Long id;
    private String name;
    @NotEmpty
    private MultipartFile image;
    private IceCreamServiceModel iceCream;
}
