package basic.types.builders.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Value {
    double min() default Double.NEGATIVE_INFINITY;

    double max() default Double.POSITIVE_INFINITY;
    // TODO: добавить какую-нибудь проверку строгости для неравенст
}
