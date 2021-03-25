package com.example.asmspring.dto.person;

import com.example.asmspring.entity.PersonEntity;

import java.util.List;

public class PersonResponse {
    String msg;
    List<PersonEntity> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<PersonEntity> getResult() {
        return result;
    }

    public void setResult(List<PersonEntity> result) {
        this.result = result;
    }
}
