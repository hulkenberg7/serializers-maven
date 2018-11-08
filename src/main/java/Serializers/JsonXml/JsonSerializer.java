package Serializers.JsonXml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.*;

import Serializers.Interfaces.*;
import Serializers.TestClasses.Test2;

public final class JsonSerializer implements Serializer {

	private static int tabCounter = 0;
	private JsonSerializer() {}

	public static void serialize(Serializable obj) {
		try {
			FileOutputStream fos = new FileOutputStream("src/main/resources/" + obj.getClass().getSimpleName() + ".json", true);
			OutputStreamWriter writer = new OutputStreamWriter(fos);

			StringBuilder sb = new StringBuilder();
			serialize(obj, sb);

			writer.write(sb.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void serialize(Serializable obj, StringBuilder sb) {
		try {
	
			Class objectName = obj.getClass();
			Field[] fields = objectName.getDeclaredFields();
			//getTab(sb);
			sb.append("{\n");

			for(int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				if(field.isAnnotationPresent(Test2.Transient.class)) {
					continue;
				}

				field.setAccessible(true);
				
				if (!Serializable.class.isAssignableFrom(field.getType())) {
					getTab(sb);
					sb.append("\t\"" + field.getName() + "\" : ");
					sb.append("\"" + field.get(obj) + "\"");

					if (i != fields.length-1) {
						sb.append(",");
					}

					sb.append("\n");
				}
				else {
					if (tabCounter != 0) {
						sb.setLength(sb.length() - 2);
					}
					sb.append("\t\"" + field.getName() + "\" : ");
					//sb.append("\n");
					tabCounter++;
					serialize((Serializable)field.get(obj), sb);
				}
			}

			getTab(sb);
			sb.append("}");
			if(tabCounter > 0) {
				sb.append(",");
			}
			sb.append("\n");
			tabCounter--;
		
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static void getTab(StringBuilder sb) {
		for (int i = 0; i < tabCounter; i++) {
			sb.append("\t");
		}
	}
}