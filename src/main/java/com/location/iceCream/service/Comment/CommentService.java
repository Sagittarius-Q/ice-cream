package com.location.iceCream.service.Comment;

import com.location.iceCream.model.dto.CommentServiceModel;

import java.util.List;

public interface CommentService {
    public void save(CommentServiceModel commentServiceModel);
    public List<CommentServiceModel> getByIceCream(String name);
}
