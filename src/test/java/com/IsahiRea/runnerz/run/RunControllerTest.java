package com.IsahiRea.runnerz.run;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RunController.class)
public class RunControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    JdbcClientRunRepository repository;
    
    private final List<Run> runs = new ArrayList<>();

    @BeforeEach
    void setUp() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(),  LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 3, Location.INDOOR));
    }

    /* 
    @Test
    void shouldFindAllRuns() throws Exception {
        when(repository.findAll()).thenReturn(runs);
        mvc.perform(MockMvcRequestBuilders.get("/api/runs")
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()", is(runs.size())))
    }

    @Test
    public void shouldDeleteRun() throws Exception {
        mvc.perform(delete("/api/runs/1"))
            .andExpect(status().isNoContent());
    }
    */
}
