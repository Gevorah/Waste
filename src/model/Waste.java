package model;

/**
*	This class allows create waste.
*	@author Jhon Ijaji.
*	@version 1.0
*	@since 1.0
*/
public abstract class Waste{

	//Attributes
	private String id;
	private String name;
	private String origin;
	private String color;
	private int compostingTime;
	private Product product;

	/**
	*	Waste constructor.<br>
	*	@param id Waste id.
	*	@param name Waste name.
	*	@param origin Waste origin.
	*	@param color Waste color.
	*	@param compostingTime Time that take the waste to descompose.
	*	@param product Product that produce the waste.
	*/
	//Constructor
	public Waste(String id, String name, String origin, String color, int compostingTime, Product product){
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.compostingTime = compostingTime;
		this.product = product;
	}

	/**
	*	This method is calculate the harmful effect on the world.<br>
	*/
	public abstract double harmfulEffect();

	/**
	*	This method show information of the waste.<br>
    *   @return Information of the waste.
	*/
	@Override
	public String toString(){
		return String.format("%s - %s - %s - %s - %d - %s",id,name,origin,color,compostingTime,product.toString());
	}
	
	/**
	*	This method get the waste id.<br>
    *   @return The waste id.
	*/
	public String getId(){
		return id;
	}
	
	/**
	*	This method get the waste name.<br>
    *   @return The waste name.
	*/
	public String getName(){
		return name;
	}
	
	/**
	*	This method get the waste origin.<br>
    *   @return The waste origin.
	*/
	public String getOrigin(){
		return origin;
	}
	
	/**
	*	This method get the waste color.<br>
    *   @return The waste color.
	*/
	public String getColor(){
		return color;
	}
	
	/**
	*	This method get the time that take the waste to descompose.<br>
    *   @return The time that take the waste to descompose.
	*/
	public int getCompostingTime(){
		return compostingTime;
	}
	
	/**
	*	This method get the product that produce the waste.<br>
    *   @return The product that produce the waste.
	*/
	public Product getProduct(){
		return product;
	}

}