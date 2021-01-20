package com.location.iceCream.model.dto;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;
@Data
public class CommentServiceModel {
    private Long id;
    private IceCreamServiceModel iceCreamServiceModel;
    @Size(min = 10, max = 200, message
            = "Comment must be between 10 and 200 characters")
    private String text;
    private Date date;
    @Size(min = 5, max = 20, message
            = "Name must be between 10 and 200 characters")
    private String owner;
}
