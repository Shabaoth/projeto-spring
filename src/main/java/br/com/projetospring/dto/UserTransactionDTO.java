package br.com.projetospring.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.projetospring.entity.User;

import java.util.List;

public class UserTransactionDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ra")
    private int ra;

    @JsonProperty("code")
    private String code;

    @JsonProperty("transactions")
    private List<TransactionSimpleDTO> transactionDTOs;

    public UserTransactionDTO() {
    }

    public UserTransactionDTO(User user) {
        this.id = user.getId();
        this.code = user.getCode();
        this.name = user.getName();
        this.ra = user.getRa();
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

    public String getCode() {
        return code;
    }

    public Integer getRa() {
        return ra;
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
    public List<TransactionSimpleDTO> getTransactionDTOs() {
        return this.transactionDTOs;
    }

    public void setTransactionDTOs(List<TransactionSimpleDTO> transactionDTOs) {
        this.transactionDTOs = transactionDTOs;
    }
}
