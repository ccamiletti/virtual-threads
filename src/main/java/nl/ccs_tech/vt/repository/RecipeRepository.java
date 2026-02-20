package nl.ccs_tech.vt.repository;

import nl.ccs_tech.vt.entity.RecipeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Long> {

    List<RecipeEntity> findByUserId(Long userId);
    Optional<RecipeEntity> findByIdAndUserId(Long id, Long userId);
}
