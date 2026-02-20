package nl.ccs_tech.vt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "recipe")
@Getter
@Setter
@NoArgsConstructor
public class RecipeEntity {

    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String title;

    private int servings;

    @Column(name = "is_vegetarian")
    private Boolean isVegetarian;

    private String instructions;

}
