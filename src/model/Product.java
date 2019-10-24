package model;

class Product{
	
	private String id;
	private String name;
	private String desc;
	private ArrayList<Waste> waste;
	
	//Constructor
	Product(String id, String name, String desc){
		this.id = id;
		this.name = name;
		this.desc = desc;
		waste = new ArrayList<Waste>();
	}
	
	String getId(){
		return id;
	}
	
	String getName(){
		return name;
	}
	
	String getDesc(){
		return desc;
	}
	
	ArrayList<Waste> getWaste(){
		return waste;
	}
}