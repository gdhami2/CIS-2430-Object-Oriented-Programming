Name:Gurtej Dhami
ID: 0969863

*************************
General Problem: Create a portfolio that contains different kinds of investments for a stock or a mutual fund. It should also allows you to buy and/or sell investments, search for investments,
		 update prices,search for investments, and compute total gain of the portfolio. The program uses a hash map to optimize the search function,
                 and all data is written into a text file to be read later. With the implementation of a GUI every event that is triggered performs the 
                 respected operation. 
		 
*************************
Assumptions/Limitations: -The program only works for class types of stock or mutual fund.
                         -The program has been modified to include a super class called investment.
                         -Both stock and mutual fund inherit from the investment class. 
			 -The update panel does not meet the required function.
*************************
How to build and run: -compile with javac. 
		      -run with java.
                      -main is located in the Assignment3 class.
*************************
How is it tested: -Test file is called test.java
                  -Tests stock and mutual fund by adding, selling, searching etc... 
                  -If a quantity greater than the investments quantity is entered, then the program does not sell the investment.
		  -When a symbol that already exists is entered then the program will not add the investment to the list, this can be tested
		   by adding a stock in the interface and then trying to add a mutual fund with the same symbol. 
*************************
Possible Improvements: Given more time more functions could have been used in the main to clean it up and a present more professional style of code.
*************************