package com.example.advquerying;

import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.repositories.LabelRepository;
import com.example.advquerying.repositories.ShampooRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final LabelRepository labelRepository;
    private final IngredientRepository ingredientRepository;

    public Runner(ShampooRepository shampooRepository,
                  LabelRepository labelRepository,
                  IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.labelRepository = labelRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    //@Transactional
    public void run(String... args) throws Exception {
        System.out.println("Working...");

        //  Optional<Shampoo> byId = shampooRepository.findById(1L);
        //  byId.get().getIngredients().forEach(i -> System.out.println(i.getName()));
        //  shampooRepository.findAllBySizeOrderById(Size.MEDIUM).forEach(s -> System.out.println(s.getBrand()+ " " + s.getSize() + " " + s.getPrice() + "lv."));
        //Zad_1 System.out.println(shampooRepository.findAllByBrandAndSize("Nectar Nutrition", MEDIUM).size());
        //Zad_2 shampooRepository.findAllBySizeOrLabelIdOrderByPriceAsc(MEDIUM,10L).forEach(System.out::println);
        //  Optional<Label> label = labelRepository.findById(4L);
        //  shampooRepository.findAllBySizeOrLabelOrderByPriceAsc(MEDIUM,label.get());
        //  shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(10)).forEach(System.out::println);

        //  ingredientRepository.findAllByNameStartingWith("M").forEach(System.out::println);
        //  ingredientRepository.findAllByNameInOrderByPrice(List.of("Lavender","Herbs", "Apple")).forEach(System.out::println);
        //  System.out.println(shampooRepository.countAllByPriceIsLessThan(BigDecimal.valueOf(8.5)));
        //  shampooRepository.findAllByIngredientsNameIn(List.of("Berry","Mineral-Collagen")).forEach(System.out::println);
        //  shampooRepository.findAllByShampoosWithIngredientsCountOf(2).forEach(System.out::println);

        //  ingredientRepository.deleteByName("Lavender");
        //  ingredientRepository.updateIngredientsByPriceBy(BigDecimal.valueOf(1.10));
            ingredientRepository.updateIngredientsByNames(BigDecimal.valueOf(3),List.of("Active-Caffeine"));
    }
}
