package spring.mvvm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

// getter & setter 交由 lombok 產生
@Entity
//@Table(name = "Car")
@Getter
@Setter
@NamedQuery(name = "Car.findAll",
             query = "select c from Car c order by c.id")
public class Car implements Serializable {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "car_seq", allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Integer id;

//    @Column(name = "model")
	private String model;

//    @Column(name = "make")
	private String make;

//    @Column(name = "preview")
	private String preview;

//    @Column(name = "description")
	private String description;

//    @Column(name = "price")
	private Integer price;

	public Car() {
	    // 建構子應由參數少的呼叫參數多的
	    this(null, null, null, null, null, null);
	}

	// 建構子參數太多 is not a best practice
	public Car(Integer id, String model, String make, String description, String preview, Integer price) {
		this.id = id;
	    this.model = model;
		this.make = make;
		this.preview = preview;
		this.description = description;
		this.price = price;
	}

}
