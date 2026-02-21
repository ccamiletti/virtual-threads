package nl.ccs_tech.vt.controller;

import nl.ccs_tech.vt.dto.RecipeDTO;
import nl.ccs_tech.vt.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = RecipeController.class)
@ActiveProfiles("test")
class RecipeControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockitoBean
    RecipeService recipeService;

    @Test
    void getAllByUserId() {
        List<RecipeDTO> recipeDTOList = List.of(RecipeDTO.builder().id(1L).build());
        when(recipeService.getRecipes(1L)).thenReturn(recipeDTOList);
        webTestClient.get().uri("/recipe?userId=1")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(RecipeDTO.class)
                .consumeWith(result -> {
                    assertNotNull(result.getResponseBody());
                    assertNotNull(result.getResponseBody().getFirst());
                    assert result.getResponseBody().getFirst().getId() == 1L;
                });
    }

}