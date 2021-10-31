package br.com.projetospring.dto;

import br.com.projetospring.entity.Transaction;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TransactionSimpleDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("created_at")
    private LocalDateTime dataCriacao;

    public TransactionSimpleDTO() {

    }

    public TransactionSimpleDTO(Transaction transaction) {
        this.id = transaction.getId();
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
