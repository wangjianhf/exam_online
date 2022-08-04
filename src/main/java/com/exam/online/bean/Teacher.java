package com.exam.online.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Teacher {
    private Integer teaId;
    private String teaName;
    private String teaAccount;
    private String teaPassword;
    private String teaBriefIntroduction;
}
