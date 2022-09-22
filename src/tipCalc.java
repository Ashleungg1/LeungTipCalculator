import java.util.Scanner;
import java.text.DecimalFormat;

public class tipCalc {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        System.out.println("Welcome to the tip calculator!");

        System.out.print("How many people are in your group? ");
        int numOfPeople = scan.nextInt();
        scan.nextLine();

        System.out.print("What's your tip percentage? (0-100): ");
        int tipPercentage = scan.nextInt();
        scan.nextLine();

        // asking for user input on prices
        double cost = 0;
        System.out.print("Enter a cost in dollars and cents, e.g 12.50 (-1 to end): ");
        double userInput = scan.nextDouble();
        scan.nextLine();
        cost += userInput;

        // loop so that it keeps asking until the user inputs -1
        while (userInput>0){
            System.out.print("Enter a cost in dollars and cents, e.g 12.50 (-1 to end): ");
            userInput = scan.nextDouble();
            scan.nextLine();
            cost += userInput;
        }
        // make up for the last -1 that the user inputted that got added to cost
        cost++;

        // declaring variables to be printed and formatting them
        double totalTip = (tipPercentage/100.0)*cost;
        String formattedTotalTip = formatter.format(totalTip);
        double billWithTip = cost + totalTip;
        String formattedBillWithTip = formatter.format(billWithTip);
        double costPerPersonNoTip = cost/numOfPeople;
        String formattedCostPerPersonNoTip = formatter.format(costPerPersonNoTip);
        double tipPerPerson = totalTip/numOfPeople;
        String formattedTipPerPerson = formatter.format(tipPerPerson);
        double costPerPerson = costPerPersonNoTip + tipPerPerson;
        String formattedCostPerPerson = formatter.format(costPerPerson);

        // printing
        System.out.println("-----------------------");
        System.out.println("Total Bill Before Tip: " + cost);
        System.out.println("Tip Percentage: " + tipPercentage);
        System.out.println("Total Tip: " + formattedTotalTip);
        System.out.println("Total Bill With Tip: " + formattedBillWithTip);
        System.out.println("Per Person Cost Before Tip: " + formattedCostPerPersonNoTip);
        System.out.println("Tip Per Person: " + formattedTipPerPerson);
        System.out.println("Total Cost Per Person: " + formattedCostPerPerson);

        scan.close();
    }
}
