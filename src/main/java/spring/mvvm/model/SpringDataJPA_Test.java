package spring.mvvm.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataJPA_Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        CarService carService = ctx.getBean("carService", CarService.class);
//        carService.insert(new Car("test","test"));
//        List<Car> carList = carService.findByModelOrMake("n");
//        Iterable<Car> carList = carService.findAll();
//        carList.forEach(c -> System.out.println(c.getMake()));
        Car car = carService.findOne(11);
        System.out.println(car.getMake());
    }
}
