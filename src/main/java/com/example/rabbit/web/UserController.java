package com.example.rabbit.web;

import com.example.rabbit.req.user.UserInsertRequest;
import com.example.rabbit.req.user.UserPageRequest;
import com.example.rabbit.req.user.UserQueryRequest;
import com.example.rabbit.req.user.UserUpdateRequest;
import com.example.rabbit.res.user.UserPageResponse;
import com.example.rabbit.res.user.UserQueryResponse;
import com.example.rabbit.service.api.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource private UserService userService;

    @PostMapping("/user/query")
    public UserQueryResponse query(@RequestBody UserQueryRequest request) {
        return userService.query(request);
    }

    @PostMapping("/user/queryForPage")
    public UserPageResponse queryForPage(@RequestBody UserPageRequest request) {
        return userService.queryForPage(request);
    }

    @RequestMapping("/user/insert")
    public String insert(@RequestBody UserInsertRequest request) {
        return userService.insert(request);
    }

    @RequestMapping("/user/delete")
    public String delete(@RequestBody Long id) {
        userService.delete(id);
        return "successful delete";
    }

    @RequestMapping("/user/update")
    public String update(@RequestBody UserUpdateRequest request) {
        return userService.update(request);
    }
}
