package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String letter);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> names);

    @Transactional
    void deleteByName(String name);

    @Query("""
                update Ingredient i
                set i.price = i.price * :increase
            """)
    @Modifying
    @Transactional
    void updateIngredientsByPriceBy(BigDecimal increase);

    @Query("""
                update Ingredient i
                set i.price = i.price * :increase
                where i.name in :names
            """)
    @Modifying
    @Transactional
    void updateIngredientsByNames(BigDecimal increase, List<String> names);




}
