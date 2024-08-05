package io.xccit.event.entity;


import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    public interface Insert {}
    public interface Update {}

    /**
    * ID
    */
    @NotNull(message="[ID]不能为空", groups = {Update.class})
    @ApiModelProperty("ID")
    private Integer id;
    /**
    * 分类名称
    */
    @NotBlank(message="[分类名称]不能为空",groups = {Insert.class, Update.class})
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("分类名称")
    @Length(max= 32,message="编码长度不能超过32")
    private String categoryName;
    /**
    * 分类别名
    */
    @NotBlank(message="[分类别名]不能为空",groups = {Insert.class, Update.class})
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("分类别名")
    @Length(max= 32,message="编码长度不能超过32")
    private String categoryAlias;
    /**
    * 创建人ID
    */
    @ApiModelProperty("创建人ID")
    private Integer createUser;
    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
    * 修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    /**
    * ID
    */
    public void setId(Integer id){
    this.id = id;
    }

    /**
    * 分类名称
    */
    public void setCategoryName(String categoryName){
    this.categoryName = categoryName;
    }

    /**
    * 分类别名
    */
    public void setCategoryAlias(String categoryAlias){
    this.categoryAlias = categoryAlias;
    }

    /**
    * 创建人ID
    */
    public void setCreateUser(Integer createUser){
    this.createUser = createUser;
    }

    /**
    * 创建时间
    */
    public void setCreateTime(LocalDateTime createTime){
    this.createTime = createTime;
    }

    /**
    * 修改时间
    */
    public void setUpdateTime(LocalDateTime updateTime){
    this.updateTime = updateTime;
    }


    /**
    * ID
    */
    public Integer getId(){
    return this.id;
    }

    /**
    * 分类名称
    */
    public String getCategoryName(){
    return this.categoryName;
    }

    /**
    * 分类别名
    */
    public String getCategoryAlias(){
    return this.categoryAlias;
    }

    /**
    * 创建人ID
    */
    public Integer getCreateUser(){
    return this.createUser;
    }

    /**
    * 创建时间
    */
    public LocalDateTime getCreateTime(){
    return this.createTime;
    }

    /**
    * 修改时间
    */
    public LocalDateTime getUpdateTime(){
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
