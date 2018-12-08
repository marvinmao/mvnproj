package com.llnqdx.mvnproj.web;

import com.alibaba.fastjson.JSON;
import com.llnqdx.mvnproj.model.User;
import com.llnqdx.mvnproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author marvinmao
 * @Description:
 * @since 2018/11/12
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json"})
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET, produces = {"application/json"})
    public String findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        List<User> allUser = userService.findAllUser(pageNum, pageSize);
        return JSON.toJSONString(allUser);
    }

    @GetMapping("hello")
    public String hello() {
        return "hello !";
    }
}
