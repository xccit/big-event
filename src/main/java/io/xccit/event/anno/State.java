package io.xccit.event.anno;

import io.xccit.event.validation.ArticleStateValidation;
import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * @author CH_ywx
 * @version 1.0
 * @create 2024/8/5
 * <p>文章状态校验注解</p>
 */
@Documented
@Constraint(
        validatedBy = {ArticleStateValidation.class}
)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    String message() default "状态只能为[已发布]或[草稿]";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
