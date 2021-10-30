package br.com.projetospring.controller;

import br.com.projetospring.dto.UserCreateUpdateDTO;
import br.com.projetospring.dto.UserDTO;
import br.com.projetospring.dto.UserSimpleDTO;
import br.com.projetospring.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = {"users"})
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all users.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public List<UserSimpleDTO> list(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return userService.list(name);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single user.", notes = "You have to provide a valid post ID.")
    public UserDTO findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a user resource.")
    public UserDTO create(@RequestBody UserCreateUpdateDTO userCreateUpdateDTO) {
        return userService.create(userCreateUpdateDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a user resource.", notes = "You have to provide a valid user ID in the URL and in the payload. The ID attribute can not be updated.")
    public UserDTO update(@PathVariable Integer id, @RequestBody UserCreateUpdateDTO userCreateUpdateDTO) {
        return userService.update(id, userCreateUpdateDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a user resource.", notes = "You have to provide a valid user ID in the URL. Once deleted the resource can not be recovered.")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
