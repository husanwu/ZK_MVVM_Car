package spring.mvvm.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import spring.mvvm.model.Car;

public interface CarRepository extends CrudRepository<Car, Serializable> {

    /*
     * Using Spring Data Paging
     * Reference: https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-part-seven-pagination/
     */
    @Query("select c from Car c where c.model like CONCAT('%',:keyword,'%') or c.make like CONCAT('%',:keyword,'%')")
    Page<Car> findByModelOrMake(@Param("keyword") String keyword, Pageable pageable);

    @Query
    Page<Car> findAll(Pageable pageable);

}
