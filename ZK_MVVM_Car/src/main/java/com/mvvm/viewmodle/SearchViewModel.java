package com.mvvm.viewmodle;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import com.mvvm.model.Car;
import com.mvvm.model.CarService;
import com.mvvm.model.CarServiceImpl;

public class SearchViewModel {

	private String keyword;
	private List<Car> carList;
	private Car selectedCar;

	private CarService carService = new CarServiceImpl();

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeyword() {
		return keyword;
	}

	public List<Car> getCarList(){
		return carList;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}
	public Car getSelectedCar() {
		return selectedCar;
	}

    @Command
	@NotifyChange("carList")
	public void search(){
		carList = carService.search(keyword);
	}

    @Command
    public void delete() {
        carService.delete(selectedCar.getId());
    }

}
