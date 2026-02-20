package nl.ccs_tech.vt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ccs_tech.vt.config.VirtualThreadConfig;
import nl.ccs_tech.vt.dto.RecipeDTO;
import nl.ccs_tech.vt.entity.RecipeEntity;
import nl.ccs_tech.vt.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final Executor virtualThreadConfig;

    public void getRecipesVirtualThreads(Long userId) {
        virtualThreadConfig.execute(() -> {
            log.info("getting recipes for user using virtual threads: {} | {} ", userId, Thread.currentThread());
            recipeRepository.findByUserId(userId).stream().map(this::mapToDTO).toList();
        });
    }

    public List<RecipeDTO> getRecipes(Long userId) {
        log.info("getting recipes for user: {} | {} ", userId, Thread.currentThread());
        return recipeRepository.findByUserId(userId).stream().map(this::mapToDTO).toList();
    }


    private RecipeDTO mapToDTO(RecipeEntity recipeEntity) {
        return RecipeDTO.builder()
                .id(recipeEntity.getId())
                .instructions(recipeEntity.getInstructions())
                .servings(recipeEntity.getServings())
                .title(recipeEntity.getTitle())
                .isVegetarian(recipeEntity.getIsVegetarian())
                .build();
    }


}
