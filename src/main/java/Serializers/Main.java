package Serializers;

import Serializers.JsonXml.XmlSerializer;
import Serializers.JsonXml.JsonSerializer;
import Serializers.TestClasses.Test;

class Main {
	public static void main(String[] args) throws Exception {
		Test t = new Test();
		XmlSerializer.serialize(t);
		JsonSerializer.serialize(t);
	}
}
