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

	@Override
	public String toString(){
		return super.toString();
	}

	public String getTips(){
		return tips;
	}

}