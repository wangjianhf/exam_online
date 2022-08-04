package com.exam.online.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogInModel implements Serializable {
    private String username;
    private String password;
}