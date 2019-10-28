package model;

import java.util.ArrayList;

/**
*	This class allows create products and waste.
*	@author Jhon Ijaji.
*	@version 1.0
*	@since 1.0
*/
public class Reciclamos{

    //Attribute
    private ArrayList<Product> products;

    /**
	*	Reciclamos constructor<br>
	*/
    //Constructor
    public Reciclamos() {
        products = new ArrayList<>();
    }

    /**
	*	This method add products.<br>
	*	<b>pre:</b> The list of products must be initialized.<br>
	*	<b>post:</b> The product has been added.<br>
    *	@param id The product identifier.
    *   @param name The product name.
    *   @param desc The product description.
	*/
    //Method that add products to the products ArrayList.
    public void addProduct(String id, String name, String desc) {
        products.add(new Product(id, name, desc));
    }

    /**
	*	This method add waste.<br>
	*	<b>pre:</b> The list of waste must be initialized.<br>
	*	<b>post:</b> The waste has been added.<br>
    *	@param id The waste identifier.
    *   @param name The waste name.
    *   @param origin The waste origin.
    *   @param color The waste color.
    *   @param compostingTime The time that take the waste to descompose.
    *   @param product The product that produces the waste.
    *   @param composting If the waste is usable to composting.
	*/
    //Overcharge the methods addWaste for add the different waste of each type. 
    public void addWaste(String id, String name, String origin, String color, int compostingTime, Product product, boolean composting) {
        product.getWaste().add(new Biodegradable(id, name, origin, color, compostingTime, product, composting));
    }

    /**
	*	This method add waste.<br>
	*	<b>pre:</b> The list of waste must be initialized.<br>
	*	<b>post:</b> The waste has been added.<br>
    *	@param id The waste identifier.
    *   @param name The waste name.
    *   @param origin The waste origin.
    *   @param color The waste color.
    *   @param compostingTime The time that take the waste to descompose.
    *   @param product The product that produces the waste.
    *   @param tips The waste tips to reduce the use.
	*/
    public void addWaste(String id, String name, String origin, String color, int compostingTime, Product product, String tips) {
        product.getWaste().add(new Inert(id, name, origin, color, compostingTime, product, tips));
    }

    /**
	*	This method add waste.<br>
	*	<b>pre:</b> The list of waste must be initialized.<br>
	*	<b>post:</b> The waste has been added.<br>
    *	@param id The waste identifier.
    *   @param name The waste name.
    *   @param origin The waste origin.
    *   @param color The waste color.
    *   @param compostingTime The time that take the waste to descompose.
    *   @param product The product that produces the waste.
    *   @param type The type of recyclable waste.
    *   @param desc The waste description.
	*/
    public void addWaste(String id, String name, String origin, String color, int compostingTime, Product product, String type, String desc) {
        product.getWaste().add(new Recyclable(id, name, origin, color, compostingTime, product, type, desc));
    }

    /**
	*	This method search the info of one waste.<br>
	*	<b>pre:</b> The products list and waste list must be initialized.<br>
	*	<b>post:</b> The information has been finded and copied.<br>
    *	@param search The name or id of the waste to search.
    *   @return The information of one waste.
	*/
    //Method that search and return the info of one waste.
    public String searchInfoWaste(String search) {
        String info = "Doesn't exist.";
        //Go through the products ArrayList.
        for (Product tempProduct : products) {
            //Create a temporal ArrayList for get the ArrayList of waste into the product.
            ArrayList<Waste> temp = tempProduct.getWaste();
            //Go trhough the temp ArrayList.
            for (Waste waste : temp) {
                //Select the waste object that meets the conditions.
                if (search.equalsIgnoreCase(waste.getName()) || search.equalsIgnoreCase(waste.getProduct().getId())){
                    //Paste the information of the toString method of the waste object.
                    info = String.format("%s", waste.toString());
                }
            }
        }
        return info;
    }

    /**
	*	This method serach one product.<br>
	*	<b>pre:</b> The product list must be initialized.<br>
	*	<b>post:</b> The product has been finded.<br>
    *	@param check The name or the id of the product to search
    *   @return A product finded.
	*/
    //Method that search and return one product.
    public Product check(String check) {
        //Create a temporal product as null.
        Product tempProduct2 = null;
        //Go through the products ArrayList.
        for (Product tempProduct : products) {
            //Select the product object that meets the conditions.
            if (check.equalsIgnoreCase(tempProduct.getName()) || check.equalsIgnoreCase(tempProduct.getId())) {
                //Paste the product to the null temporal product.
                tempProduct2 = tempProduct;
            }
        }
        return tempProduct2;
    }

    /**
	*	This method create a report of all waste.<br>
	*	<b>pre:</b> The list of waste must be initialized.<br>
    *	<b>post:</b> The report has been created.<br>
    *   @return The report organized of all waste. Each one with the information.
	*/
    //Method that make a report of the waste.
    public String report(){
        //Create a local variables.
        int character = 97;
        char aux;
        String info = String.format("%n%s%n","Biodegradable");
        //Go through the products ArrayList.
        for(Product tempProduct: products){
            //Create a temporal ArrayList for get the ArrayList of waste into the product.
            ArrayList<Waste> temp = tempProduct.getWaste();
            //Go through the waste ArrayList.
            for(Waste waste: temp){
                //Check the instance of the waste object.
                if(waste instanceof Biodegradable){
                    //Use the local variables to make a report.
                    aux = (char) character;
                    info += String.format("%s. %s%n",aux,waste.toString());
                    character++;
                    if(character>=122){
                        character = 65;
                    }
                }
            }
        }
        //The next lines of the method repeat the same structure.
        info += String.format("%n%s%n","Inert");
        for(Product tempProduct: products){
            ArrayList<Waste> temp = tempProduct.getWaste();
            for(Waste waste: temp){
                if(waste instanceof Inert){
                    aux = (char) character;
                    info += String.format("%s. %s%n",aux,waste.toString());
                    character++;
                    if(character>=122){
                        character = 65;
                    }
                }
            }
        }
        info += String.format("%n%s%n","Recyclable");
        for(Product tempProduct: products){
            ArrayList<Waste> temp = tempProduct.getWaste();
            for(Waste waste: temp){
                if(waste instanceof Recyclable){
                    aux = (char) character;
                    info += String.format("%s. %s%n",aux,waste.toString());
                    character++;
                    if(character>=122){
                        character = 65;
                    }
                }
                
            }
        }
        return info;
    }

    /**
	*	This method show the information of all products.<br>
	*	<b>pre:</b> The list of products must be initialized.<br>
    *	<b>post:</b> The products basic information has been showed.<br>
    *   @return The products with basic information of each one.
	*/
    //Method for show the products.
    public String showProducts(){
        //Local variable.
        String show = "";
        //Go through the products ArrayList.
        for(Product tempProduct: products){
            //Paste the product information.
            show += String.format("%s%n",tempProduct.toString());
        }
        return show;
    }

    /**
	*	This method show the waste of one product organized form highest to lowest the harmful effect.<br>
	*	<b>pre:</b> The product list and waste list must be initialized.<br>
	*	<b>post:</b> The waste has been added.<br>
    *	@param product The product to show the waste in order.
    *   @throws Exception If the list hasn't been initialized or is null.
    *   @return The name of products and the needed informatioo of the waste that contain.
	*/
    //Method that search one product and return the needed information of the waste that contain.
    public String productWaste(Product product){
        //Create a local variables.
        String show = "";
        //Create a array that receive a array of the method list(Product).
        Waste[] temp = list(product);
        //Call to the method organizeHarmfulEffect(Waste[]).
        temp = organizeHarmfulEffect(temp);
        //Go through the products ArrayList.
        for(Waste waste: temp){
            //Paste the name of the waste.
            show += String.format("%s : %,.2f%n",waste.getName(),waste.harmfulEffect());
        }
        return show;
    }

    /**
	*	This method reorganize one list from highest to lowest the harmful effect.<br>
	*	<b>pre:</b> The list of waste must be initialized.<br>
	*	<b>post:</b> The lis has been reorganized.<br>
    *	@param array The list to organize.
    *   @throws OutOfTheBoundException If the iterator out of the bound of the list. 
    *   @return A list organized form highest to lowest harmful effect.
	*/
    //This method reorganize a array.
    public Waste[] organizeHarmfulEffect(Waste[] array){
        //Create a local waste.
        Waste select;
        //Go through the array and reorganize.
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                //Reorganize the greater to less
                if(array[j].harmfulEffect()<array[j+1].harmfulEffect()){
                    select = array[j];
                    array[j] = array[j+1];
                    array[j+1] = select;
                }
            }
        }
        return array;
    }

    /**
	*	This method search one product and copy the waste list that contain.<br>
	*	<b>pre:</b> The list of products must be initialized.<br>
	*	<b>post:</b> The waste list has been finded.<br>
    *	@param product The product to get the waste list.
    *   @return The list of waste.
	*/
    //Method that search one product and paste the waste list in one array.
    public Waste[] list(Product product){
        int index = 0;
        //Temporal Waste ArrayList
        ArrayList<Waste> tempWaste = new ArrayList<>();
        //Go through the products ArrayList. 
        for(Product tempProduct: products){
            //Check if the product meets the condition.
            if(tempProduct.equals(product)){
                //Paste the waste array of the product to the temporal ArrayList and get the size.
                tempWaste = tempProduct.getWaste();
                index = tempWaste.size();
            }
        }
        //Create a temporal array.
        Waste[] temp = new Waste[index];
        int i = 0;
        //Go through the waste ArrayList and paste the elements to the temporal array.
        for(Waste waste: tempWaste){
            temp[i] = waste;
            i++;
        }
        return temp;
    }

    /**
	*	This method search a waste and show if is usable.<br>
	*	<b>pre:</b> The product list and waste list must be initialized.<br>
	*	<b>post:</b> The waste has been added.<br>
    *	@param check The name or id of the waste to use.
    *   @return If the waste is usable.
	*/
    //Method that check the instance for use the method of the interface Usable.
    public String showUsable(String check){
        //Local variables
        String show = "Incorrect. Try again..";
        Usable usable;
        //Go through the products ArrayList. 
        for(Product temPro: products){
            //Create a temporal ArrayList and paste the ArrayList of the product
            ArrayList<Waste> temp = temPro.getWaste();
            //Go through the products ArrayList. 
            for(Waste tempWas: temp){
                //Check the instance of the waste and use the method of the interface.
                if(tempWas instanceof Biodegradable){
                    if(tempWas.getName().equalsIgnoreCase(check)||tempWas.getId().equalsIgnoreCase(check)){
                        usable = (Biodegradable)tempWas;
                        if(usable.usableComposting()){
                            show = "True.";
                        }else{
                            show = "False.";
                        }
                    }
                }else if(tempWas instanceof Recyclable){
                    if(tempWas.getName().equalsIgnoreCase(check)||tempWas.getId().equalsIgnoreCase(check)){
                        usable = (Recyclable)tempWas;
                        if(usable.usableComposting()){
                            show = "True.";
                        }else{
                            show = "False.";
                        }
                    }
                }
            }
        }
        return show;
    }

    /**
	*	This method compare and change one text with constants.<br>
	*	<b>post:</b> The text has been changed.<br>
    *   @param origin The waste origin to compare.
    *   @return The tex changed with the needed.
	*/
    //Methods that compare and change one string depends of the condition
    public String checkOrigin(String origin){
        if(origin.equalsIgnoreCase(Constants.CONSTRUCTION)||origin.equalsIgnoreCase("C")){
            origin = Constants.CONSTRUCTION;
        }else if(origin.equalsIgnoreCase(Constants.DOMICILIARY)||origin.equalsIgnoreCase("D")){
            origin = Constants.DOMICILIARY;
        }else if(origin.equalsIgnoreCase(Constants.HOSPITABLE)||origin.equalsIgnoreCase("H")){
            origin = Constants.HOSPITABLE;
        }else if(origin.equalsIgnoreCase(Constants.INDUSTRIAL)||origin.equalsIgnoreCase("I")){
            origin = Constants.INDUSTRIAL;
        }else if(origin.equalsIgnoreCase(Constants.MUNICIPAL)||origin.equalsIgnoreCase("M")){
            origin = Constants.MUNICIPAL;
        }else{
            origin = "Incorrect.";
        }
        return origin;
    }

    /**
	*	This method compare and change one text with constants.<br>
	*	<b>post:</b> The text has been changed.<br>
    *   @param typeRecyclable The waste origin to compare.
    *   @return The tex changed with the needed.
	*/
    public String checkTypeRec(String typeRecyclable){
        if(typeRecyclable.equalsIgnoreCase(Constants.PAPER)){
            typeRecyclable = Constants.PAPER;
        }else if(typeRecyclable.equalsIgnoreCase(Constants.PAPERBOARD)){
            typeRecyclable = Constants.PAPERBOARD;
        }else if(typeRecyclable.equalsIgnoreCase(Constants.GLASS)){
            typeRecyclable = Constants.GLASS;
        }else if(typeRecyclable.equalsIgnoreCase(Constants.PLASTIC)){
            typeRecyclable = Constants.PLASTIC;
        }else if(typeRecyclable.equalsIgnoreCase(Constants.METAL)){
            typeRecyclable = Constants.METAL;
        }else{
            typeRecyclable = "Incorrect.";
        }
        return typeRecyclable;
    }

}