package com.mvvm.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;

import com.mvvm.model.Car;
import com.mvvm.model.CarService;
import com.mvvm.model.CarServiceImpl;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SearchViewModel {

	private String keyword;
	private List<Car> carList;
	private Car selectedCar;
	private boolean upVisible = false;

	private CarService carService = new CarServiceImpl();

    @Command
	@NotifyChange({"carList", "selectedCar", "upVisible"})
	public void search() {
		carList = carService.search(keyword);
		//執行新的查詢時，清空selectedCar
		selectedCar = null;
		upVisible = false;
	}

    public void delete() {
        carService.delete(selectedCar);
        //刪除selectedCar時，清空selectedCar，並重新載入Car清單
        carList = carService.search(keyword);
        selectedCar = null;
    }

    @NotifyChange({"carList", "selectedCar"})
    @Command
    public void deleteMsg() {
        Messagebox.show("確定刪除?", "刪除", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION,
                            new org.zkoss.zk.ui.event.EventListener() {
            @Override
            public void onEvent(Event evt) throws Exception {
                if (evt.getName().equals("onOK")) {
                    carService.delete(selectedCar);
                    carList = carService.search(keyword);
                    selectedCar = null;
                }
            }
        });
    }

    @Command
    public void update() {
        int i = carList.indexOf(selectedCar);
        carService.update(i, selectedCar);
    }

    @NotifyChange("upVisible")
    @Command
    public void showUpdate() {
        upVisible = true;
    }

    @NotifyChange("upVisible")
    @Command
    public void hideUpdate() {
        upVisible = false;
    }

}
