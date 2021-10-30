package br.com.projetospring;

import br.com.projetospring.controller.UserController;
import br.com.projetospring.dto.UserDTO;
import br.com.projetospring.dto.UserSimpleDTO;
import br.com.projetospring.entity.User;
import br.com.projetospring.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserControllerTest {

    @Test
    public void shouldFilterByName() {

        UserSimpleDTO userDTO = new UserSimpleDTO();
        userDTO.setId(1);
        userDTO.setName("teste");
        userDTO.setCode("123456");
        userDTO.setRa(123456);

        UserServiceImpl userService = new UserServiceImpl();
        List<UserSimpleDTO> usersList = userService.list("teste");

        assertThat(usersList.size(), equalTo(1));
        assertThat(usersList.get(0).getName(), equalTo("teste"));
        assertThat(usersList.get(0).getRa(), equalTo(12345));

    }

}
