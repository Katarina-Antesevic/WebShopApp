package net.etfbl.webshop.services.impl;

import net.etfbl.webshop.base.CrudJpaService;
import net.etfbl.webshop.models.dto.CommentDTO;
import net.etfbl.webshop.models.entities.Comment;
import net.etfbl.webshop.repositories.CommentRepository;
import net.etfbl.webshop.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentServiceImpl extends CrudJpaService<Comment, Integer> implements CommentService {
    private final CommentRepository repository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository repository, ModelMapper modelMapper) {
        super(repository, Comment.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentDTO> findAllCommentsByOfferId(Integer id) {
        return repository.findAllCommentsByIdOffer(id).stream().map(e -> modelMapper.map(e, CommentDTO.class)).collect(Collectors.toList());
    }
}
