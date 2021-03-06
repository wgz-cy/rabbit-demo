package com.example.rabbit.service.impl;

import com.example.rabbit.dao.CustomerMapper;
import com.example.rabbit.domain.Customer;
import com.example.rabbit.req.customer.CustomerCreateRequest;
import com.example.rabbit.req.customer.CustomerPageRequest;
import com.example.rabbit.res.customer.CustomerCreateResponse;
import com.example.rabbit.res.customer.CustomerPageResponse;
import com.example.rabbit.service.api.CustomerService;
import com.example.util.PageService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl extends PageService implements CustomerService {

    @Resource private CustomerMapper customerMapper;

    @Resource private StringRedisTemplate redisTemplate;

    @Override
    public CustomerCreateResponse createCustomer(CustomerCreateRequest request) {
        CustomerCreateResponse response = new CustomerCreateResponse();
        customerMapper.insert(request);
        response.setSuccess("我艹！成功啦！");
        return response;
    }

    @Override
    public CustomerPageResponse queryCustomerForPage(CustomerPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Customer> customerList = customerMapper.queryForPage(request);
        CustomerPageResponse response = getPage(customerList, CustomerPageResponse.class);
        return response;
    }

    public static void main(String[] args) {
        String url = "www.dalangchiyao.com";
        try {
            MessageDigest  md5 = MessageDigest.getInstance("MD5");
            md5.update(url.getBytes("UTF-8"));
            byte[] b = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++){
                i = b[offset];
                if(i < 0 ){
                    i+= 256;
                }
                if(i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            url = buf.toString();
            System.out.println("result = " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
