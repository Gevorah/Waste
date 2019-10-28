package model;

import java.util.ArrayList;

/**
*	This class allows create products.
*	@author Jhon Ijaji.
*	@version 1.0
*	@since 1.0
*/
public class Product {
	
	//Attributes
	private String id;
	private String name;
	private String desc;
	private ArrayList<Waste> waste;
	
	/**
	*	Product constructor.<br>
	*	@param id Product id.
	*	@param name Product name.
	*	@param desc Prodcut description.
	*/
	//Constructor
	public Product(String id, String name, String desc){
		this.id = id;
		this.name = name;
		this.desc = desc;
		waste = new ArrayList<Waste>();
	}

	/**
	*	This method show information of the product.<br>
    *   @return Information of the product.
	*/
	@Override
	public String toString(){
		return String.format("%s(%s - %s)",name,id,desc);
	}

	/**
	*	This method get the product name.<br>
    *   @return The product id.
	*/
	public String getId(){
		return id;
	}
	

	/**
	*	This method get the product name.<br>
    *   @return The tex changed with the needed.
	*/
	public String getName(){
		return name;
	}
	
	/**
	*	This method get the product description.<br>
    *   @return The product description.
	*/
	public String getDesc(){
		return desc;
	}
	
	/**
	*	This method get the waste list of the product.<br>
    *   @return The waste list.
	*/
	public ArrayList<Waste> getWaste(){
		return waste;
	}

	

}