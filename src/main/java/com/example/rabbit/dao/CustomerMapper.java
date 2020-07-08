package com.example.rabbit.dao;

import com.example.rabbit.domain.Customer;
import com.example.rabbit.req.customer.CustomerCreateRequest;
import com.example.rabbit.req.customer.CustomerPageRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    void insert(CustomerCreateRequest request);

    List<Customer> queryForPage(CustomerPageRequest request);


}
