package Serializers.TestClasses;

import Serializers.Interfaces.Serializable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test2 implements Serializable {
	boolean testable = true;
	double g = 9.8;

	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Transient {

	}
}