package com.mvvm.viewmodle;

import org.zkoss.bind.annotation.Command;

import com.mvvm.model.Car;
import com.mvvm.model.CarService;
import com.mvvm.model.CarServiceImpl;

public class InsertViewModel {
    private Car car = new Car();

    private CarService carService = new CarServiceImpl();

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Command
    public void insert() {
        carService.insert(car);
    }

}
