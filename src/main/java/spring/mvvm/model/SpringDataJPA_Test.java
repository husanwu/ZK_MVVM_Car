package spring.mvvm.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataJPA_Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        CarService carService = ctx.getBean("carService", CarService.class);

        //insert
//        Car car = new Car("model", "make", "description", "preview", 10000);
//        car = carService.insert(car);
//        System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake());

        //update
//        Car car = carService.findOne(11);
//        car.setModel("model2");
//        car.setMake("make2");
//        car.setDescription("description2");
//        car.setPreview("preview2");
//        car.setPrice(20000);
//        car = carService.update(car);
//        System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake());

        //delete
//        carService.delete(11);


        /**
         * Query
         */

        //findOne
//        Car car = carService.findOne(10);
//        System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake());

        //findAll
//        Iterable<Car> carList = carService.findAll();
//        carList.forEach(car ->
//            System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake())
//        );

        //findByModelOrMake
//        List<Car> carList = carService.findByModelOrMake("c");
//        carList.forEach(car ->
//            System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake())
//        );

    }
}
