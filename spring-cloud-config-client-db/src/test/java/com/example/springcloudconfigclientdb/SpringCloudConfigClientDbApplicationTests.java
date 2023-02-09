package com.example.springcloudconfigclientdb;

import com.example.springcloudconfigclientdb.entity.Student;
import com.example.springcloudconfigclientdb.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class SpringCloudConfigClientDbApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @SneakyThrows
    void getAllEntityTest() {
        mockMvc.perform(get("http://localhost:8585/api/student")
                        .contentType("application/json"))
                .andExpect(status().isOk());
        assertThat(studentRepository.findAll().size()).isEqualTo(0);
    }

    @Test
    @SneakyThrows
    void saveEntityTest() {
        mockMvc.perform(post("http://localhost:8585/api/student")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(
                                Student.builder()
                                        .name("test")
                                        .build())))
                .andExpect(status().isOk());
        assertThat(studentRepository.findAll().size()).isEqualTo(1);
    }
}
