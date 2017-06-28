package com.mvvm.viewmodel;

import org.zkoss.bind.annotation.Command;

import com.mvvm.model.Car;
import com.mvvm.model.CarService;
import com.mvvm.model.CarServiceImpl;

import lombok.Getter;
import lombok.Setter;

public class InsertViewModel {
    @Getter
    @Setter
    private Car car = new Car();

    private CarService carService = new CarServiceImpl();

    @Command
    public void insert() {
        carService.insert(car);
    }

}
