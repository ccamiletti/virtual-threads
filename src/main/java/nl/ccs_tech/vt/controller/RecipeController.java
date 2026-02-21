package nl.ccs_tech.vt.controller;


import lombok.RequiredArgsConstructor;
import nl.ccs_tech.vt.dto.RecipeDTO;
import nl.ccs_tech.vt.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public List<RecipeDTO> getAllByUserId(@RequestParam(name = "userId") Long userId) {
        return recipeService.getRecipes(userId);
    }

    @GetMapping("/all")
    public void getAllByUserIdVirtualThreads() {
        recipeService.getRecipesVirtualThreads(1L);
    }

}
