package com.dam.orla.integracao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dam.orla.api.dto.request.FuncionarioRequest;
import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.repository.FuncionarioRepository;

@SpringBootTest
class FuncionarioControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Test
    void deveCriarFuncionarioComSucesso() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        FuncionarioModel funcionarioModel = new FuncionarioModel("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000));

        when(funcionarioRepository.save(any(FuncionarioModel.class))).thenReturn(funcionarioModel);

        final FuncionarioRequest request = new FuncionarioRequest("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000));

        mockMvc.perform(post("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.nome").value("Douglas Teste"))
            .andExpect(jsonPath("$.cpf").value("12345678900"));
    }

    @Test
    void deveListarFuncionariosComSucesso() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        FuncionarioModel funcionarioModel = new FuncionarioModel("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000));

        when(funcionarioRepository.save(any(FuncionarioModel.class))).thenReturn(funcionarioModel);

        final FuncionarioRequest request = new FuncionarioRequest("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000));
        mockMvc.perform(post("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated());
    }

}
