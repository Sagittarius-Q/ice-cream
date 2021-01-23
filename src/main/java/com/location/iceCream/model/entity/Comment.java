package com.location.iceCream.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private IceCream iceCream;
    private String text;
    private Date date;
    private String owner;
}
