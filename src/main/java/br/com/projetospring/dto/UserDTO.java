package br.com.projetospring.dto;

import br.com.projetospring.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class UserDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ra")
    private int ra;

    @JsonProperty("code")
    private String code;

    @JsonProperty("created_at")
    private LocalDateTime dataCriacao;

    public UserDTO() {

    }

    public UserDTO(UserCreateUpdateDTO userCreateUpdateDTO) {
        this.name = userCreateUpdateDTO.getName();
        this.ra = userCreateUpdateDTO.getRa();
        this.code = userCreateUpdateDTO.getCode();
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.ra = user.getRa();
        this.code = user.getCode();
        this.dataCriacao = LocalDateTime.ofInstant(user.getDataCriacao().toInstant(), ZoneOffset.systemDefault());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
