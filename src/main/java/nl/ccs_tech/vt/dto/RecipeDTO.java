package nl.ccs_tech.vt.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@Builder(toBuilder = true)
public class RecipeDTO {

    private final Long id;

    private final String title;

    private final int servings;

    private final Boolean isVegetarian;

    private final String instructions;

    private final List<IngredientDTO> ingredients;

}
