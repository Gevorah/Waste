package model;

public abstract class Waste{
	
	public static final String INDUSTRIAL = "Industrial";
	public static final String DOMICILIARY = "Domiciliary";
	public static final String MUNICIPAL = "Municipal";
	public static final String CONSTRUCTION = "Construction";
	public static final String HOSPITABLE = "Hospitable";
	public static final double FACTINDUSTRIAL = 0.10;
	public static final double FACTDOMICILIARY = 0.05;
	public static final double FACTMUNICIPAL = 0.08;
	public static final double FACTCONSTRUCTION = 0.12;
	public static final double FACTHOSPITABLE = 0.15;

	private String id;
	private String name;
	private String origin;
	private String color;
	private int compostingTime;
	private Product product;
	
	public Waste(String id, String name, String origin, String color, int compostingTime, Product product){
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.color = color;
		this.compostingTime = compostingTime;
		this.product = product;
	}

	public abstract double harmfulEffect();

	@Override
	public String toString(){
		return String.format("%s - %s - %s - %s - %d - %s",id,name,origin,color,compostingTime,product.toString());
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getColor(){
		return color;
	}
	
	public int getCompostingTime(){
		return compostingTime;
	}
	
	public Product getProduct(){
		return product;
	}

}