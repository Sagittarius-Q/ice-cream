package com.location.iceCream.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ice_comment")
    private IceCream iceCream;
    private String text;
    private Date date;
    private String owner;
}
