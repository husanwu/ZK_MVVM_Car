package com.mvvm.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
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
		//執行新的查詢時，隱藏修改區塊
		upVisible = false;
	}

    /*
     * 前端使用@command(key1="value", key2=object)綁定參數
     * ViewModel裡的方法參數為(@BindingParam("key1") String str, @BindingParam("key2") Object obj)
    */
    @Command
    @NotifyChange({"carList", "selectedCar"})
    public void delete(@BindingParam("thiscar") Car car) {
        carService.delete(car);
        //刪除car時，清空selectedCar，並重新載入Car清單
        carList = carService.search(keyword);
        selectedCar = null;
    }

    @Command
    @NotifyChange({"carList", "selectedCar"})
    public void deleteMsg(@BindingParam("thiscar") Car car) {
        Messagebox.show("確定刪除?", "刪除", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION,
                            new org.zkoss.zk.ui.event.EventListener<Event>() {
            @Override
            public void onEvent(Event evt) throws Exception {
                if ("onOK".equals(evt.getName())) {
                    carService.delete(car);
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

    //設定修改區塊Visible
    @Command
    @NotifyChange("upVisible")
    public void showUpdate() {
        upVisible = true;
    }

    @Command
    @NotifyChange("upVisible")
    public void hideUpdate() {
        upVisible = false;
    }

}
