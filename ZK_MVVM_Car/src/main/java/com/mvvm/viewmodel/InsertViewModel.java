package com.mvvm.viewmodel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.util.media.Media;

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

    @Command
    public void uploadImg(@BindingParam("media") Media media) throws Exception {

        if (media != null && media instanceof org.zkoss.image.Image) {

                String fileName = media.getName();
                String imgPath = "/widgets/getting_started/img/" + fileName;
                car.setPreview(imgPath);

                File file = new File("D:/Project/repository/ZK_MVVM_Car/src/main/webapp/widgets/getting_started/img/" + fileName);
                OutputStream out = new FileOutputStream(file);
                InputStream in = media.getStreamData();
                byte[] buffer = new byte[1024];
                int len;

                while ((len = in.read(buffer)) != -1 ) {
                    out.write(buffer, 0, len);
                }
                out.close();
                in.close();
        }

    }

}
