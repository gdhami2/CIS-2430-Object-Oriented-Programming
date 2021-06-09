/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import java.util.Objects;

/**
 *
 * @author Dhami777
 */
public class Stock {
    String symbol; 
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    
    /**
     * Non-default constructor. Requires all four instance fields to be 
     * provided as input.
     * @param symbol The stocks symbol.
     * @param name The stocks name.
     * @param quantity The stocks quantity.
     * @param price the stocks price.
     */
    public Stock(String symbol, String name, int quantity, double price){
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
     * sells the stock.
     * @param sellQuantity the sell value associated with stock.
     */
    public void sell(int sellQuantity){
        this.quantity = this.quantity-sellQuantity;
        this.bookValue = this.bookValue*(1-sellQuantity/100);
    }
    /**
     * updates the price.
     * @param newPrice changes the price of stock.
     */
    public void update(double newPrice){
        price = newPrice;
    }
    /**
     * @return the calculated gain
     */
    public double getGain(){
        return quantity*price-9.99-bookValue;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Stock{" + "symbol=" + symbol + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", bookValue=" + bookValue + '}';
    }
    
}
