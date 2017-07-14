package spring.mvvm.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository repository;

    @Override
    public Iterable<Car> findAll() {
	    return repository.findAll();
	}

    @Override
    public List<Car> search(String keyword) {
        return repository.findByModelOrMake(keyword, new Sort("id"));
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

    @Override
    public Car findOne(Integer id) {
        return repository.findOne(id);
    }

}
