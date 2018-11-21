package com.llnqdx.mvnproj.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.llnqdx.mvnproj.mapper.UserMapper;
import com.llnqdx.mvnproj.model.User;
import com.llnqdx.mvnproj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maofujiang
 * @Description:
 * @since 2018/11/12
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUser();
        logger.info("findAllUser users[{}]", JSON.toJSONString(users));
        return users;
    }

    @Override
    public String getUser(Integer id) {
        System.out.println("进入到getUser服务实现内 id：" + id);
        if (id == 1) {
            return "Hello,LLL丶禾羊,id:" + id;
        }
        if (id == 2) {
            return "Hello,OSC,id:" + id;
        }
        if (id == 3) {
            return "Hello,开源中国！,id:" + id;
        }
        return null;
    }
}
