package spring.mvvm.model;

import java.util.List;

public interface CarService {

	/**
	 * Retrieve all cars in the catalog.
	 * @return all cars
	 */
    Iterable<Car> findAll();

	/**
	 * search cars according to keyword in name and company.
	 * @param keyword for search
	 * @return list of car that match the keyword
	 */

    Car findOne(Integer id);
	List<Car> findByModelOrMake(String keyword);
	Car insert(Car car);
	Car update(Car car);
	void delete(Car car);
}
