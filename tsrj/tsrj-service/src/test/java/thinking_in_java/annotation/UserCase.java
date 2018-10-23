package thinking_in_java.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited //允许子类继成父类的注解
public @interface UserCase {
    public int id();
    public String description() default "no description";
}
