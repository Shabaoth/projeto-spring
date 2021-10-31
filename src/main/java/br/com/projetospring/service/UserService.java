package br.com.projetospring.service;

import br.com.projetospring.dto.UserCreateUpdateDTO;
import br.com.projetospring.dto.UserDTO;
import br.com.projetospring.dto.UserSimpleDTO;
import br.com.projetospring.dto.UserTransactionDTO;

import java.util.List;

public interface UserService {
    List<UserSimpleDTO> list(String name);
    UserTransactionDTO getUserTransactionsByUserId(Integer id);
    UserDTO findById(Integer id);
    UserDTO create(UserCreateUpdateDTO userCreateUpdateDTO);
    UserDTO update(Integer id, UserCreateUpdateDTO userCreateUpdateDTO);
    void delete(Integer id);
}
