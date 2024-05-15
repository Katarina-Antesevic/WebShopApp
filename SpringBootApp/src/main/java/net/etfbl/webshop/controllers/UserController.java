package net.etfbl.webshop.controllers;

import net.etfbl.webshop.models.dto.UserDTO;
import net.etfbl.webshop.models.entities.User;
import net.etfbl.webshop.services.PurchaseService;
import net.etfbl.webshop.services.UserService;
import org.springframework.web.bind.annotation.*;
import net.etfbl.webshop.base.CrudController;
import net.etfbl.webshop.exceptions.NotFoundException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController extends CrudController<Integer, User, UserDTO> {

    private final UserService userAccountService;
    private final PurchaseService purchaseService;

    public UserController(UserService service, PurchaseService purchaseService) {
        super(UserDTO.class, service);
        this.userAccountService = service;
        this.purchaseService = purchaseService;
    }

    @GetMapping("/username/{username}")
    public UserDTO findByUsername(@PathVariable String username) throws NotFoundException {
        return userAccountService.findUserByUsername(username);
    }

}
