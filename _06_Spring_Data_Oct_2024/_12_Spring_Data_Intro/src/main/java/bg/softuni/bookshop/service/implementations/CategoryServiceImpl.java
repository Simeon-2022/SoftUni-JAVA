package bg.softuni.bookshop.service.implementations;

import bg.softuni.bookshop.data.entities.Category;
import bg.softuni.bookshop.data.repositories.CategoryRepository;
import bg.softuni.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_PATH = "src/main/resources/Files/categories.txt";
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void seedCategories() throws IOException {
        Set<Category> categories = new LinkedHashSet<>();

        Files.readAllLines(Path.of(CATEGORIES_PATH))
                .stream()
                .filter(line -> !line.isBlank())
                .forEach(line -> {

                    Category category = new Category(line);
                    categories.add(category);

                });


        this.categoryRepository.saveAllAndFlush(categories);
        System.out.printf("Count of imported Categories - %d%n", this.categoryRepository.count());
    }

    @Override
    public boolean isImported() {

        return this.categoryRepository.count() > 0;
    }

    @Override
    public Set<Category> getRandomCategory() {
        Set<Category> categories = new HashSet<>();
        long totalCategories = categoryRepository.count();
        //boolean isDuplicate = false;

        for (int i = 0; i < 4; i++) {
            long categoryId = ThreadLocalRandom.current().nextLong(1, totalCategories + 1);

          /*  for (Category category : categories) {
                if (category.getId() == categoryId) {
                    isDuplicate = true;
                    break;
                }
            }*/

        //    if (!isDuplicate) {
                Category randomCategory = categoryRepository.findById(categoryId).get();
                categories.add(randomCategory);
        //    }
        }
        return categories;
    }
}
