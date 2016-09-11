# Lutz-Prechelt

Lutz Prechelt's language comparison test, Java implementation.


# Order Matcher

Order Matcher is a simulation of mini-trading platform for executing Buy and Sell orders at pre-defined prices. Though the OO design allows accommodating different securities to be traded on the platform, this particular implementation works for one arbitrary security. 

## Prerequisites

Java 8

## Operations

`buy x@y` buys a security for x volume at price y.  
`sell x@y` sells a security of x volume at price y.  
`print` shows active orders in the order book.  
`price` shows the current Bid and Ask price.  
`history` lists trade history.

## Running

The jar file is found `.../target/`. To execute the program from command line  
`java -jar OrderMatcher-1.0.0.jar`

Similarly, orders can be saved in a file and piped into the program as  

`java -jar OrderMatcher-1.0.0.jar < orders.txt`

## Built With

* Maven 4.0.0 
* Eclipse IDE Mars2.Release (4.5.2)

## Authors

[Michael A.](https://se.linkedin.com/in/michaelabebaw)

## NOTES
The following guiding rules are assumed while developing the program
- Positive integers are only allowed for volume and price as it is described in the case study.
- Since there is no security concept described in the case study, the program assumes the operations are executed for an arbitrary security. Thus, there is no future included for listing and selecting securities. Yet, the OO design makes it very easy to include the concept.
- In the case study description, Trade is described to print price and volume respectively as`TRADE price@volume`. However in the example given to demonstrate, the values are displayed in the reverse order, i.e. `TRADE volume@price`. But I used the latter format since the ordering is used in Buy and Sell operations. 
