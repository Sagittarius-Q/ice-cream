package com.location.iceCream.model.binding;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Size;

@Data
public class BindingIceCreamDto {
    @Size(min = 3, max = 30, message
            = "Name must be between 3 and 30 characters")
    private String name;
    private float price;
    @Size(min = 10, max = 200, message
            = "Description must be between 10 and 200 characters")
    private String description;
    private MultipartFile image;
}
