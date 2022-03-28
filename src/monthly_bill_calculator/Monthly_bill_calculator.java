/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthly_bill_calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akesh
 */
public class Monthly_bill_calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("+ Monthly Bill Calculator +");
        System.out.println("+++++++++++++++++++++++++++");
        Scanner input=new Scanner(System.in);
        System.out.println("Press 'E' for calculating Electricity bill");
        System.out.println("Press 'W' for calculating water bill      ");
        System.out.println("===========================");
        
        System.out.print("Enter E/W: ");
        String choice=input.next().toLowerCase();
        
        switch(choice){
            case "e":
                callingMethod("Electricity");
                break;
            case "w":
                callingMethod("Water");
                break;
            default:
                System.out.println("Wrong Input, Please check your input and run program again");
                
        }
        
        
    }
    public static void callingMethod(String type){
        Scanner input1=new Scanner(System.in);
        System.out.println("\n===========================");
        System.out.println("Category: Domestic");
        System.out.println("Bill Type: "+type);
        System.out.println("\n===========================");
        System.out.print("Enter customer name: ");
        String customerName=input1.next();
        
        System.out.print("Enter previous meter readings: ");
        int previousReading=input1.nextInt();
        
        System.out.print("Enter current meter readings: ");
        int currentReading=input1.nextInt();
        
        int units=currentReading-previousReading;
        
        System.out.print("Enter last billing date(yyyy/MM/dd): ");
        String lastBillingDate=input1.next();
        Date date=new Date();
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(lastBillingDate);
        } catch (ParseException ex) {
            Logger.getLogger(Monthly_bill_calculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("Enter month: ");
        String month=input1.next();
        
        if("Electricity".equals(type)){
        ElectricityBill electricityBill = new ElectricityBill(units, month,
                date, customerName);
        System.out.println(electricityBill.toString());
        }
        else{
            WaterBill waterBill=new WaterBill(units, month, date,
                    customerName);
            System.out.println(waterBill.toString());
        }
        
    }
    
}
