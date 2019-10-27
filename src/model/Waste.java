package model;

public abstract class Waste{

	private String id;
	private String name;
	private String origin;
	private String color;
	private int compostingTime;
	private Product product;
	
	public Waste(String id, String name, String origin, String color, int compostingTime, Product product){
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.compostingTime = compostingTime;
		this.product = product;
	}

	public abstract double harmfulEffect();

	@Override
	public String toString(){
		return String.format("%s - %s - %s - %s - %d - %s",id,name,origin,color,compostingTime,product.toString());
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getCompostingTime(){
		return compostingTime;
	}
	
	public Product getProduct(){
		return product;
	}

}