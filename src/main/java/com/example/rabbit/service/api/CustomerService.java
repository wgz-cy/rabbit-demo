package com.example.rabbit.service.api;

import com.example.rabbit.req.customer.CustomerCreateRequest;
import com.example.rabbit.req.customer.CustomerPageRequest;
import com.example.rabbit.res.customer.CustomerCreateResponse;
import com.example.rabbit.res.customer.CustomerPageResponse;

public interface CustomerService {

    CustomerCreateResponse createCustomer(CustomerCreateRequest request);

    CustomerPageResponse queryCustomerForPage(CustomerPageRequest request);
}
