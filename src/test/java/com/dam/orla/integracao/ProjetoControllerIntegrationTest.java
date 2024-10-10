package com.dam.orla.integracao;

import com.dam.orla.api.dto.request.ProjetoRequest;
import com.dam.orla.domain.model.FuncionarioModel;
import com.dam.orla.domain.model.ProjetoModel;
import com.dam.orla.domain.repository.ProjetoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProjetoControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjetoRepository projetoRepository;

    @Test
    void deveCriarProjetoComSucesso() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        FuncionarioModel funcionario = new FuncionarioModel("Douglas Teste", "12345678900", "teste@email.com", BigDecimal.valueOf(1000));
        ProjetoModel projetoModel = new ProjetoModel("Projeto Teste", LocalDate.now());
        projetoModel.setFuncionarios(Set.of(funcionario));
        final ProjetoRequest request = new ProjetoRequest("Projeto Teste", LocalDate.now(), List.of());

        when(projetoRepository.save(any(ProjetoModel.class))).thenReturn(projetoModel);

        mockMvc.perform(post("/projetos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.nome").value("Projeto Teste"));

    }

    @Test
    void deveListarProjetosComSucesso() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        ProjetoModel projetoModel = new ProjetoModel("Projeto Teste", LocalDate.now());

        when(projetoRepository.findAll()).thenReturn(List.of(projetoModel));

        mockMvc.perform(get("/projetos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].nome").value("Projeto Teste"));
    }
}
