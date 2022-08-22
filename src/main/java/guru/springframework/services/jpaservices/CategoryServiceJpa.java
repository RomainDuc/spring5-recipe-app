package guru.springframework.services.jpaservices;

import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceJpa implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceJpa(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Set<Category> findAll() {
        Set<Category> categories = new HashSet<>();
        categoryRepository.findAll().forEach(category -> {
            categories.add(category);
        });
        return categories;
    }

    @Override
    public Category findById(Long aLong) {
        return categoryRepository.findById(aLong).get();
    }

    @Override
    public Category save(Category obj) {
        return categoryRepository.save(obj);
    }

    @Override
    public void delete(Category obj) {
        categoryRepository.delete(obj);

    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }
}
