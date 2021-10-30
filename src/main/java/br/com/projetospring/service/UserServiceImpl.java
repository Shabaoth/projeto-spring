package br.com.projetospring.service;

import br.com.projetospring.dto.UserCreateUpdateDTO;
import br.com.projetospring.dto.UserDTO;
import br.com.projetospring.dto.UserSimpleDTO;
import br.com.projetospring.entity.User;
import br.com.projetospring.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component("userService")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserSimpleDTO> list(String name) {
        return userRepository.findAllByNameStartsWith(name)
                .stream()
                .map(UserSimpleDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Integer id) {
        User user = getUserById(id);
        return new UserDTO(user);
    }

    @Override
    public UserDTO create(UserCreateUpdateDTO userCreateUpdateDTO) {
        User user = new User(userCreateUpdateDTO);

        User userSaved = userRepository.save(user);
        return new UserDTO(userSaved);
    }

    @Override
    public UserDTO update(Integer id, UserCreateUpdateDTO userCreateUpdateDTO) {
        User user = getUserById(id);
        user.setName(userCreateUpdateDTO.getName());
        user.setCode(userCreateUpdateDTO.getCode());
        user.setRa(userCreateUpdateDTO.getRa());

        User musicaSaved = userRepository.save(user);
        return new UserDTO(musicaSaved);
    }

    @Override
    public void delete(Integer id) {
        getUserById(id);
        userRepository.deleteById(id);
    }

    private User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user.not.found"));
    }
}
