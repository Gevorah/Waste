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
		if(super.getOrigin().equals(Waste.INDUSTRIAL)){
			if(composting){
				effect = super.getCompostingTime()*Waste.FACTINDUSTRIAL;
			}else{
				effect = super.getCompostingTime()*(Waste.FACTINDUSTRIAL);
			}
		}else if(super.getOrigin().equals(Waste.DOMICILIARY)){
			if(composting){
				effect = super.getCompostingTime()*Waste.FACTDOMICILIARY;
			}else{
				effect = super.getCompostingTime()*(Waste.FACTDOMICILIARY);
			}
		}else if(super.getOrigin().equals(Waste.MUNICIPAL)){
			if(composting){
				effect = super.getCompostingTime()*Waste.FACTMUNICIPAL;
			}else{
				effect = super.getCompostingTime()*(Waste.FACTMUNICIPAL);
			}
		}else if(super.getOrigin().equals(Waste.CONSTRUCTION)){
			if(composting){
				effect = super.getCompostingTime()*Waste.FACTCONSTRUCTION;
			}else{
				effect = super.getCompostingTime()*(Waste.FACTCONSTRUCTION);
			}
		}else if(super.getOrigin().equals(Waste.HOSPITABLE)){
			if(composting){
				effect = super.getCompostingTime()*Waste.FACTHOSPITABLE;
			}else{
				effect = super.getCompostingTime()*(Waste.FACTHOSPITABLE);
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