package com.location.iceCream.service.Comment;

import com.location.iceCream.dao.CommentRepository;
import com.location.iceCream.dao.IceCreamRepository;
import com.location.iceCream.model.dto.CommentServiceModel;
import com.location.iceCream.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final IceCreamRepository iceCreamRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(CommentServiceModel commentServiceModel) {
        Comment comment = modelMapper.map(commentServiceModel, Comment.class);
        comment.setIceCream(iceCreamRepository.findByName(commentServiceModel.getIceCreamName()));
        commentRepository.save(comment);
    }

    @Override
    public List<CommentServiceModel> getByIceCream(String name) {
        List<Comment> comments = commentRepository.getAllByIceCreamName(name);
        return comments
                .stream()
                .map(element -> this.modelMapper.map(element, CommentServiceModel.class))
                .collect(Collectors.toList());
    }
}
