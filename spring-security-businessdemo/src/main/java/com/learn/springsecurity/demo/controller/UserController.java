package com.learn.springsecurity.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.learn.springsecurity.demo.dto.User;
import com.learn.springsecurity.demo.dto.UserQueryCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * autor:liman
 * createtime:2021/6/29
 * comment:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * Pageable 用于分页的对象，如果用的是spring-data 这个会很方便
     *
     * @param userQueryCondition
     * @param pageable
     * @return
     */
    @GetMapping(value = "")
    @JsonView(User.userSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition, @PageableDefault(page = 1, size = 17) Pageable pageable) {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.userDetailView.class)
    public User getUserById(@PathVariable(name = "id") String id) {
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream().forEach(e->{System.out.println(e.getDefaultMessage());});
        }
        log.info("前端上送的用户信息为:{}",user);
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

}
