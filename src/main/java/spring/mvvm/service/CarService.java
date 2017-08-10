package spring.mvvm.service;

import org.springframework.data.domain.Page;

import spring.mvvm.model.Car;

public interface CarService {

    Page<Car> search(String keyword, Integer activePage, Integer pageSize);

    Car findOne(Integer id);

	Car insert(Car car);

	Car update(Car car);

	void delete(Integer id);

}
