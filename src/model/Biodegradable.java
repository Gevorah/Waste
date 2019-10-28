package model;

/**
*	This class allows create biodegradable waste.
*	@author Jhon Ijaji.
*	@version 1.0
*	@since 1.0
*/
public class Biodegradable extends Waste implements Usable{
	
	//Attributes
	private boolean composting;
	
	/**
	*	Biodegradable constructor.<br>
	*	@param id Waste id.
	*	@param name Waste name.
	*	@param origin Waste origin.
	*	@param color Waste color.
	*	@param compostingTime Time that take the waste to descompose.
	*	@param product Product that produce the waste.
	*	@param composting If the waste is suitable to descompose.
	*/
	//Constructor
	Biodegradable(String id, String name, String origin, String color, int compostingTime, Product product, boolean composting){
		super(id,name,origin,color,compostingTime,product);
		this.composting = composting;
	}

	/**
	*	This method calculate the harmful effect of one recyclable waste on the world.
	*	Keep in mind if is suitable to composting and the factors.<br>
    *   @return The harmful effect of one recyclable waste on the world.
	*/
	@Override
	public double harmfulEffect(){
		double effect = 0;
		String origin = super.getOrigin();
		int compostingTime = super.getCompostingTime();
		if(origin.equalsIgnoreCase(Constants.INDUSTRIAL)){
			if(composting==true){;
				effect = compostingTime*(Constants.FACTINDUSTRIAL-0.01);
			}else{
				effect = compostingTime*(Constants.FACTINDUSTRIAL);
			}
		}else if(origin.equalsIgnoreCase(Constants.DOMICILIARY)){
			if(composting==true){
				effect = compostingTime*(Constants.FACTDOMICILIARY-0.01);
			}else{
				effect = compostingTime*(Constants.FACTDOMICILIARY);
			}
		}else if(origin.equalsIgnoreCase(Constants.MUNICIPAL)){
			if(composting==true){
				effect = compostingTime*(Constants.FACTMUNICIPAL-0.01);
			}else{
				effect = compostingTime*(Constants.FACTMUNICIPAL);
			}
		}else if(origin.equalsIgnoreCase(Constants.CONSTRUCTION)){
			if(composting==true){
				effect = compostingTime*(Constants.FACTCONSTRUCTION-0.01);
			}else{
				effect = compostingTime*(Constants.FACTCONSTRUCTION);
			}
		}else if(origin.equalsIgnoreCase(Constants.HOSPITABLE)){
			if(composting==true){
				effect = compostingTime*(Constants.FACTHOSPITABLE-0.01);
			}else{
				effect = compostingTime*(Constants.FACTHOSPITABLE);
			}
		}
		return effect;
	}

	/**
	*	This method calculate if the biodegradable waste is usable to composting.<br>
    *   @return If is usable to composting.
	*/
	@Override
	public boolean usableComposting(){
		if(super.getCompostingTime()<365 && composting==true){
			return true;
		}else{
			return false;
		}
	}

	/**
	*	This method show information of the biodegradable waste.<br>
    *   @return Information of the biodegradable waste.
	*/
	@Override
	public String toString(){
		return super.toString();
	}
	
	/**
	*	This method get if the biodegradable waste is suitable to descompose.<br>
    *   @return If the waste is suitable to descompose.
	*/
	public boolean getComposting(){
		return composting;
	}

}