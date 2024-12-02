package com.example.advquerying.repositories;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo,Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllByBrandAndSize(String brand, Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, int id);
    List<Shampoo> findAllBySizeOrLabelOrderByPriceAsc(Size size, Label label);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    int countAllByPriceIsLessThan(BigDecimal price);

    @Query("""
            SELECT s FROM Shampoo AS s 
            JOIN s.ingredients AS i 
            WHERE i.name IN :ingredients
""")
    List<Shampoo> findAllByIngredientsNameIn(List<String> ingredients);

    @Query("""
                        select s as iCount from Shampoo as s
                        where SIZE(s.ingredients)  < :ingredientsCount
            """)
    List<Shampoo> findAllByShampoosWithIngredientsCountOf(int ingredientsCount);


}
