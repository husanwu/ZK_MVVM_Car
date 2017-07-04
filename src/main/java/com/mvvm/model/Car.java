package com.mvvm.model;

import lombok.Getter;
import lombok.Setter;

// getter & setter 交由 lombok 產生
@Getter
@Setter
public class Car {

	private Integer id;
	private String model;
	private String make;
	private String preview;
	private String description;
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
