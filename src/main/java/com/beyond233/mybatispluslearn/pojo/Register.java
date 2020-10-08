package com.beyond233.mybatispluslearn.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233 <a href="https://github.com/beyond233/"></a>
 * @version 1.0
 * @since 2020-06-04 15:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("register")
public class Register implements Serializable {
    @TableId
    private Integer registerId;

    private Integer departmentId;

    private Integer empId;

    private Date registerDate;

    private Double registerPrice;

    private Integer registerAmount;

    private Integer registerBalance;
}
