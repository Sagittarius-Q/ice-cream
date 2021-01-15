package com.location.iceCream.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.Base64;

@Data
@Entity
public class ImageModel {
    @Id
    @SequenceGenerator(name = "img", allocationSize = 1)
    @GeneratedValue(generator = "img", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private byte[] image;
    @ManyToOne
    @JoinColumn(name = "ice_cream_id")
    private IceCream iceCream;
    public void insertImage(MultipartFile photo)throws IOException{
        this.image = photo.getBytes();
    }
}
