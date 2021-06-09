/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
* Test.
* 
*  
* @author Gurtej Dhami
* @version 2.0
*/
import javax.swing.JTextArea;
public class test {
    public static void main(String[] args){
        Portfolio p = new Portfolio();
        p.read("file.txt");
        p.search("", "", "-",new JTextArea());
        p.search("", "", "-", new JTextArea());
        p.write("file.txt");
    }
}
