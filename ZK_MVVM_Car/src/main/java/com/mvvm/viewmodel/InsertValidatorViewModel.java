package com.mvvm.viewmodel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.util.media.Media;

import com.mvvm.model.Car;
import com.mvvm.model.CarService;
import com.mvvm.model.CarServiceImpl;

import lombok.Getter;
import lombok.Setter;

public class InsertValidatorViewModel {
    @Getter
    @Setter
    private Car car = new Car();

    private CarService carService = new CarServiceImpl();

    @Command
    public void insert() {
        carService.insert(car);
    }

    /*
     * Validator
     * 還在研究中冏
     * 繼續看官方文件搞懂這傢伙...
     */
    public Validator getMyValidator() {
        return new AbstractValidator() {

            @Override
            public void validate(ValidationContext ctx) {
                Map<String, Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());

                //這三行只能開一行，否則會出現NullPointerException...冏
//                String model = (String) beanProps.get("model").getValue();
//                String make = (String) beanProps.get("make").getValue();
//                String description = (String) beanProps.get("description").getValue();

                //這行打開會出現錯誤訊息：java.lang.String cannot be cast to java.lang.Integer
//                Integer price = (Integer) beanProps.get("price").getValue();

            }
        };
    }

    @Command
    public void uploadImg(@BindingParam("media") Media media) throws Exception {

        if (media != null && media instanceof org.zkoss.image.Image) {

                String fileName = media.getName();

                //讀取imgpath.properties檔(位於src\main\resources目錄底下)
                Properties prop = new Properties();
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                InputStream propIs = loader.getResourceAsStream("imgpath.properties");
                prop.load(propIs);

                //設定Car Preview屬性
                String imgPath = prop.getProperty("imgPath") + fileName;
                car.setPreview(imgPath);

                //將圖片寫到指定資料夾
                String filePath = prop.getProperty("realPath") + fileName;
                File file = new File(filePath);
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
