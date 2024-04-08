package employee.emailCustomAnnotaionvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailVal.class)
public @interface EmailValidator {
	
	public String message()default"Email is already present please choose another email";
	
	Class<?>[]groups() default{};
	
	Class<? extends Payload>[] payload() default{};
	

}
