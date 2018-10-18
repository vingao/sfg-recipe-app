package guru.springframework.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long id = 1L;
        category.setId(id);
        Assert.assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
        String description = "test";
        category.setDescription(description);
        Assert.assertEquals(description, category.getDescription());
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        category.setRecipes(recipes);

        Assert.assertEquals(recipes, category.getRecipes());
    }
}
