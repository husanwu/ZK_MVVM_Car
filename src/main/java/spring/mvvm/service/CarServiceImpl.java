package spring.mvvm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.mvvm.model.Car;
import spring.mvvm.repository.CarRepository;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository repository;

    @Override
    public Car findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Page<Car> search(String keyword, Integer activePage, Integer pageSize) {
        Pageable pageable = new PageRequest(activePage, pageSize, new Sort(Direction.ASC, "id"));
        if (keyword == null || keyword.trim().length() == 0) {
            return repository.findAll(pageable);
        }
        return repository.findByModelOrMake(keyword, pageable);
    }

    @Override @Transactional
    public Car insert(Car car) {
        return repository.save(car);
    }

    @Override @Transactional
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override @Transactional
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public String toString() {
        return "Hi";
    }

}
