package pl.mlopatka.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {

    public static final ObjectMapper OBJECT_MAPPER = initMapper();

    private static ObjectMapper initMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper;
    }
}
