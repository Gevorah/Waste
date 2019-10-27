package model;

public class Recyclable extends Waste implements Usable{
	
	private String type;
	private String desc;
	
	public Recyclable(String id, String name, String origin, String color, int compostingTime, Product product, String type, String desc){
		super(id,name,origin,color,compostingTime,product);
		this.type = type;
		this.desc = desc;
	}

	@Override
	public double harmfulEffect(){
		double effect = 0;
		if(super.getOrigin().equals(Constants.INDUSTRIAL)){
			effect = super.getCompostingTime()*(Constants.FACTINDUSTRIAL-0.02);
		}else if(super.getOrigin().equals(Constants.DOMICILIARY)){
			effect = super.getCompostingTime()*(Constants.FACTDOMICILIARY-0.02);
		}else if(super.getOrigin().equals(Constants.MUNICIPAL)){
			effect = super.getCompostingTime()*(Constants.FACTMUNICIPAL-0.02);
		}else if(super.getOrigin().equals(Constants.CONSTRUCTION)){
			effect = super.getCompostingTime()*(Constants.FACTCONSTRUCTION-0.02);
		}else if(super.getOrigin().equals(Constants.HOSPITABLE)){
			effect = super.getCompostingTime()*(Constants.FACTHOSPITABLE-0.02);
		}
		return effect;
	}

	@Override
	public boolean usableComposting(){
		if(desc.length()>10){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString(){
		return super.toString();
	}

	public String getType(){
		return type;
	}
	
	public String getDesc(){
		return desc;
	}

}