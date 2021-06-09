/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Dhami777
 */
public class test {
    public static void main(String[] args){
        Portfolio p = new Portfolio();
        p.read("file.txt");
        p.search("efdhnjhd", "", "");
        p.search("NB", "National Bank", "");
        p.search("GM", "Gross Mutual", "");
        p.write("file.txt");
    }
}
