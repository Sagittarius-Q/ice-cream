package com.location.iceCream.model.binding;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class BindingCommentDto {
    private String iceCream;
    @Size(min = 10, max = 200, message
            = "Comment must be between 10 and 200 characters")
    private String text;
    @Size(min = 5, max = 20, message
            = "Name must be between 10 and 200 characters")
    private String owner;
}
