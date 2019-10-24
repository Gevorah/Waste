package model;

class Biodegradable extends Waste{
	
	private boolean composting;
	
	Biodegradable(String id, String name, String origin, String color, Product product, boolean composting){
		super(String id, String name, String origin, String color, Product product);
		this.composting = composting;
	}
	
	boolean getComposting(){
		return composting;
	}
}