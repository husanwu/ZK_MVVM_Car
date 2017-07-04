package com.mvvm.model;

import java.util.List;

public interface CarService {

	/**
	 * Retrieve all cars in the catalog.
	 * @return all cars
	 */
	List<Car> findAll();

	/**
	 * search cars according to keyword in name and company.
	 * @param keyword for search
	 * @return list of car that match the keyword
	 */

	List<Car> search(String keyword);
	void insert(Car car);
	void delete(Car car);
	void update(Integer carId, Car car);
}
