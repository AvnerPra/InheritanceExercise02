package application;

import entities.CompanyTaxPayer;
import entities.IndividualTaxPayer;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            sc.nextLine();
            System.out.println("Tax payer #"+i+" data: ");
            System.out.print("Individual or Company? (i/c): ");
            char ic = sc.next().charAt(0);
            while (ic != 'i' && ic != 'c'){
                sc.nextLine();
                System.out.println("Invalid option!");
                System.out.print("Individual or Company? (i/c): ");
                ic = sc.next().charAt(0);
            }
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Annual Income: ");
            double annualIncome = sc.nextDouble();
            if(ic == 'i'){
                System.out.print("Health Expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayers.add(new IndividualTaxPayer(name, annualIncome, healthExpenditures));
            }
            else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayers.add(new CompanyTaxPayer(name, annualIncome, numberOfEmployees));
            }
        }
        System.out.println();
        double sum = 0;
        System.out.println("TAXES PAYED");
        for(TaxPayer tp: taxPayers){
            System.out.printf(tp.getName()+": $ %.2f%n", tp.tax());
            sum += tp.tax();
        }
        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f%n", sum);


        sc.close();
    }
}
