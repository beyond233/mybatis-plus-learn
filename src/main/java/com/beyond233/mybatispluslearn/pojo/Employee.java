package com.beyond233.mybatispluslearn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-04 15:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("emp")
public class Employee implements Serializable {
    @TableId
    private Integer empId;

    private String empPassword;

    private String empName;

    private String empSex;

    private Integer empAge;

    private String empPhone;

    private String empCareer;

    private String empTitle;

    private Integer departmentId;

    private String empAwards;

    private Integer roleId;

    private String empIntro;

    private String empMajor;
}
