package io.xccit.event.entity;

import java.io.Serializable;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

/**
* 用户表
* @TableName user
*/
public class User implements Serializable {

    /**
    * ID
    */
    @NotNull(message="[ID]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
    /**
    * 用户名
    */
    @NotBlank(message="[用户名]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    @ApiModelProperty("用户名")
    @Length(max= 20,message="编码长度不能超过20")
    private String username;
    /**
    * 密码
    */
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("密码")
    @Length(max= 32,message="编码长度不能超过32")
    private String password;
    /**
    * 昵称
    */
    @Size(max= 10,message="编码长度不能超过10")
    @ApiModelProperty("昵称")
    @Length(max= 10,message="编码长度不能超过10")
    private String nickname;
    /**
    * 邮箱
    */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("邮箱")
    @Length(max= 128,message="编码长度不能超过128")
    private String email;
    /**
    * 头像
    */
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("头像")
    @Length(max= 128,message="编码长度不能超过128")
    private String userPic;
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
    public void setId(Integer id){
    this.id = id;
    }

    /**
    * 用户名
    */
    public void setUsername(String username){
    this.username = username;
    }

    /**
    * 密码
    */
    public void setPassword(String password){
    this.password = password;
    }

    /**
    * 昵称
    */
    public void setNickname(String nickname){
    this.nickname = nickname;
    }

    /**
    * 邮箱
    */
    public void setEmail(String email){
    this.email = email;
    }

    /**
    * 头像
    */
    public void setUserPic(String userPic){
    this.userPic = userPic;
    }

    /**
    * 创建时间
    */
    public void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 修改时间
    */
    public void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }


    /**
    * ID
    */
    public Integer getId(){
    return this.id;
    }

    /**
    * 用户名
    */
    @JsonIgnore
    public String getUsername(){
    return this.username;
    }

    /**
    * 密码
    */
    @JsonIgnore
    public String getPassword(){
    return this.password;
    }

    /**
    * 昵称
    */
    public String getNickname(){
    return this.nickname;
    }

    /**
    * 邮箱
    */
    public String getEmail(){
    return this.email;
    }

    /**
    * 头像
    */
    public String getUserPic(){
    return this.userPic;
    }

    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 修改时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getUpdateTime(){
    return this.updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", userPic='" + userPic + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
