package com.example.rabbit.service.api;

import com.example.rabbit.req.user.UserInsertRequest;
import com.example.rabbit.req.user.UserPageRequest;
import com.example.rabbit.req.user.UserQueryRequest;
import com.example.rabbit.req.user.UserUpdateRequest;
import com.example.rabbit.res.user.UserPageResponse;
import com.example.rabbit.res.user.UserQueryResponse;

public interface UserService {

    UserQueryResponse query(UserQueryRequest request);

    UserPageResponse queryForPage(UserPageRequest request);

    String insert(UserInsertRequest request);

    String delete(Long id);

    String update(UserUpdateRequest request);
}
