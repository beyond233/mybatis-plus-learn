package com.beyond233.mybatispluslearn.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author beyond233
 * @since 2020-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Department对象", description="")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "department_id", type = IdType.AUTO)
    private Integer departmentId;

    private String departmentName;

    @ApiModelProperty(value = "科室类型")
    private String departmentType;

    @ApiModelProperty(value = "科室信息")
    private String departmentInfo;

    @ApiModelProperty(value = "科室具体地点")
    private String departmentAddr;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer deleted;


}
