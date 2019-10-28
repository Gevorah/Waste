package model;

/**
*	This class allows create recyclable waste.
*	@author Jhon Ijaji.
*	@version 1.0
*	@since 1.0
*/
public class Recyclable extends Waste implements Usable{
	
	//Attributes
	private String type;
	private String desc;
	
	/**
	*	Recyclable constructor.<br>	
	*	@param id Waste id.
	*	@param name Waste name.
	*	@param origin Waste origin.
	*	@param color Waste color.
	*	@param compostingTime Time that take the waste to descompose.
	*	@param product Product that produce the waste.
	*	@param type Type of the recycle waste.
	*	@param desc Waste description.
	*/
	//Constructor
	public Recyclable(String id, String name, String origin, String color, int compostingTime, Product product, String type, String desc){
		super(id,name,origin,color,compostingTime,product);
		this.type = type;
		this.desc = desc;
	}

	/**
	*	This method calculate the harmful effect of one recyclable waste on the world. 
	*	Keep in mind the description of the proper way to have of the waste and the factors..<br>
    *   @return The harmful effect of one recyclable waste on the world.
	*/
	@Override
	public double harmfulEffect(){
		double effect = 0;
		if(super.getOrigin().equals(Constants.INDUSTRIAL)){
			if(desc.length()>10){
				effect = super.getCompostingTime()*(Constants.FACTINDUSTRIAL-0.02);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTINDUSTRIAL);
			}
		}else if(super.getOrigin().equals(Constants.DOMICILIARY)){
			if(desc.length()>10){
				effect = super.getCompostingTime()*(Constants.FACTDOMICILIARY-0.02);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTDOMICILIARY);
			}
		}else if(super.getOrigin().equals(Constants.MUNICIPAL)){
			if(desc.length()>10){
				effect = super.getCompostingTime()*(Constants.FACTMUNICIPAL-0.02);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTMUNICIPAL);
			}
		}else if(super.getOrigin().equals(Constants.CONSTRUCTION)){
			if(desc.length()>10){
				effect = super.getCompostingTime()*(Constants.FACTCONSTRUCTION-0.02);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTCONSTRUCTION);
			}
		}else if(super.getOrigin().equals(Constants.HOSPITABLE)){
			if(desc.length()>10){
				effect = super.getCompostingTime()*(Constants.FACTHOSPITABLE-0.02);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTHOSPITABLE);
			}
		}
		return effect;
	}

	/**
	*	This method calculate if the recyclable waste is usable to composting.<br>
    *   @return If is usable to composting.
	*/
	@Override
	public boolean usableComposting(){
		if(desc.length()>10){
			return true;
		}else{
			return false;
		}
	}

	/**
	*	This method show information of the recyclable waste.<br>
    *   @return Information of the recyclable waste.
	*/
	@Override
	public String toString(){
		return super.toString();
	}

	/**
	*	This method get the type of the recyclable waste.<br>
    *   @return The type of recyclable waste.
	*/
	public String getType(){
		return type;
	}
	
	/**
	*	This method get the recyclable waste description.<br>
    *   @return The recyclable waste description.
	*/
	public String getDesc(){
		return desc;
	}

}