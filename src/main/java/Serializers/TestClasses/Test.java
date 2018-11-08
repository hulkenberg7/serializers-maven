package Serializers.TestClasses;

import Serializers.Interfaces.Serializable;

public class Test implements Serializable {
	@Test2.Transient
	static final int x = 77;
	Test2 test = new Test2();
	private String str = "Test string";
}