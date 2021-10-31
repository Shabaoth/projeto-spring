package br.com.projetospring.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionCreateUpdateDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("value")
    private Double value;

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
}
