package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/category/{desc}")
    @ResponseBody
    public Category findCategoryByDesc(@PathVariable String desc) {
        Optional<Category> category = categoryRepository.findByDescription(desc);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("category not found");
        }
    }
}
