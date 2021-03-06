package com.example.android.justjava;

import com.example.android.justjava.model.MovieSummaryData;
import com.example.android.justjava.model.MovieDetailData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JSONParser {

    public List<MovieSummaryData> readJsonStream(String response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Config deserialization
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // readValue deserializes JSON content from given JSON content String into Java object (using generics)
        return mapper.readValue(response, new TypeReference<List<MovieSummaryData>>(){});
    }

    public MovieDetailData readDetailJsonStream(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Config deserialization
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // readValue deserializes JSON content from given JSON content String into Java object (using generics)
        return mapper.readValue(response, MovieDetailData.class);

    }
}
