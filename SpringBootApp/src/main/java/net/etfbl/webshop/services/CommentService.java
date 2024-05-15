package net.etfbl.webshop.services;

import net.etfbl.webshop.base.CrudService;
import net.etfbl.webshop.models.dto.CommentDTO;

import java.util.List;

public interface CommentService extends CrudService<Integer> {
    List<CommentDTO> findAllCommentsByOfferId(Integer id);
}
