package com.gabriel_vitors.spring_boot_curso.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String formatedGender = "Male".equals(value) ? "M" : "F";

        gen.writeString(formatedGender);
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'serialize'");
        
    }

}
