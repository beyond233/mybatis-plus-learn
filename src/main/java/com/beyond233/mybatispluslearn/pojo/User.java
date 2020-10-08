package com.beyond233.mybatispluslearn.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BEYOND
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    @TableId(type = IdType.ID_WORKER)
    private Long userId;

    private String userPassword;

    private String userName;

    private String userSex;

    private Date userBirth;

    private String userHistory;

    private String userPhone;

    /**创建时间*/
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**修改时间*/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**乐观锁*/
    @Version
    private Integer version;

    /**逻辑删除*/
    @TableLogic
    private Integer deleted;

    private static final long serialVersionUID = 1L;

}