package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.CommentDTO;
import net.etfbl.webshop.models.entities.Comment;
import net.etfbl.webshop.services.CommentService;
import org.springframework.web.bind.annotation.*;
import net.etfbl.webshop.base.CrudController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:4200/")
public class CommentController extends CrudController<Integer, Comment, CommentDTO> {

    private final CommentService service;

    protected CommentController(CommentService service) {
        super(CommentDTO.class, service);
        this.service = service;
    }

    @GetMapping("/idOffer/{id}")
    public List<CommentDTO> findByOfferId(@PathVariable Integer id) {
        return service.findAllCommentsByOfferId(id);
    }
}
