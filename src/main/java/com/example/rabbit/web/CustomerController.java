package com.example.rabbit.web;

import com.example.rabbit.req.customer.CustomerCreateRequest;
import com.example.rabbit.req.customer.CustomerPageRequest;
import com.example.rabbit.res.customer.CustomerCreateResponse;
import com.example.rabbit.res.customer.CustomerPageResponse;
import com.example.rabbit.service.api.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CustomerController {

    @Resource private CustomerService customerService;

    @PostMapping("/customer/createCustomer")
    public CustomerCreateResponse createCustomer(@RequestBody CustomerCreateRequest request) {
        return customerService.createCustomer(request);
    }

    @PostMapping("/customer/queryCustomerPage")
    public CustomerPageResponse queryCustomerForPage(@RequestBody CustomerPageRequest request) {
        return customerService.queryCustomerForPage(request);
    }
}
