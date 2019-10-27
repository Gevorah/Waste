package model;

public class Inert extends Waste{

	private String tips;
	
	public Inert(String id, String name, String origin, String color, int compostingTime, Product product, String tips){
		super(id,name,origin,color,compostingTime,product);
		this.tips = tips;
	}

	@Override
	public double harmfulEffect(){
		double effect = 0;
		if(super.getOrigin().equals(Waste.INDUSTRIAL)){
			effect = super.getCompostingTime()*Waste.FACTINDUSTRIAL;
		}else if(super.getOrigin().equals(Waste.DOMICILIARY)){
			effect = super.getCompostingTime()*Waste.FACTDOMICILIARY;
		}else if(super.getOrigin().equals(Waste.MUNICIPAL)){
			effect = super.getCompostingTime()*Waste.FACTMUNICIPAL;
		}else if(super.getOrigin().equals(Waste.CONSTRUCTION)){
			effect = super.getCompostingTime()*Waste.FACTCONSTRUCTION;
		}else if(super.getOrigin().equals(Waste.HOSPITABLE)){
			effect = super.getCompostingTime()*Waste.FACTHOSPITABLE;
		}
		return effect;
	}

	@Override
	public String toString(){
		return super.toString();
	}

	public String getTips(){
		return tips;
	}

}