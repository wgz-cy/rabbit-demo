package com.example.rabbit.req.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserInsertRequest implements Serializable {
    private static final long serialVersionUID = 8851793375907768643L;

    private String username;

    private String sex;

    private String address;

    private String birthday;

}
