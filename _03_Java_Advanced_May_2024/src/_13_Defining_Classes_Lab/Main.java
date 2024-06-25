package _13_Defining_Classes_Lab;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equalsIgnoreCase(input)) {

            String[] opeartions = input.split(" ");

            switch (opeartions[0]) {

                case "Create": {
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.println(String.format("Account ID%d created", account.getId()));
                }
                break;

                case "Deposit": {

                    int accountId = Integer.parseInt(opeartions[1]);

                    if (accounts.containsKey(accountId)) {
                        double amount = Double.parseDouble(opeartions[2]);

                        BankAccount account = accounts.get(accountId);
                        account.depositInto(amount);

                        DecimalFormat formatDeposit = new DecimalFormat ("#.#");

                        System.out.println(String.format("Deposited %s to ID%d",formatDeposit.format(amount), account.getId()));
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                break;

                case "SetInterest": {
                    double interestNew = Double.parseDouble(opeartions[1]);
                    BankAccount.setInterestRate(interestNew);
                }
                break;

                case "GetInterest": {
                    int accountId = Integer.parseInt(opeartions[1]);

                    if (accounts.containsKey(accountId)) {
                        int years = Integer.parseInt(opeartions[2]);

                        BankAccount account = accounts.get(accountId);
                        System.out.println(String.format("%.2f", account.getInterest(years)));

                    } else {
                        System.out.println("Account does not exist");
                    }
                }
            }

            input = scanner.nextLine();
        }
    }
}
