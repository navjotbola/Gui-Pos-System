Navjot Bola (008763404)

RUNNING THE PROGRAM
Using the terminal/ command line, make the call “java -jar McPatterns.jar input file”. From here, there are two ways add the input file. You can either put the text file in the same directory as the jar file, and simply type in the name of the file as a parameter. For example, if the directory contains both McPatterns.jar and Orders.txt in the same place, call “java -jar McPatterns.jar Orders.txt”. The next way is by typing into the terminal “java -jar McPatterns.jar “ and simply dragging and dropping the text file into the parameter place.
From here, once the program runs you will have all options to select menu items and create a POS order. When an order is confirmed, the program displays a confirmed message and prints a receipt, as well as system.out to the kitchen.


DESIGN PATTERS USED
For the CS151 Homework 4 Assignment, I used a factory design pattern to implement my code. The reason I implemented my code using such a model is because of all the classes we were required to make for validating different types of credit cards. As per instructions, there is a credit card class that has numerous subclasses (amex, master, etc.). The way of implementing the factory was simple. I first have the standard connection between GUI -> UI -> Model. However, I have the GUI also connected to a CreditCardFactory.java class. This is connected to a superclass of the credit cards, that passes a variable (number) that represents a credit card number. To validate credit cards in my GUI, I simply pass the entered credit card number into the credit card factory and let it validate the various types of credit cards.By implementing a factory design pattern, I was able to minimize the amount of code in each class and keep everything condensed, which is a major pro to using it. The cons, however, is that there are a large amount of classes and objects that are loosely coupled together.

