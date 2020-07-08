package com.example.rabbit.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = -5580486330143250990L;

    private int id;
    private String username;
    private String sex;
    private String address;
}
