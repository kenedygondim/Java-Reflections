package com.ifsp.trabalho_java_reflection;

import com.fasterxml.jackson.databind.JsonNode;
import com.ifsp.trabalho_java_reflection.config.ObjectToJson;
import com.ifsp.trabalho_java_reflection.config.Transformator;
import com.ifsp.trabalho_java_reflection.dto.FilmeDto;
import com.ifsp.trabalho_java_reflection.models.Filme;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransformatorTest {

    Filme filme = new Filme("BAD BOYS", "LIONEL RONALDO", 2002, "ACAO");

    @Test
    void shouldTransform() throws Exception {
        FilmeDto dto = Transformator.map(filme, FilmeDto.class);

        assertNotNull(dto);
        assertInstanceOf(FilmeDto.class, dto);
        assertEquals("BAD BOYS", dto.getNome());
        assertEquals(2002, dto.getAnoLancamento());
    }

    @Test
    void shouldThrowWhenDtoMissing() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Transformator.map(filme, null);
        });
        assertTrue(exception.getMessage().contains("Erro ao realizar mapeamento"));
    }

    @Test
    void shouldSerializeToJson() throws Exception {
        JsonNode jsonNode = ObjectToJson.toJson(filme, FilmeDto.class);

        assertNotNull(jsonNode);
        assertTrue(jsonNode.has("nome"));
        assertEquals("LIONEL RONALDO", jsonNode.get("diretor").asText());
        assertFalse(jsonNode.has("atorPrincipal"));
        assertEquals(2002, jsonNode.get("anoLancamento").asInt());
    }
}
