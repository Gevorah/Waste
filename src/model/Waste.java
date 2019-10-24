package model;

abstract class Waste{
	
	private String id;
	private String name;
	private String origin;
	private String color;
	private int compostingTime;
	private Product product;
	
	Waste(String id, String name, String origin, String color, Product product){
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.product = product;
	}
	
	String getId(){
		return id;
	}
	
	String getName(){
		return name;
	}
	
	String getOrigin(){
		return origin;
	}
	
	String getColor(){
		return color;
	}
	
	int get compostingTime(){
		return composting time;
	}
	
	Product getProduct(){
		return product;
	}
}