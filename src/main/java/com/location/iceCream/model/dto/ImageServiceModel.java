package com.location.iceCream.model.dto;

import com.location.iceCream.model.entity.IceCream;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.IOException;
@Data
public class ImageServiceModel {
    private Long id;
    private String name;
    private MultipartFile image;
    private IceCream iceCream;
}
