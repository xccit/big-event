package io.xccit.event.entity;


import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.xccit.event.anno.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName article
*/
public class Article implements Serializable {

    public interface Insert extends Default {}
    public interface Update extends Default {}

    /**
    * ID
    */
    @NotNull(message="[ID]不能为空",groups = {Update.class})
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
    @Length(max= 10000,message="编码长度不能超过10000")
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
    @State
    @ApiModelProperty("文章状态: 只能是[已发布] 或者 [草稿]")
    private String state;
    /**
    * 文章分类ID
    */
    @NotNull(message="[文章分类ID]不能为空")
    @ApiModelProperty("文章分类ID")
    private Integer categoryId;
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
    * 文章标题
    */
    public void setTitle(String title){
    this.title = title;
    }

    /**
    * 文章内容
    */
    public void setContent(String content){
    this.content = content;
    }

    /**
    * 文章封面
    */
    public void setCoverImg(String coverImg){
    this.coverImg = coverImg;
    }

    /**
    * 文章状态: 只能是[已发布] 或者 [草稿]
    */
    public void setState(String state){
    this.state = state;
    }

    /**
    * 文章分类ID
    */
    public void setCategoryId(Integer categoryId){
    this.categoryId = categoryId;
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
    * 文章标题
    */
    public String getTitle(){
    return this.title;
    }

    /**
    * 文章内容
    */
    public String getContent(){
    return this.content;
    }

    /**
    * 文章封面
    */
    public String getCoverImg(){
    return this.coverImg;
    }

    /**
    * 文章状态: 只能是[已发布] 或者 [草稿]
    */
    public String getState(){
    return this.state;
    }

    /**
    * 文章分类ID
    */
    public Integer getCategoryId(){
    return this.categoryId;
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
