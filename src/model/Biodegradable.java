package model;

public class Biodegradable extends Waste implements Usable{
	
	private boolean composting;
	
	Biodegradable(String id, String name, String origin, String color, int compostingTime, Product product, boolean composting){
		super(id,name,origin,color,compostingTime,product);
		this.composting = composting;
	}

	@Override
	public double harmfulEffect(){
		double effect = 0;
		if(super.getOrigin().equals(Constants.INDUSTRIAL)){
			if(composting){
				effect = super.getCompostingTime()*(Constants.FACTINDUSTRIAL-0.1);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTINDUSTRIAL);
			}
		}else if(super.getOrigin().equals(Constants.DOMICILIARY)){
			if(composting){
				effect = super.getCompostingTime()*(Constants.FACTDOMICILIARY-0.1);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTDOMICILIARY);
			}
		}else if(super.getOrigin().equals(Constants.MUNICIPAL)){
			if(composting){
				effect = super.getCompostingTime()*(Constants.FACTMUNICIPAL-0.1);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTMUNICIPAL);
			}
		}else if(super.getOrigin().equals(Constants.CONSTRUCTION)){
			if(composting){
				effect = super.getCompostingTime()*(Constants.FACTCONSTRUCTION-0.1);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTCONSTRUCTION);
			}
		}else if(super.getOrigin().equals(Constants.HOSPITABLE)){
			if(composting){
				effect = super.getCompostingTime()*(Constants.FACTHOSPITABLE-0.1);
			}else{
				effect = super.getCompostingTime()*(Constants.FACTHOSPITABLE);
			}
		}
		return effect;
	}

	@Override
	public boolean usableComposting(){
		if(super.getCompostingTime()<365 || composting==true){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString(){
		return super.toString();
	}
	
	public boolean getComposting(){
		return composting;
	}

}