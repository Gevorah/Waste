package model;

class Recyclable extends Waste{
	
	private String type;
	private String desc;
	
	Recyclable(String id, String name, String origin, String color, Product product, String type, String desc){
		super.Waste(String id, String name, String origin, String color, Product product);
		this.type = type;
		this.desc = desc;
	}
	
	String getType(){
		return type;
	}
	
	String getDesc(){
		return desc;
	}
}