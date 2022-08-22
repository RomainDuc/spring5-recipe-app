package guru.springframework.services.jpaservices;

import guru.springframework.domain.Ingredient;
import guru.springframework.repositories.IngredientsRepository;
import guru.springframework.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class IngredientsServiceJpa implements IngredientService {

    private final IngredientsRepository ingredientsRepository;

    public IngredientsServiceJpa(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Set<Ingredient> findAll() {
        Set<Ingredient> ingredients = new HashSet<>();
        ingredientsRepository.findAll().forEach(ingredient -> {
            ingredients.add(ingredient);
        });
        return ingredients;
    }

    @Override
    public Ingredient findById(Long aLong) {
        return ingredientsRepository.findById(aLong).get();
    }

    @Override
    public Ingredient save(Ingredient obj) {
        return ingredientsRepository.save(obj);
    }

    @Override
    public void delete(Ingredient obj) {
        ingredientsRepository.delete(obj);

    }

    @Override
    public void deleteById(Long aLong) {
        ingredientsRepository.deleteById(aLong);
    }
}
