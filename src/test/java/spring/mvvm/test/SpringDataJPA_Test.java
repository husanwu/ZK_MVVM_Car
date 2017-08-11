package spring.mvvm.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.mvvm.service.CarService;

public final class SpringDataJPA_Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        CarService carService = ctx.getBean("carService", CarService.class);

        //insert
//        Car car = new Car(null, "model", "make", "description", "preview", 10000);
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

        //paging
//        Pageable pageable = new PageRequest(1, 3, new Sort(Direction.ASC, "id"));
//
//        System.out.println("PageSize: " + pageable.getPageSize());
//        System.out.println("Offset: " + pageable.getOffset());
//        System.out.println("PageNumber+1: " + (pageable.getPageNumber() + 1));

        //findAll
//        Page<Car> carList = carService.findAll(pageable);
//        carList.forEach(car ->
//            System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake())
//        );

        //findByModelOrMake
//        Page<Car> carList = carService.findByModelOrMake("N", pageable);
//        carList.forEach(car ->
//            System.out.println(car.getId() + ", " + car.getModel() + ", " + car.getMake())
//        );

    }
}
