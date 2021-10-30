package br.com.projetospring.controller;

import br.com.projetospring.dto.UserCreateUpdateDTO;
import br.com.projetospring.dto.UserDTO;
import br.com.projetospring.dto.UserSimpleDTO;
import br.com.projetospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserSimpleDTO> list(
            @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        return userService.list(name);
    }

    @GetMapping("{id}")
    public UserDTO findById(
            @PathVariable Integer id
    ) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(
            @RequestBody UserCreateUpdateDTO userCreateUpdateDTO
    ) {
        return userService.create(userCreateUpdateDTO);
    }

    @PutMapping("{id}")
    public UserDTO update(
            @PathVariable Integer id,
            @RequestBody UserCreateUpdateDTO userCreateUpdateDTO
    ) {
        return userService.update(id, userCreateUpdateDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Integer id
    ) {
        userService.delete(id);
    }
}
