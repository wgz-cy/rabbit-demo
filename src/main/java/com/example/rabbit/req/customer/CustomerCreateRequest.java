package com.example.rabbit.req.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateRequest {

    private String name;

    private Integer age;

    private Integer sex;

    private String mobile;
}
