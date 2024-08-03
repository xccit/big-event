package io.xccit.event.entity;


import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName category
*/
public class Category implements Serializable {

    /**
    * ID
    */
    @NotNull(message="[ID]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
    /**
    * 分类名称
    */
    @NotBlank(message="[分类名称]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("分类名称")
    @Length(max= 32,message="编码长度不能超过32")
    private String categoryName;
    /**
    * 分类别名
    */
    @NotBlank(message="[分类别名]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("分类别名")
    @Length(max= 32,message="编码长度不能超过32")
    private String categoryAlias;
    /**
    * 创建人ID
    */
    @NotNull(message="[创建人ID]不能为空")
    @ApiModelProperty("创建人ID")
    private Integer createUser;
    /**
    * 创建时间
    */
    @NotNull(message="[创建时间]不能为空")
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 修改时间
    */
    @NotNull(message="[修改时间]不能为空")
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
    * ID
    */
    private void setId(Integer id){
    this.id = id;
    }

    /**
    * 分类名称
    */
    private void setCategoryName(String categoryName){
    this.categoryName = categoryName;
    }

    /**
    * 分类别名
    */
    private void setCategoryAlias(String categoryAlias){
    this.categoryAlias = categoryAlias;
    }

    /**
    * 创建人ID
    */
    private void setCreateUser(Integer createUser){
    this.createUser = createUser;
    }

    /**
    * 创建时间
    */
    private void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 修改时间
    */
    private void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }


    /**
    * ID
    */
    private Integer getId(){
    return this.id;
    }

    /**
    * 分类名称
    */
    private String getCategoryName(){
    return this.categoryName;
    }

    /**
    * 分类别名
    */
    private String getCategoryAlias(){
    return this.categoryAlias;
    }

    /**
    * 创建人ID
    */
    private Integer getCreateUser(){
    return this.createUser;
    }

    /**
    * 创建时间
    */
    private Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 修改时间
    */
    private Date getUpdateTime(){
    return this.updateTime;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryAlias='" + categoryAlias + '\'' +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
