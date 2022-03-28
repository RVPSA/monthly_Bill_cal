/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthly_bill_calculator;

import java.util.Date;

/**
 *
 * @author Akesh
 */
public class ElectricityBill implements Bill{
    int units;
    String month;
    Date lastBillingDate;
    String customerName;
    private double total;
    
    public ElectricityBill(int units,String month,Date lastBillingDate,
    String customerName){
        this.units=units;
        this.month=month;
        this.lastBillingDate=lastBillingDate;
        this.customerName=customerName;
        calc(units);
    }
    
    public double calc(int units){
        if(units>=0 && units<=60)total=part1(units);
        else if(units>60 && units<=90)total=part2(units);
        else if(units>90 && units<=120) total=part3(units);
        else if(units>120 && units<=180) total=part4(units);
        else if(units>180) total=part5(units);
        return total;
    }
    
    private double part1(int units){
        if(units<=30) return units*2.50+30;
        else return ((30*2.50)+((units-30)*4.85+60));
    }
    
    private double part2(int units){
        return ((60*7.85)+((units-60)*10+90));
    }
    
    private double part3(int units){
        return ((part2(90)-90)+((units-90)*27.75+480));
    }
    
    private double part4(int units){
        return ((part3(120)-480)+((units-120)*32+480));
    }
    
    private double part5(int units){
        return ((part4(180)-480)+((units-180)*45+540));
    }
    
    public String toString(){
        String out="Customer name: "+this.customerName;
        out+="\nLastBilling date: "+this.lastBillingDate;
        out+="\nTotal: Rs:"+this.total;
        return out;
    }
}
