package com.location.iceCream.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    @SequenceGenerator(name = "com", allocationSize = 1)
    @GeneratedValue(generator = "com", strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ice_comment")
    private IceCream iceCream;
    private String text;
    private Date date;
    private String owner;
}
