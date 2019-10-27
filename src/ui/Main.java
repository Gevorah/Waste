package ui;
import model.Reciclamos;
import model.Recyclable;
import model.Waste;

import java.util.Scanner;

public class Main {

    private Scanner reader;
    private Reciclamos control;

    public Main(){
        reader = new Scanner(System.in);
    }

    public void init(){
        control = new Reciclamos();
        control.addProduct("10001","Mango","Yellow fruit");
        control.addWaste("12343","Mango Peel","Domiciliary","Green",10,control.check("Mango"),true);
        control.addWaste("12344","Mango Seed","Domiciliary","White",10,control.check("Mango"),false);
    }

    public static void main(String[] args){
        Main main = new Main();
        main.init();
        boolean end = false;
        do{
            main.menu();
            int menu = main.reader.nextInt();
            int endAux = 1;
            String wasteType,idWaste,nameWaste,origin,color,idProduct,nameProduct,descProduct,search;
            String tips = "";
            String typeRecyclable = ""; 
            String descWaste = "";
            int compostingTime = 0;
            int check = 0;
            int relation=0;
            boolean composting = false;
            boolean next = false;
            boolean addP = false;
            main.reader.nextLine();
            if(menu==1){
                do{
                    do{
                        System.out.printf("%nWaste Type: ");
                        wasteType = main.reader.nextLine();
                        if(wasteType.equalsIgnoreCase("Biodegradable")){
                            wasteType = "Biodegradable";
                            check = 1;
                            next = true;
                        }else if(wasteType.equalsIgnoreCase("Inert")){
                            wasteType = "Inert";
                            check = 2;
                            next = true;
                        }else if(wasteType.equalsIgnoreCase("Recyclable")){
                            wasteType = "Recyclable";
                            check = 3;
                            next = true;
                        }else{
                            System.out.printf("%nIncorrect. Try Again.%n");
                            next = false;
                        }
                    }while(next==false);
                    do{
                        System.out.printf("%n%s Waste id: ",wasteType);
                        idWaste = main.reader.nextLine();
                        if(main.control.searchInfoWaste(idWaste).equalsIgnoreCase("Doesn't exist")){
                            next = true;
                        }else{
                            System.out.printf("%nThe Waste Already Exist. Try Again.%n");
                            next = false;
                        }
                    }while(next==false);
                    do{
                        System.out.printf("%n%s Waste Name: ",wasteType);
                        nameWaste = main.reader.nextLine();
                        if(main.control.searchInfoWaste(nameWaste).equalsIgnoreCase("Doesn't exist")){
                            next = true;
                        }else{
                            System.out.printf("%nThe Waste Already Exist. Try Again.%n");
                            next = false;
                        }
                    }while(next==false);
                    do{
                        System.out.printf("%n%s Waste Origin: ",wasteType);
                        origin = main.reader.nextLine();
                        if(origin.equalsIgnoreCase(Waste.CONSTRUCTION)){
                            origin = Waste.CONSTRUCTION;
                            next = true;
                        }else if(origin.equalsIgnoreCase(Waste.DOMICILIARY)){
                            origin = Waste.DOMICILIARY;
                            next = true;
                        }else if(origin.equalsIgnoreCase(Waste.HOSPITABLE)){
                            origin = Waste.HOSPITABLE;
                            next = true;
                        }else if(origin.equalsIgnoreCase(Waste.INDUSTRIAL)){
                            origin = Waste.INDUSTRIAL;
                            next = true;
                        }else if(origin.equalsIgnoreCase(Waste.MUNICIPAL)){
                            origin = Waste.MUNICIPAL;
                            next = true;
                        }else{
                            System.out.printf("%nIncorrect Origin. Try Again.%n");
                            next = false; 
                        }
                    }while(next==false);
                    System.out.printf("%n%s Waste Color: ",wasteType);
                    color = main.reader.nextLine();
                    next = false;
                    do{
                        try{
                            System.out.printf("%n%s Waste Time it Takes to Descompose(Days): ",wasteType);
                            compostingTime = main.reader.nextInt();
                            next = true;
                        }catch(Exception e){
                            System.err.printf("%nException: %s",e);
                            System.out.printf("%nMust be a number. Try Again.%n");
                            main.reader.nextLine();
                        }
                    }while(next==false);
                    main.reader.nextLine();
                    if(check==1){
                        do{
                            System.out.printf("%n%s Waste Usable for Composting? ",wasteType);
                            String aux = main.reader.nextLine();
                            if(aux.equalsIgnoreCase("True")||aux.equalsIgnoreCase("T")){
                                composting = true;
                                next = true;
                            }else if(aux.equalsIgnoreCase("False")||aux.equalsIgnoreCase("F")){
                                composting = false;
                                next = true;
                            }else{
                                System.out.printf("%nIncorrect Input. Try Again.%n");
                                next = false;
                            } 
                        }while(next==false);
                    }else if(check==2){
                        System.out.printf("%nTips for %s Waste: ",wasteType);
                        tips = main.reader.nextLine();
                    }else if(check==3){
                        do{
                            System.out.printf("%n%s Waste Type: ",wasteType);
                            typeRecyclable = main.reader.nextLine();
                            if(typeRecyclable.equalsIgnoreCase(Recyclable.PAPER)){
                                typeRecyclable = Recyclable.PAPER;
                                next = true;
                            }else if(typeRecyclable.equalsIgnoreCase(Recyclable.PAPERBOARD)){
                                typeRecyclable = Recyclable.PAPERBOARD;
                                next = true;
                            }else if(typeRecyclable.equalsIgnoreCase(Recyclable.GLASS)){
                                typeRecyclable = Recyclable.GLASS;
                                next = true;
                            }else if(typeRecyclable.equalsIgnoreCase(Recyclable.PLASTIC)){
                                typeRecyclable = Recyclable.PLASTIC;
                                next = true;
                            }else if(typeRecyclable.equalsIgnoreCase(Recyclable.METAL)){
                                typeRecyclable = Recyclable.METAL;
                                next = true;
                            }else{
                                System.out.printf("%nIncorrect Input. Try Again.%n");
                                next = false;
                            } 
                        }while(next==false);
                        System.out.printf("%n%s Waste Description: ",wasteType);
                        descWaste = main.reader.nextLine();
                    }
                    do{
                        System.out.printf("%nProduct Name: ");
                        nameProduct = main.reader.nextLine();
                        if(main.control.check(nameProduct)==null){ 
                            boolean endThis = false;
                            do{
                                System.out.printf("%nThe Product %s Doesn't Exist. <1> Add Product or <2> Try Again? ",nameProduct);
                                relation = main.reader.nextInt();
                                if(relation==1){
                                    addP = true;
                                    endThis = true;
                                    next = true;
                                }else if(relation==2){
                                    endThis = true;
                                    next = false;
                                }else{
                                    System.out.printf("%nInvalid Function.%n");
                                    endThis = false;
                                }
                                main.reader.nextLine();
                            }while(endThis==false);
                        }else{
                            next = true;
                        }
                    }while(next==false);
                    if(addP==true){
                        do{
                            System.out.printf("%nProduct id: ");
                            idProduct = main.reader.nextLine();
                            if(main.control.check(idProduct)!=null){
                                next = false;
                                System.out.printf("%nThe id %s Already Exist. Try Again.%n",idProduct);
                            }else{
                                next = true;
                            }
                        }while(next==false);
                        System.out.printf("%nProduct Description: ");
                        descProduct = main.reader.nextLine();
                        main.control.addProduct(idProduct,nameProduct,descProduct);
                    }
                    if(check==1){
                        main.control.addWaste(idWaste,nameWaste,origin,color,compostingTime,main.control.check(nameProduct),composting);
                    }else if(check==2){
                        main.control.addWaste(idWaste,nameWaste,origin,color,compostingTime,main.control.check(nameProduct),tips);
                    }else if(check==3){
                        main.control.addWaste(idWaste,nameWaste,origin,color,compostingTime,main.control.check(nameProduct),typeRecyclable,descWaste);
                    }
                    do{
                        System.out.printf("%n<1> Continue or <2> Return to the Menu? ");
                        endAux = main.reader.nextInt();
                        if(endAux==1||endAux==2){
                            next = true;
                        }else{
                            System.out.printf("%nInvalid Function.%n");
                            next = false;
                        }
                    }while(next==false);
                }while(endAux==1);
            }else if(menu==2){
                do{
                    do{
                        System.out.printf("%nProduct Name: ");
                        nameProduct = main.reader.nextLine();
                        if(main.control.check(nameProduct)!=null){ 
                            System.out.printf("%nThe Product %s Already Exist. Try Again.%n",nameProduct);
                            next = false;
                        }else{
                            next = true;
                        }
                    }while(next==false);
                    do{
                        System.out.printf("%nProduct id: ");
                        idProduct = main.reader.nextLine();
                        if(main.control.check(idProduct)!=null){
                            next = false;
                            System.out.printf("%nThe id %s Already Exist. Try Again.%n",idProduct);
                        }else{
                            next = true;
                        }
                    }while(next==false);
                    System.out.printf("%nProduct Description: ");
                    descProduct = main.reader.nextLine();
                    main.control.addProduct(idProduct,nameProduct,descProduct);
                    do{
                        System.out.printf("%n<1> Add Another Product, <2> Add Waste to the Product or <3> Return to the Menu? ");
                        endAux = main.reader.nextInt();
                        main.reader.nextLine();
                        if(endAux==1){
                            next = true;
                        }else if(endAux==2){
                            do{
                                System.out.printf("%nWaste Type: ");
                                wasteType = main.reader.nextLine();
                                if(wasteType.equalsIgnoreCase("Biodegradable")){
                                    wasteType = "Biodegradable";
                                    check = 1;
                                    next = true;
                                }else if(wasteType.equalsIgnoreCase("Inert")){
                                    wasteType = "Inert";
                                    check = 2;
                                    next = true;
                                }else if(wasteType.equalsIgnoreCase("Recyclable")){
                                    wasteType = "Recyclable";
                                    check = 3;
                                    next = true;
                                }else{
                                    System.out.printf("%nIncorrect. Try Again.%n");
                                    next = false;
                                }
                            }while(next==false);
                            do{
                                System.out.printf("%n%s Waste id: ",wasteType);
                                idWaste = main.reader.nextLine();
                                if(main.control.searchInfoWaste(idWaste).equalsIgnoreCase("Doesn't exist")){
                                    next = true;
                                }else{
                                    System.out.printf("%nThe Waste Already Exist. Try Again.%n");
                                    next = false;
                                }
                            }while(next==false);
                            do{
                                System.out.printf("%n%s Waste Name: ",wasteType);
                                nameWaste = main.reader.nextLine();
                                if(main.control.searchInfoWaste(nameWaste).equalsIgnoreCase("Doesn't exist.")){
                                    next = true;
                                }else{
                                    System.out.printf("%nThe Waste Already Exist. Try Again.%n");
                                    next = false;
                                }
                            }while(next==false);
                            do{
                                System.out.printf("%n%s Waste Origin: ",wasteType);
                                origin = main.reader.nextLine();
                                if(origin.equalsIgnoreCase(Waste.CONSTRUCTION)){
                                    origin = Waste.CONSTRUCTION;
                                    next = true;
                                }else if(origin.equalsIgnoreCase(Waste.DOMICILIARY)){
                                    origin = Waste.DOMICILIARY;
                                    next = true;
                                }else if(origin.equalsIgnoreCase(Waste.HOSPITABLE)){
                                    origin = Waste.HOSPITABLE;
                                    next = true;
                                }else if(origin.equalsIgnoreCase(Waste.INDUSTRIAL)){
                                    origin = Waste.INDUSTRIAL;
                                    next = true;
                                }else if(origin.equalsIgnoreCase(Waste.MUNICIPAL)){
                                    origin = Waste.MUNICIPAL;
                                    next = true;
                                }else{
                                    System.out.printf("%nIncorrect Origin. Try Again.%n");
                                    next = false; 
                                }
                            }while(next==false);
                            System.out.printf("%n%s Waste Color: ",wasteType);
                            color = main.reader.nextLine();
                            next = false;
                            do{
                                try{
                                    System.out.printf("%n%s Waste Time it Takes to Descompose(Days): ",wasteType);
                                    compostingTime = main.reader.nextInt();
                                    next = true;
                                }catch(Exception e){
                                    System.err.printf("%nException: %s",e);
                                    System.out.printf("%nMust be a number. Try Again.%n");
                                    main.reader.nextLine();
                                }
                            }while(next==false);
                            main.reader.nextLine();
                            if(check==1){
                                do{
                                    System.out.printf("%n%s Waste Suitable for Composting? ",wasteType);
                                    String aux = main.reader.nextLine();
                                    if(aux.equalsIgnoreCase("True")||aux.equalsIgnoreCase("T")){
                                        composting = true;
                                        next = true;
                                    }else if(aux.equalsIgnoreCase("False")||aux.equalsIgnoreCase("F")){
                                        composting = false;
                                        next = true;
                                    }else{
                                        System.out.printf("%nIncorrect Input. Try Again.%n");
                                        next = false;
                                    } 
                                }while(next==false);
                            }else if(check==2){
                                tips = main.reader.nextLine();
                            }else if(check==3){
                                do{
                                    System.out.printf("%n%s Waste Type: ",wasteType);
                                    typeRecyclable = main.reader.nextLine();
                                    if(typeRecyclable.equalsIgnoreCase(Recyclable.PAPER)){
                                        typeRecyclable = Recyclable.PAPER;
                                        next = true;
                                    }else if(typeRecyclable.equalsIgnoreCase(Recyclable.PAPERBOARD)){
                                        typeRecyclable = Recyclable.PAPERBOARD;
                                        next = true;
                                    }else if(typeRecyclable.equalsIgnoreCase(Recyclable.GLASS)){
                                        typeRecyclable = Recyclable.GLASS;
                                        next = true;
                                    }else if(typeRecyclable.equalsIgnoreCase(Recyclable.PLASTIC)){
                                        typeRecyclable = Recyclable.PLASTIC;
                                        next = true;
                                    }else if(typeRecyclable.equalsIgnoreCase(Recyclable.METAL)){
                                        typeRecyclable = Recyclable.METAL;
                                        next = true;
                                    }else{
                                        System.out.printf("%nIncorrect Input. Try Again.%n");
                                        next = false;
                                    } 
                                }while(next==false);
                                System.out.printf("%n%s Waste Description: ",wasteType);
                                descWaste = main.reader.nextLine();
                            }
                            next = false;
                        }else if(endAux==3){
                            next = true;
                        }else{
                            System.out.printf("%nInvalid Function.%n");
                            next = false;
                        }
                    }while(next==false);
                }while(endAux==1);
            }else if(menu==3){
                do{
                    System.out.printf("Search: ");
                    search = main.reader.nextLine();
                    if(main.control.searchInfoWaste(search)==null){
                        System.out.printf("%nDoesn't Exist.%n");
                    }else{
                        System.out.printf("%n%s",main.control.searchInfoWaste(search));
                    }
                    do{
                        System.out.printf("%n<1> Continue or <2> Return to the Menu? ");
                        endAux = main.reader.nextInt();
                        if(endAux!=1||endAux!=2){
                            next = true;
                        }else{
                            System.out.printf("%nInvalid Function.%n");
                            next = false;
                        }
                        main.reader.nextLine();
                    }while(next==false);
                }while(endAux==1);
            }else if(menu==4){
                System.out.printf("%nWaste%n%s ",main.control.report());
            }else if(menu==5){
                System.out.printf("%nProducts:%n%s ",main.control.showProducts());
            }else if(menu==6){
                do{
                    System.out.printf("%nSearch: ");
                    search = main.reader.nextLine();
                    if(main.control.check(search)==null){
                        System.out.printf("%nDoesn't Exist.%n");
                    }else{
                       System.out.printf("%n%s Waste:%n%s",main.control.check(search).getName(),main.control.productWaste(main.control.check(search))); 
                    }
                    do{
                        System.out.printf("%n<1> Next Search or <2> Return to the Menu? ");
                        endAux = main.reader.nextInt();
                        if(endAux!=1||endAux!=2){
                            next = true;
                        }else{
                            System.out.printf("%nInvalid Function.%n");
                            next = false;
                        }
                        main.reader.nextLine();
                    }while(next==false);
                }while(endAux==1);
            }else if(menu==0){
                end = true;
            }
        }while(end==false);
    }

    public void menu(){
        System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n",
        "RECICLAMOS","<1> Add Waste","<2> Add Products",
        "<3> Search Waste","<4> Show Waste",
        "<5> Show Products","<6> Show Product Waste",
        "<0> Exit");
    }
}