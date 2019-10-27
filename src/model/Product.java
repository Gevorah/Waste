package model;

import java.util.ArrayList;

public class Product {
	
	private String id;
	private String name;
	private String desc;
	private ArrayList<Waste> waste;
	
	//Constructor
	public Product(String id, String name, String desc){
		this.id = id;
		this.name = name;
		this.desc = desc;
		waste = new ArrayList<Waste>();
	}

	public String toString(){
		return String.format("%s(%s - %s)",name,id,desc);
	}

	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public ArrayList<Waste> getWaste(){
		return waste;
	}

	

}