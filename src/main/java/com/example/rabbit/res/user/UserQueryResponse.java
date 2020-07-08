package com.example.rabbit.res.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryResponse {
    private String success;
    private String id;
    private String username;
    private String sex;
    private String address;

}
