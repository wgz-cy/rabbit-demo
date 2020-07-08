package com.example.rabbit.req.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryRequest {
    private String id;
    private String name;
    private String mobile;
}
