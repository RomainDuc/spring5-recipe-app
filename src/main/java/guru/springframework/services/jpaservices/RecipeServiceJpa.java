package guru.springframework.services.jpaservices;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceJpa implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceJpa(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @Override
    public Set<Recipe> findAll() {
        log.debug("I'm in the service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipe -> {
            recipes.add(recipe);
        });
        return recipes;
    }

    @Override
    public Recipe findById(Long aLong) {
        return recipeRepository.findById(aLong).get();
    }

    @Override
    public Recipe save(Recipe obj) {
        return recipeRepository.save(obj);
    }

    @Override
    public void delete(Recipe obj) {
        recipeRepository.delete(obj);

    }

    @Override
    public void deleteById(Long aLong) {
        recipeRepository.deleteById(aLong);
    }
}
