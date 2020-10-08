package com.beyond233.mybatispluslearn;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beyond233.mybatispluslearn.mapper.UserMapper;
import com.beyond233.mybatispluslearn.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-05 17:55
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("user_name", "小").eq("user_sex","男");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //子查询
        wrapper.inSql("user_id", "select user_id from user where user_id>2").orderByDesc("user_id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

}
