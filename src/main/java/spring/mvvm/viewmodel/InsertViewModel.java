package spring.mvvm.viewmodel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import lombok.Getter;
import lombok.Setter;
import spring.mvvm.model.Car;
import spring.mvvm.service.CarService;
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class InsertViewModel {

    @Getter
    @Setter
    private Car car = new Car();

    @WireVariable
    public CarService carService;

    @Command
    public void insert() {
        carService.insert(car);
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
