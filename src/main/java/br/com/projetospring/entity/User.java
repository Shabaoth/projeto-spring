package br.com.projetospring.entity;

import br.com.projetospring.dto.UserCreateUpdateDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class User {
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    private Integer ra;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    @CreatedDate
    private Date dataCriacao;

    public User(UserCreateUpdateDTO userCreateUpdateDTO) {
        this.name = userCreateUpdateDTO.getName();
        this.code = userCreateUpdateDTO.getCode();
        this.ra = userCreateUpdateDTO.getRa();
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getRa() {
        return ra;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}