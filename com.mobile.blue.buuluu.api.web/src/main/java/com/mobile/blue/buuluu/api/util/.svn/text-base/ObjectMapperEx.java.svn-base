package com.mobile.blue.buuluu.api.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;


public class ObjectMapperEx extends ObjectMapper {

	private static final long serialVersionUID = -2684671684921694113L;

	public ObjectMapperEx() {

//        this.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//
//        this.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//
//        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
//        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
//        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
//        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
//        configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
//     	enableDefaultTyping();
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer());
		setDateFormat((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
	}

	
}


class JsonSerializer extends com.fasterxml.jackson.databind.JsonSerializer<Object>{
	@Override
	public void serialize(Object value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException,
			JsonProcessingException {
		gen.writeString("");
		
	}
}

