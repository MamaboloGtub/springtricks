package mamabologtub.springframework.springtricks.springtricks.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Tshepo M Mahudu
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
public @interface JSONPostMapping {
    @AliasFor(annotation = RequestMapping.class, attribute = "produces")
    String[] produces() default { "application/json" };
    @AliasFor(annotation = RequestMapping.class, attribute = "consumes")
    String[] consumes() default { "application/json" };
    @AliasFor(annotation = RequestMapping.class, attribute = "value")
    String[] value() default {};

}
