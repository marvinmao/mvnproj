package com.llnqdx.mvnproj.service;

import com.llnqdx.mvnproj.model.User;

import java.util.List;

/**
 * @author maofujiang
 * @Description:
 * @since 2018/11/12
 */
public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
