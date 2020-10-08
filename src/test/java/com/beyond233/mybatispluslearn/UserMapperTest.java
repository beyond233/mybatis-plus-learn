package com.beyond233.mybatispluslearn;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beyond233.mybatispluslearn.mapper.UserMapper;
import com.beyond233.mybatispluslearn.pojo.User;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.restdocs.mustache.Mustache;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-03 23:57
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    /*
    * 查询
    * */
    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /*
    * 插入
    * */
    @Test
    public void test1(){
        User user = new User();
        user.setUserName("插入测试3");
        user.setUserPhone("18651516161");

        userMapper.insert(user);

    }

    /*
    *更新
    * */
    @Test
    public void test2(){
        User user = new User();
        user.setUserId(1268481312428146690L);
        user.setUserPhone("66666");

        userMapper.updateById(user);
    }

    /*
    * 乐观锁：成功修改
    * */
    @Test
    public void test4(){
        //1.查询
        User user = userMapper.selectById(1L);
        System.out.println(user);
        //2.修改
        user.setUserName("小徐");
        userMapper.updateById(user);
    }

    /*
     * 乐观锁：修改失败
     * */
    @Test
    public void test5(){
//        User user = new User();
//        user.setUserId(1L);
//        user.setUserName("嘻嘻嘻");
//        Runnable runnable1 = () -> userMapper.updateById(user);
//        Runnable runnable2 = () -> {
//            user.setUserName("哈哈哈");
//            userMapper.updateById(user);
//        };
//        Thread thread1 = new Thread(runnable1);
//        Thread thread2 = new Thread(runnable2);
//        thread1.start();
//        thread2.start();
    }

    /**
     * 条件查询
     * */
    @Test
    public void test6(){
//        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name", "插入测试2");
//        map.put("user_sex", "女");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);

    }

    /**
     * 测试分页
     * */
    @Test
    public void test7(){
        Page<User> userPage = new Page<>(1,3);
        IPage<User> userIPage = userMapper.selectPage(userPage, null);
        long size = userIPage.getSize();
        System.out.println(size);
        userIPage.getRecords().forEach(System.out::println);
        System.out.println("userPage.getTotal() = " + userPage.getTotal());
    }

    /**
     * 删除
     * */
    @Test
    public void testDelete(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_name", "插入测试2");
        userMapper.deleteByMap(map);
//        userMapper.deleteById(1268481312428146690L);
    }


















//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatispluslearnApplication.class);
//        UserMapper userMapper = context.getBean(UserMapper.class);
//        User user = new User();
//        user.setUserId(1L);
//        user.setUserName("嘻嘻嘻");
//        Runnable runnable1 = () -> userMapper.updateById(user);
//        Runnable runnable2 = () -> {
//            user.setUserName("哈哈哈");
//            userMapper.updateById(user);
//        };
//        Thread thread1 = new Thread(runnable1,"t1");
//        Thread thread2 = new Thread(runnable2,"t2");
//        thread1.start();
//        thread2.start();
//    }





}
