package com.learn.simpleblog.service.web;


import com.learn.simpleblog.api.request.IdRequest;
import com.learn.simpleblog.api.request.UserRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

public interface IIndexUserService {

    Boolean registerUser(UserRequest userRequest) throws Exception;

    Boolean updateUser(UserRequest userRequest) throws Exception;

    String uploadImg(MultipartHttpServletRequest request,Long userId) throws Exception;


    Map<String,Object> getUserMsg(Integer userId) throws Exception;


    Boolean readMsg(IdRequest request, Long userId) throws Exception;

}
