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
* @TableName article
*/
public class Article implements Serializable {

    /**
    * ID
    */
    @NotNull(message="[ID]不能为空")
    @ApiModelProperty("ID")
    private Integer id;
    /**
    * 文章标题
    */
    @NotBlank(message="[文章标题]不能为空")
    @Size(max= 30,message="编码长度不能超过30")
    @ApiModelProperty("文章标题")
    @Length(max= 30,message="编码长度不能超过30")
    private String title;
    /**
    * 文章内容
    */
    @NotBlank(message="[文章内容]不能为空")
    @Size(max= 10000,message="编码长度不能超过10000")
    @ApiModelProperty("文章内容")
    @Length(max= 10000,message="编码长度不能超过10,000")
    private String content;
    /**
    * 文章封面
    */
    @NotBlank(message="[文章封面]不能为空")
    @Size(max= 128,message="编码长度不能超过128")
    @ApiModelProperty("文章封面")
    @Length(max= 128,message="编码长度不能超过128")
    private String coverImg;
    /**
    * 文章状态: 只能是[已发布] 或者 [草稿]
    */
    @Size(max= 3,message="编码长度不能超过3")
    @ApiModelProperty("文章状态: 只能是[已发布] 或者 [草稿]")
    @Length(max= 3,message="编码长度不能超过3")
    private String state;
    /**
    * 文章分类ID
    */
    @ApiModelProperty("文章分类ID")
    private Integer categoryId;
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
    * 文章标题
    */
    private void setTitle(String title){
    this.title = title;
    }

    /**
    * 文章内容
    */
    private void setContent(String content){
    this.content = content;
    }

    /**
    * 文章封面
    */
    private void setCoverImg(String coverImg){
    this.coverImg = coverImg;
    }

    /**
    * 文章状态: 只能是[已发布] 或者 [草稿]
    */
    private void setState(String state){
    this.state = state;
    }

    /**
    * 文章分类ID
    */
    private void setCategoryId(Integer categoryId){
    this.categoryId = categoryId;
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
    * 文章标题
    */
    private String getTitle(){
    return this.title;
    }

    /**
    * 文章内容
    */
    private String getContent(){
    return this.content;
    }

    /**
    * 文章封面
    */
    private String getCoverImg(){
    return this.coverImg;
    }

    /**
    * 文章状态: 只能是[已发布] 或者 [草稿]
    */
    private String getState(){
    return this.state;
    }

    /**
    * 文章分类ID
    */
    private Integer getCategoryId(){
    return this.categoryId;
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
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", state='" + state + '\'' +
                ", categoryId=" + categoryId +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
