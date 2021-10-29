package br.com.projetospring.service;

import br.com.projetospring.dto.UserCreateUpdateDTO;
import br.com.projetospring.dto.UserDTO;
import br.com.projetospring.dto.UserSimpleDTO;

import java.util.List;

public interface  UserService {
    List<UserSimpleDTO> list(String name);
    UserDTO findById(Integer id);
    UserDTO create(UserCreateUpdateDTO userCreateUpdateDTO);
    UserDTO update(Integer id, UserCreateUpdateDTO userCreateUpdateDTO);
    void delete(Integer id);
}
