package net.etfbl.webshop.services;

import net.etfbl.webshop.base.CrudService;
import net.etfbl.webshop.exceptions.NotFoundException;
import net.etfbl.webshop.models.dto.UserDTO;

public interface UserService extends CrudService<Integer> {

    UserDTO findUserByUsername(String username) throws NotFoundException;
}
