package com.example.rabbit.service.impl;

import com.example.rabbit.dao.UserMapper;
import com.example.rabbit.domain.User;
import com.example.rabbit.req.user.UserInsertRequest;
import com.example.rabbit.req.user.UserPageRequest;
import com.example.rabbit.req.user.UserQueryRequest;
import com.example.rabbit.req.user.UserUpdateRequest;
import com.example.rabbit.res.user.UserPageResponse;
import com.example.rabbit.res.user.UserQueryResponse;
import com.example.rabbit.service.api.UserService;
import com.example.util.PageService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends PageService implements UserService {

    @Resource private UserMapper userMapper;

    @Autowired private StringRedisTemplate redisTemplate;

    @Override
    public UserQueryResponse query(UserQueryRequest request) {
        UserQueryResponse response = userMapper.query(request);
        return response;
    }

    @Override
    public UserPageResponse queryForPage(UserPageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> userList = userMapper.queryForPage(request);
        UserPageResponse response = getPage(userList, UserPageResponse.class);
        return response;
    }

    @Override
    public String insert(UserInsertRequest request) {
        String result = "success";
        userMapper.insert(request);
        return result;
    }

    @Override
    public String delete(Long id) {
        String result = "success";
        userMapper.delete(id);
        return result;
    }

    @Override
    public String update(UserUpdateRequest request) {
        String result = "success";
        userMapper.update(request);
        return result;
    }
}
