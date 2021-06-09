/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Objects;

/**
 *
 * @author Dhami777
 */
public class Stock extends Investment {
    
    public Stock(String symbol, String name, int quantity, double price){
        super(symbol, name, quantity, price);
    }
    /**
     * Compares the fields of a Stock instance o to the fields of this instance.
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
        final Stock other = (Stock) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }
    /**
     * Represents an instance field as a member Stock.
     * @return Stock string containing the instance fields.
     */
    @Override
    public String toString() {
        return "Stock{" +super.toString()+ '}';
    }
    
}
