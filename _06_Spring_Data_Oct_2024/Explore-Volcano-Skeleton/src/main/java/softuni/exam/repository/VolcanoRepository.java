package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Volcano;

import java.util.Optional;

// TODO:
@Repository
public interface VolcanoRepository extends JpaRepository<Volcano,Long> {

    Optional<Volcano> findByName(@Param(value = "name")String name);
}
