package spring.mvvm.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends CrudRepository<Car, Serializable> {

    @Query("select c from Car c where c.model like CONCAT('%',:keyword,'%') or c.make like CONCAT('%',:keyword,'%')")
    List<Car> findByModelOrMake(@Param("keyword") String keyword, Sort sort);

    @Override
    @Query
    List<Car> findAll();

}
