package com.beyond233.mybatispluslearn;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beyond233.mybatispluslearn.mapper.EmployeeMapper;
import com.beyond233.mybatispluslearn.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-04 15:54
 */
@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void test(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        List<Employee> employees = employeeMapper.selectList(null);
        employees.forEach(System.out::println);
    }
}
