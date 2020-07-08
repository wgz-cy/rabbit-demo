package com.example.rabbit.dao;

import com.example.rabbit.domain.User;
import com.example.rabbit.req.user.UserInsertRequest;
import com.example.rabbit.req.user.UserPageRequest;
import com.example.rabbit.req.user.UserQueryRequest;
import com.example.rabbit.req.user.UserUpdateRequest;
import com.example.rabbit.res.user.UserQueryResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserQueryResponse query(UserQueryRequest request);

    List<User> queryForPage(UserPageRequest request);

    void insert(UserInsertRequest request);

    void delete(Long id);

    void update(UserUpdateRequest request);

}
