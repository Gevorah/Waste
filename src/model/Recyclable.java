package model;

public class Recyclable extends Waste implements Usable{

	public static final String PAPER = "Paper";
	public static final String PAPERBOARD = "Paperboard";
	public static final String GLASS = "Glass";
	public static final String PLASTIC = "Plastic";
	public static final String METAL = "Metal";
	
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
		if(super.getOrigin().equals(Waste.INDUSTRIAL)){
			effect = super.getCompostingTime()*(Waste.FACTINDUSTRIAL-0.02);
		}else if(super.getOrigin().equals(Waste.DOMICILIARY)){
			effect = super.getCompostingTime()*(Waste.FACTDOMICILIARY-0.02);
		}else if(super.getOrigin().equals(Waste.MUNICIPAL)){
			effect = super.getCompostingTime()*(Waste.FACTMUNICIPAL-0.02);
		}else if(super.getOrigin().equals(Waste.CONSTRUCTION)){
			effect = super.getCompostingTime()*(Waste.FACTCONSTRUCTION-0.02);
		}else if(super.getOrigin().equals(Waste.HOSPITABLE)){
			effect = super.getCompostingTime()*(Waste.FACTHOSPITABLE-0.02);
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