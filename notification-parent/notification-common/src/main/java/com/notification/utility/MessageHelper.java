package com.notification.utility;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MessageHelper {
	/**
	 * Method convert Object to JSON encoded String.
	 * @param input
	 * @return JSON encoded String.
	 * @throws Exception
	 */
	public static String toJsonString(Object input) {
		String userDataJSON = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);

			SimpleModule module = new SimpleModule();
			//module.addSerializer(new JsonStringValueTrimSerializer());
			mapper = mapper.registerModule(module);

			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, input);
			userDataJSON = strWriter.toString();
			} catch (Exception jme) {
		}
		return userDataJSON;
	}

	/**
	 * Method convert JSON encoded String to Object
	 * 
	 * @param inputJSON
	 * @param jsonObj
	 * @param valueType
	 * @return Object (jsonObj)
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromJsonToObject(String inputJSON, Class<T> valueType) 	{
		
		ObjectMapper mapper = new ObjectMapper();
		Object jsonObj = null;
		try {
			jsonObj = valueType.newInstance();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		try {
			jsonMap = mapper.readValue(inputJSON, HashMap.class);

		} catch (Exception e) {
		}

		try {
			Writer strWriter = new StringWriter();
			mapper.writeValue(strWriter, jsonMap);
			String userDataJSON = strWriter.toString();

			jsonObj = mapper.readValue(userDataJSON, valueType);

		} catch (Throwable cause) {}
		return (T) jsonObj;
	}

}
