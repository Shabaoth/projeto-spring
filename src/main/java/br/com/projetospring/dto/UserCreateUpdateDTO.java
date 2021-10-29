package br.com.projetospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreateUpdateDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ra")
    private int ra;

    @JsonProperty("code")
    private String code;

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
}
