/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.Objects;

/**
* MutualFund.
* 
*  
* @author Gurtej Dhami
* @version 2.0
*/
public class MutualFund extends Investment {
    public MutualFund(String symbol, String name, int quantity, double price){
        super(symbol, name, quantity, price);
        double Fvalue = price*quantity;
        this.setBookValue(Fvalue);
    }
    public double gain(){
        return getPrice()*getQuantity()-45.00-getbookValue();
    }
    /**
     * Compares the fields of a MutualFund instance o to the fields of this instance.
     * @param obj The Object instance to be compared with this instance.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MutualFund other = (MutualFund) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }
    /**
     * Represents an instance field as a member MutualFund.
     * @return Stock string containing the instance fields.
     */
    @Override
    public String toString() {
        return "MutualFund{" +super.toString()+'}';
    }
}
