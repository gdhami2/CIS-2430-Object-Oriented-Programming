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
public class Investment {
    
    String symbol; 
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    public Investment(String symbol, String name, int quantity, double price){
        this.symbol = symbol;
        this.name = name;
        this.quantity = quantity;
        this. price = price;
        this.bookValue = price*quantity+9.99;
    }
    
    /**
     * @return The stocks symbol.
     */
    public String getSymbol(){
        return symbol;
    }
    /**
     * @return The stocks name.
     */
    public String getName(){
        return name;
    }
    /**
     * @return The stocks quantity.
     */
    public int getQuantity(){
        return quantity;
    }
    /**
     * @return The stocks price.
     */
    public double getPrice(){
        return price;
    }
    /**
     * @return The stocks bookValue.
     */
    public double getbookValue(){
        return bookValue;
    }
    /**
     * Takes in the amount to sell and the quantity and the sells it
     * @param price the price of the investment
     * @param sellQuantity the amount of the investment to be sold.
     */
    public void sell(double price, int sellQuantity){
        this.price = price;
        this.quantity = this.quantity-sellQuantity;
        this.bookValue = this.bookValue*(1-sellQuantity/100);
    }
    /**
     * calculates the gain based on the price, quantity and bookValue
     * @return the price multiplied by the quantity subtract the book value
     */
    public double gain(){
        return price * quantity-bookValue;
    }
    /**
     * allocates the pice of an investment
     * @param price the price of the investment
     */
    public void setPrice(double price){
        this.price = price;
    }
    /**
     * allocates the bookValue to an investment
     * @param bookValue the bookValue of the investment
     */
    public void setBookValue(double bookValue){
        this.bookValue = bookValue;
    }
    /**
     * Compares the fields of a Investment instance o to the fields of this instance.
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
        final Investment other = (Investment) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }
    /**
     * Represents instance fields as members of a pentuple (symbol, name, quantity, price, bookValue).
     * @return A string containing the instance fields.
     */
    @Override
    public String toString() {
        return "Investment{" + "symbol=" + symbol + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", bookValue=" + bookValue + '}';
    }
    
}
