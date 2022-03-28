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
public class WaterBill implements Bill{
    int units;
    String month;
    Date lastBillingDate;
    String customerName;
    private double total;
    
    public WaterBill(int units,String month,Date lastBillingDate,
    String customerName){
        this.units=units;
        this.month=month;
        this.lastBillingDate=lastBillingDate;
        this.customerName=customerName;
        this.total=calc(units);
    }
    
    public double calc(int units){
        if(units>=0 && units<=5){
            return (units*12+50);
        }
        else if(units>6 && units<=10){
            return ((5*12)+(units-5)*16+65);
        }
        else if(units>10 && units<=15){
            return ((5*12)+(5*16)+(units-10)*20+70);
        }
        else if(units>15 && units<=20){
            return ((5*12)+(5*16)+(5*20)+(units-15)*40+80);
        }
        else if(units>20 && units<25){
            return ((5*12)+(5*16)+(5*20)+(5*40)+(units-20)*58+100);
        }
        else return 0;
    }
    
    public String toString(){
        String out="Customer name: "+this.customerName;
        out+="\nMonth: "+this.month;
        out+="\nTotal: Rs:"+this.total;
        return out;
    }
}
