package br.com.projetospring.dto;

import br.com.projetospring.entity.Transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TransactionDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("created_at")
    private LocalDateTime dataCriacao;

    public TransactionDTO() {

    }

    public TransactionDTO(TransactionCreateUpdateDTO transactionCreateUpdateDTO) {
        this.userId = transactionCreateUpdateDTO.getUserId();
        this.entityName = transactionCreateUpdateDTO.getEntityName();
        this.value = transactionCreateUpdateDTO.getValue();
    }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.userId = transaction.getUser().getId();
        this.entityName = transaction.getEntityName();
        this.value = transaction.getValue();
        this.dataCriacao = LocalDateTime.ofInstant(transaction.getDataCriacao().toInstant(), ZoneOffset.systemDefault());
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
