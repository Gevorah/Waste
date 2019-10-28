package model;

/**
*	This class allows create inert waste.
*	@author Jhon Ijaji.
*	@version 1.0
*	@since 1.0
*/
public class Inert extends Waste{

	//Attribute
	private String tips;
	
	/**
	*	Inert constructor.<br>
	*	@param id Waste id.
	*	@param name Waste name.
	*	@param origin Waste origin.
	*	@param color Waste color.
	*	@param compostingTime Time that take the waste to descompose.
	*	@param product Product that produce the waste.
	*	@param tips Tips for reduce de use of inert waste.
	*/
	//Constructor
	public Inert(String id, String name, String origin, String color, int compostingTime, Product product, String tips){
		super(id,name,origin,color,compostingTime,product);
		this.tips = tips;
	}

	/**
	*	This method calculate the harmful effect of one inert waste on the world. Keep in mind the factors.<br>
    *   @return The harmful effect of one inert waste on the world.
	*/
	@Override
	public double harmfulEffect(){
		double effect = 0;
		if(super.getOrigin().equals(Constants.INDUSTRIAL)){
			effect = super.getCompostingTime()*Constants.FACTINDUSTRIAL;
		}else if(super.getOrigin().equals(Constants.DOMICILIARY)){
			effect = super.getCompostingTime()*Constants.FACTDOMICILIARY;
		}else if(super.getOrigin().equals(Constants.MUNICIPAL)){
			effect = super.getCompostingTime()*Constants.FACTMUNICIPAL;
		}else if(super.getOrigin().equals(Constants.CONSTRUCTION)){
			effect = super.getCompostingTime()*Constants.FACTCONSTRUCTION;
		}else if(super.getOrigin().equals(Constants.HOSPITABLE)){
			effect = super.getCompostingTime()*Constants.FACTHOSPITABLE;
		}
		return effect;
	}

	/**
	*	This method show information of the inert waste.<br>
    *   @return Information of the inert waste.
	*/
	@Override
	public String toString(){
		return super.toString();
	}

	/**
	*	This method show the tips for reduce the use of the inert waste.<br>
    *   @return Tips to reduce the use of the inert waste.
	*/
	public String getTips(){
		return tips;
	}

}