import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner s = new Scanner(System.in);

        // Number of companies
        int n = s.nextInt();

        int[] companies = new int[n];

        // Add Income to each company
        for (int i = 0; i < companies.length; i++) {
            companies[i] = s.nextInt();
        }

        double[] taxes = new double[n];
        // Add taxes for each company
        for (int i = 0; i < companies.length; i++) {
            taxes[i] = companies[i] * (s.nextInt() / 100.0);
        }


        double largestTax = 0;
        int companyIdex = 0;
        for (int i = 0; i < taxes.length; i++) {
            if (taxes[i] > largestTax) {
                largestTax = taxes[i];
                companyIdex = i;
            }
        }

        System.out.println(companyIdex + 1);
    }
}


/*
Input:
Line one is n = companies
Line two is yearly income of each company
Line three is individual taxes for each company in percent of the companies income. (0-100
inclusive)

Output:
Output the number of the company that pays the most taxes.
Enumeration of companies start with number 1.
If several companies have the same payment size, output the company with the lowest
All input and output values are integers but use doubles for intermediated values for accuracy
 */