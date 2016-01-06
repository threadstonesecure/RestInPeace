package com.ekart.restClient.httpVerbClients;

import com.ekart.restClient.RestClient;
import com.ekart.restClient.httpVerbClients.testEntities.SimpleRequestDto;
import com.ekart.restClient.httpVerbClients.testEntities.SimpleResponseDto;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestMain {

    // These urls pertain to a local server that I had started before running these tests
    // So, the tests are ignored by default
    private static final String GET_URL = "http://127.0.0.1:8080/api/dummy/get-api";
    private static final String POST_URL = "http://127.0.0.1:8080/api/dummy/post-api";

    @Test
    @Ignore
    public void testGetRequest() throws IOException, URISyntaxException {

        SimpleRequestDto simpleRequestDto = new SimpleRequestDto(1, "foo", "bar");

        SimpleResponseDto result = RestClient.GET.execute(GET_URL, SimpleResponseDto.class);

        assertThat(result.getId(), is(simpleRequestDto.getId()));
        assertThat(result.getKey(), is(simpleRequestDto.getKey()));
        assertThat(result.getValue(), is(simpleRequestDto.getValue()));
    }

    @Test
    @Ignore
    public void testPostRequest() throws IOException, URISyntaxException {

        SimpleRequestDto simpleRequestDto = new SimpleRequestDto(1, "foo", "bar");

        SimpleResponseDto result = RestClient.POST.execute(POST_URL, simpleRequestDto, SimpleResponseDto.class);

        assertThat(result.getId(), is(simpleRequestDto.getId()));
        assertThat(result.getKey(), is(simpleRequestDto.getKey()));
        assertThat(result.getValue(), is(simpleRequestDto.getValue()));
    }
}