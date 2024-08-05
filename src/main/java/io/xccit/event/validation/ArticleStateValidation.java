package io.xccit.event.validation;

import io.xccit.event.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>文章状态校验注解逻辑</p>
 */
public class ArticleStateValidation implements ConstraintValidator<State,String> {

    /**
     * 校验规则
     * @param s 值
     * @param constraintValidatorContext 上下文
     * @return 是否通过校验
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null){
            return false;
        }
        if ("已发布".equals(s) || "草稿".equals(s)){
            return true;
        }
        return false;
    }
}
