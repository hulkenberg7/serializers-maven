package Serializers.TestClasses;

import Serializers.Annotations.Transient;
import Serializers.Interfaces.Serializable;

public class Test implements Serializable {
	@Transient
	static final int x = 77;
	Test2 test = new Test2();
	private String str = "Test string";
}