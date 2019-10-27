package model;

import java.util.ArrayList;

public class Reciclamos {

    private ArrayList<Product> products;

    public Reciclamos() {
        products = new ArrayList<>();
    }

    public void addProduct(String id, String name, String desc) {
        products.add(new Product(id, name, desc));
    }

    public void addWaste(String id, String name, String origin, String color, int compostingTime, Product product, boolean composting) {
        product.getWaste().add(new Biodegradable(id, name, origin, color, compostingTime, product, composting));
    }
    public void addWaste(){

    }
    public void addWaste(String id, String name, String origin, String color, int compostingTime, Product product, String tips) {
        product.getWaste().add(new Inert(id, name, origin, color, compostingTime, product, tips));
    }

    public void addWaste(String id, String name, String origin, String color, int compostingTime, Product product, String type, String desc) {
        product.getWaste().add(new Recyclable(id, name, origin, color, compostingTime, product, type, desc));
    }

    public String searchInfoWaste(String search) {
        String info = "Doesn't exist";
        for (Product tempProduct : products) {
            ArrayList<Waste> temp = tempProduct.getWaste();
            for (Waste waste : temp) {
                if (search.equalsIgnoreCase(waste.getName()) || search.equalsIgnoreCase(waste.getProduct().getId())) {
                    info = String.format("%s", waste.toString());
                }
            }
        }
        return info;
    }

    public Product check(String check) {
        Product tempProduct2 = null;
        for (Product tempProduct : products) {
            if (check.equalsIgnoreCase(tempProduct.getName()) || check.equalsIgnoreCase(tempProduct.getId())) {
                tempProduct2 = tempProduct;
            }
        }
        return tempProduct2;
    }

    public String report(){
        int character = 97;
        char aux;
        String info = String.format("%n%s%n","Biodegradable");
        for(Product tempProduct: products){
            ArrayList<Waste> temp = tempProduct.getWaste();
            for(Waste waste: temp){
                if(waste instanceof Biodegradable){
                    aux = (char) character;
                    info += String.format("%s. %s%n",aux,waste.toString());
                    character++;
                    if(character>=122){
                        character = 65;
                    }
                }
            }
        }
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

    public String showProducts(){
        String show = "";
        for(Product tempProduct: products){
            show += String.format("%s%n",tempProduct.toString());
        }
        return show;
    }

    public String productWaste(Product product){
        String show = "";
        Waste[] temp = list(product);
        temp = organizeHarmfulEffect(temp);
        for(Waste waste: temp){
            show += String.format("%s%n",waste.getName());
        }
        return show;
    }

    public Waste[] organizeHarmfulEffect(Waste[] array){
        Waste select;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j].harmfulEffect()<array[j+1].harmfulEffect()){
                    select = array[j];
                    array[j] = array[j+1];
                    array[j+1] = select;
                }
            }
        }
        return array;
    }

    public Waste[] list(Product product){
        int index = 0;
        ArrayList<Waste> tempWaste = new ArrayList<>();
        for(Product tempProduct: products){
            if(tempProduct.equals(product)){
                tempWaste = tempProduct.getWaste();
                index = tempWaste.size();
            }
            
        }
        Waste[] temp = new Waste[index];
        int i = 0;
        for(Waste waste: tempWaste){
            temp[i] = waste;
            i++;
        }
        return temp;
    }

}