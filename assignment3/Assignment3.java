/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
* Assignment3.
* 
*  
* @author Gurtej Dhami
* @version 2.0
*/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Assignment3 extends JFrame {
    JLabel jl = new JLabel();
    JTextField usrChoice = new JTextField(30);
               
    public Assignment3(){
        super("Investment Portfolio");
        Portfolio pflio = new Portfolio();
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        JMenu menu = new JMenu("Command");
        JMenuItem item1 = new JMenuItem("Buy");
        JMenuItem item2 = new JMenuItem("Sell");
        JMenuItem item3 = new JMenuItem("Update");
        JMenuItem item4 = new JMenuItem("Gain");
        JMenuItem item5 = new JMenuItem("Search");
        JMenuItem item6 = new JMenuItem("Quit");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        menu.add(item6);
        JMenuBar jmb = new JMenuBar();
        jmb.add(menu);
        setJMenuBar(jmb);
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        JLabel j1 = new JLabel("Welcome to Investment Portfolio.");
        jp.add(j1, BorderLayout.NORTH);
        JTextArea jtintro = new JTextArea();
        jtintro.setEnabled(false);
        jtintro.setText("\n\n\n\n\n\n\n\n\n\nChoose a command from the “Commands”menu\n to buy or sell an investment, update prices\n for all investments, get gain for the portfolio, search for relevant investments, or quit the program.");
        jp.add(jtintro);
        
        //for buy
        JTextArea jt5 = new JTextArea();
        jt5.setEnabled(false);
        JPanel totBuy = new JPanel();
        JPanel topBuy = new JPanel();
        topBuy.setLayout(new GridLayout(1,2));
        JPanel bottomBuy = new JPanel();
        JPanel leftBuy = new JPanel();
        leftBuy.setLayout(new BorderLayout());
        JPanel rightBuy = new JPanel();
        rightBuy.setLayout(new BorderLayout());
        rightBuy.setLayout(new GridLayout(2,1));
        topBuy.add(leftBuy);
        topBuy.add(rightBuy);
        JPanel buyType = new JPanel();
        buyType.setLayout(new FlowLayout());
        JPanel buySymbol = new JPanel();
        buySymbol.setLayout(new FlowLayout());
        JPanel buyName = new JPanel();
        buyName.setLayout(new FlowLayout());
        JPanel buyQuantity = new JPanel();
        buyQuantity.setLayout(new FlowLayout());
        JPanel buyPrice = new JPanel();
        buyPrice.setLayout(new FlowLayout());
        String[] type = {"Stock", "MutualFund"};
        JComboBox typeBox = new JComboBox(type);
        JLabel buyText = new JLabel("Buying an investment");
        JLabel buyTy = new JLabel("Type");
        JLabel buySym = new JLabel("Symbol");
        JLabel buyNme = new JLabel("Name");
        JLabel buyQnty = new JLabel("Quantity");
        JLabel buyPrc = new JLabel("Price");
        JLabel buyMes = new JLabel("Messages");
        JButton buyReset = new JButton("Reset");
        JButton buyBuy = new JButton("Buy");
        JTextField buySymbolText = new JTextField(20);
        JTextField buyNameText = new JTextField(20);
        JTextField buyQuantityText = new JTextField(20);
        JTextField buyPriceText = new JTextField(20);
        buySymbol.add(buySym);
        buySymbol.add(buySymbolText);
        buyName.add(buyNme);
        buyName.add(buyNameText);
        buyQuantity.add(buyQnty);
        buyQuantity.add(buyQuantityText);
        buyPrice.add(buyPrc);
        buyPrice.add(buyPriceText);
        JPanel leftBuyInput = new JPanel();
        leftBuy.add(buyText, BorderLayout.NORTH);
        leftBuyInput.setLayout(new GridLayout(5, 1));
        buyType.add(buyTy);
        buyType.add(typeBox);
        leftBuyInput.add(buyType);
        leftBuyInput.add(buySymbol);
        leftBuyInput.add(buyName);
        leftBuyInput.add(buyQuantity);
        leftBuyInput.add(buyPrice);
        leftBuy.add(leftBuyInput);
        rightBuy.add(buyReset);
        rightBuy.add(buyBuy);
        bottomBuy.setLayout(new BorderLayout());
        bottomBuy.add(buyMes, BorderLayout.NORTH);
        bottomBuy.add(jt5, BorderLayout.CENTER);
        totBuy.setLayout(new BorderLayout());
        totBuy.add(topBuy, BorderLayout.NORTH);
        totBuy.add(bottomBuy, BorderLayout.CENTER);
        
        
        
        //for update
        JTextArea jta4 = new JTextArea();
        jta4.setEnabled(false);
        JPanel totUpdate = new JPanel();
        JPanel topUpdate = new JPanel();
        topUpdate.setLayout(new GridLayout(1,2));
        JPanel bottomUpdate = new JPanel();
        JPanel leftUpdate = new JPanel();
        leftUpdate.setLayout(new BorderLayout());
        JPanel rightUpdate = new JPanel();
        rightUpdate.setLayout(new GridLayout(3,1));
        topUpdate.add(leftUpdate);
        topUpdate.add(rightUpdate);
        JPanel updateSymbol = new JPanel();
        updateSymbol.setLayout(new FlowLayout());
        JPanel updateName = new JPanel();
        updateName.setLayout(new FlowLayout());
        JPanel updatePrice = new JPanel();
        updatePrice.setLayout(new FlowLayout());
        JLabel updateInv = new JLabel("Updating Investments");
        JLabel updateSym = new JLabel("Symbol");
        JLabel updateN = new JLabel("Name");
        JLabel updateP = new JLabel("Price");
        JLabel updateM = new JLabel("Messages");
        JButton updatePrev = new JButton("Prev");
        JButton updateNext = new JButton("Next");
        JButton updateSell = new JButton("Save");
        JTextField updateSymbolText = new JTextField(20);
        JTextField updateNameText = new JTextField(20);
        JTextField updatePriceText = new JTextField(20);
        updateSymbol.add(updateSym);
        updateSymbol.add(updateSymbolText);
        updateName.add(updateN);
        updateName.add(updateNameText);
        updatePrice.add(updateP);
        updatePrice.add(updatePriceText);
        JPanel leftUpdateInput = new JPanel();
        leftUpdate.add(updateInv, BorderLayout.NORTH);
        leftUpdateInput.setLayout(new GridLayout(4, 1));
        leftUpdateInput.add(updateSymbol);
        leftUpdateInput.add(updateName);
        leftUpdateInput.add(updatePrice);
        leftUpdate.add(leftUpdateInput);
        rightUpdate.add(updatePrev);
        rightUpdate.add(updateNext);
        rightUpdate.add(updateSell);
        bottomUpdate.setLayout(new BorderLayout());
        bottomUpdate.add(updateM,BorderLayout.NORTH);
        bottomUpdate.add(jta4, BorderLayout.CENTER);
        totUpdate.setLayout(new BorderLayout());
        totUpdate.add(topUpdate, BorderLayout.NORTH);
        totUpdate.add(bottomUpdate, BorderLayout.CENTER);
        
        
        //for sell
        JTextArea jta3 = new JTextArea();
        jta3.setEnabled(false);
        JPanel totSell = new JPanel();
        JPanel topSell = new JPanel();
        topSell.setLayout(new GridLayout(1,2));
        JPanel bottomSell = new JPanel();
        JPanel leftSell = new JPanel();
        leftSell.setLayout(new BorderLayout());
        JPanel rightSell = new JPanel();
        rightSell.setLayout(new GridLayout(2,1));
        topSell.add(leftSell);
        topSell.add(rightSell);
        JPanel sellSymbol = new JPanel();
        sellSymbol.setLayout(new FlowLayout());
        JPanel sellQuantity = new JPanel();
        sellQuantity.setLayout(new FlowLayout());
        JPanel sellPrice = new JPanel();
        sellPrice.setLayout(new FlowLayout());
        JLabel sellingInv = new JLabel("Selling an Investment");
        JLabel sellSym = new JLabel("Symbol");
        JLabel sellQ = new JLabel("Quantity");
        JLabel sellP = new JLabel("Price");
        JLabel sellM = new JLabel("Messages");
        JButton sellReset = new JButton("Reset");
        JButton sell = new JButton("Sell");
        JTextField sellSymbolText = new JTextField(20);
        JTextField sellQuantitiesText = new JTextField(20);
        JTextField sellPriceText = new JTextField(20);
        sellSymbol.add(sellSym);
        sellSymbol.add(sellSymbolText);
        sellQuantity.add(sellQ);
        sellQuantity.add(sellQuantitiesText);
        sellPrice.add(sellP);
        sellPrice.add(sellPriceText);
        JPanel leftSellInput = new JPanel();
        leftSell.add(sellingInv, BorderLayout.NORTH);
        leftSellInput.setLayout(new GridLayout(4, 1));
        leftSellInput.add(sellSymbol);
        leftSellInput.add(sellQuantity);
        leftSellInput.add(sellPrice);
        leftSell.add(leftSellInput);
        rightSell.add(sellReset);
        rightSell.add(sell);
        bottomSell.setLayout(new BorderLayout());
        bottomSell.add(sellM,BorderLayout.NORTH);
        bottomSell.add(jta3, BorderLayout.CENTER);
        totSell.setLayout(new BorderLayout());
        totSell.add(topSell, BorderLayout.NORTH);
        totSell.add(bottomSell, BorderLayout.CENTER);
        
        
        //for gain
        JTextArea jta = new JTextArea();
        jta.setEnabled(false);
        JPanel gainArea = new JPanel();
        JPanel gainTop = new JPanel();
        gainTop.setLayout(new BorderLayout());
        JPanel gainBottom = new JPanel();
        JPanel totGain = new JPanel();
        totGain.setLayout(new FlowLayout());
        JLabel jl1 = new JLabel("Getting total gain");
        JLabel jl2 = new JLabel("Total gain");
        JLabel jl3 = new JLabel("Individual  gain");
        JTextField jt1 = new JTextField(20);
        totGain.add(jl2);
        totGain.add(jt1);
        gainTop.add(jl1, BorderLayout.NORTH);
        gainTop.add(totGain, BorderLayout.CENTER);
        gainBottom.setLayout(new BorderLayout());
        gainBottom.add(jl3,BorderLayout.NORTH);
        gainBottom.add(jta, BorderLayout.CENTER);
        gainArea.setLayout(new BorderLayout());
        gainArea.add(gainTop, BorderLayout.NORTH);
        gainArea.add(gainBottom, BorderLayout.CENTER);
        
        
        //for search
        JTextArea jta2 = new JTextArea();
        jta2.setEnabled(false);
        JPanel totSearch = new JPanel();
        JPanel topSearch = new JPanel();
        topSearch.setLayout(new GridLayout(1,2));
        JPanel bottomPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2,1));
        topSearch.add(leftPanel);
        topSearch.add(rightPanel);
        JPanel Symbol = new JPanel();
        Symbol.setLayout(new FlowLayout());
        JPanel nameKeywords = new JPanel();
        nameKeywords.setLayout(new FlowLayout());
        JPanel lowPrice = new JPanel();
        lowPrice.setLayout(new FlowLayout());
        JPanel highPrice = new JPanel();
        highPrice.setLayout(new FlowLayout());
        JLabel si = new JLabel("Searching Investments");
        JLabel sym = new JLabel("Symbol");
        JLabel nk = new JLabel("Name/Keywords");
        JLabel lp = new JLabel("Low price");
        JLabel hp = new JLabel("High Price");
        JLabel sr = new JLabel("Search Results");
        JButton reset = new JButton("Reset");
        JButton search = new JButton("Search");
        JTextField symbolText = new JTextField(20);
        JTextField nameKeywordsText = new JTextField(20);
        JTextField lowPriceText = new JTextField(20);
        JTextField highPriceText = new JTextField(20);
        Symbol.add(sym);
        Symbol.add(symbolText);
        nameKeywords.add(nk);
        nameKeywords.add(nameKeywordsText);
        lowPrice.add(lp);
        lowPrice.add(lowPriceText);
        highPrice.add(hp);
        highPrice.add(highPriceText);
        JPanel leftInput = new JPanel();
        leftPanel.add(si, BorderLayout.NORTH);
        leftInput.setLayout(new GridLayout(4, 1));
        leftInput.add(Symbol);
        leftInput.add(nameKeywords);
        leftInput.add(lowPrice);
        leftInput.add(highPrice);
        leftPanel.add(leftInput);
        rightPanel.add(reset);
        rightPanel.add(search);
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(sr,BorderLayout.NORTH);
        bottomPanel.add(jta2, BorderLayout.CENTER);
        totSearch.setLayout(new BorderLayout());
        totSearch.add(topSearch, BorderLayout.NORTH);
        totSearch.add(bottomPanel, BorderLayout.CENTER);
        
        item1.addActionListener((ActionEvent event) -> {
           totUpdate.setVisible(false);
           totSell.setVisible(false);
           gainArea.setVisible(false);
           totSearch.setVisible(false);
           jp.setVisible(false);
           totBuy.setVisible(true);
        });
        
        item3.addActionListener((ActionEvent event) -> {
           totBuy.setVisible(false);
           totSell.setVisible(false);
           gainArea.setVisible(false);
           totSearch.setVisible(false);
           jp.setVisible(false);
           totUpdate.setVisible(true);
        });
        
        item2.addActionListener((ActionEvent event) -> {
           totBuy.setVisible(false);
           totUpdate.setVisible(false);
           gainArea.setVisible(false);
           totSearch.setVisible(false);
           jp.setVisible(false);
           totSell.setVisible(true);
        });
        
     /**
     * On selection of the gain item the individual and total gain are received from the portfolio 
     * the gain is output 
     */
        item4.addActionListener((ActionEvent event) -> {
           totBuy.setVisible(false);
           totUpdate.setVisible(false);
           totSell.setVisible(false);
           totSearch.setVisible(false);
           jp.setVisible(false);
           gainArea.setVisible(true);
           double gain = pflio.getGain(jta);
           jt1.setText(""+gain);
           jt1.setEnabled(false);
        });
        
        item5.addActionListener((ActionEvent event) -> {
           totBuy.setVisible(false);
           totUpdate.setVisible(false);
           totSell.setVisible(false);
           gainArea.setVisible(false);
           jp.setVisible(false);
           totSearch.setVisible(true);
        });
        
        item6.setMnemonic(KeyEvent.VK_E);
        item6.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        this.add(totBuy);
        this.add(totUpdate);
        this.add(totSell);
        this.add(gainArea);
        this.add(totSearch);
        this.add(jp);
        totBuy.setVisible(false);
        totUpdate.setVisible(false);
        totSell.setVisible(false);
        gainArea.setVisible(false);
        totSearch.setVisible(false);
        jp.setVisible(true);
        
     /**
     * The user provided input is ran through the add method in portfolio
     */
        buyBuy.addActionListener((ActionEvent event) -> {
           String buySymText = buySymbolText.getText();
           if(buySymText.equals("")){
               jt5.setText("Improper Symbol");
               return;
           }
           String buyNmeText = buyNameText.getText();
           
           if(buyNmeText.equals("")){
                jt5.setText("Improper Symbol");
                return;
           }
           
           int buyQntText;
           try{
               buyQntText = Integer.parseInt(buyQuantityText.getText());
           }catch(NumberFormatException e){
               jt5.setText("Improper Quantity");
               return;
           }
           
           double buyPrcText;
           
           try{
                buyPrcText = Double.parseDouble(buyPriceText.getText());
           }catch(NumberFormatException e){
                jt5.setText("Improper Price");
                return;
           }
           
           pflio.add(buySymText, buyNmeText, buyQntText, buyPrcText, typeBox.getSelectedIndex(), jt5);
        });
        
     /**
     * The area for user provided input is cleared
     */
        buyReset.addActionListener((ActionEvent event) -> {
           buySymbolText.setText("");
           buyNameText.setText("");
           buyQuantityText.setText("");
           buyPriceText.setText("");
        });
        
     /**
     * The area for user provided input is cleared
     */
        sellReset.addActionListener((ActionEvent event) -> {
           sellSymbolText.setText("");
           sellQuantitiesText.setText("");
           sellPriceText.setText("");
        });
     /**
     * The user provided input is ran through the sell method in portfolio
     */
        sell.addActionListener((ActionEvent event) -> {
           String sellSymText = sellSymbolText.getText();
           if(sellSymText.equals("")){
               jta3.setText("Improper symbols");
               return;
           }
           
           int sellQntText;
           
           try{
               sellQntText = Integer.parseInt(sellQuantitiesText.getText());
           }catch(NumberFormatException e){
               jta3.setText("Improper quantity");
               return;
           }
           
           double sellPrcText;
           
           try{
               sellPrcText = Double.parseDouble(sellPriceText.getText());
           }catch(NumberFormatException e){
               jta3.setText("Improper price");
               return;
           }
           
           
           pflio.sell(sellSymText, sellPrcText, sellQntText);
           jta3.setText("Your Investment has been sold");
        });
        
     /**
     * The area for user provided input is cleared
     */
        reset.addActionListener((ActionEvent event) -> {
           symbolText.setText("");
           nameKeywordsText.setText("");
           lowPriceText.setText("");
           highPriceText.setText("");
        });
     /**
     * The user provided input is ran through the search method in portfolio
     */
        search.addActionListener((ActionEvent event) -> {
           String searchSymText = symbolText.getText();
           String searchNmeText = nameKeywordsText.getText();
           String searchLowPrcText = lowPriceText.getText();
           String searchHighPrcText = highPriceText.getText();
           pflio.search(searchSymText, searchNmeText, searchLowPrcText+"-"+searchHighPrcText, jta2);
        });
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Assignment3 a3 = new Assignment3();
        a3.setVisible(true);
    }
    
}
