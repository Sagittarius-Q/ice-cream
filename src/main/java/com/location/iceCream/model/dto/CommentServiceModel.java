package com.location.iceCream.model.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CommentServiceModel {
    private Long id;
    private String iceCreamName;
    private String text;
    private Date date;
    private String owner;
}
