package nl.ccs_tech.vt.dto;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@Builder
public class IngredientDTO {

    private final Long id;
    private final String name;
    private final int quantity;
    private final String unit;
}
