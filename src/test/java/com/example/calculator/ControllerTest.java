package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = Controller.class)
class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCalculator() throws Exception {

    this.mockMvc.perform(get("/api/calculation")
            .contentType(MediaType.APPLICATION_JSON)
            .param("max", "1000")
            .param("divisor", "7")
            .param("limit", "3"))
            .andExpect(jsonPath("$.data[0]").value("I am 996"));
    }
}