package L01InterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        String commandLine;
        while (!"End".equals(commandLine = reader.readLine())) {
            String[] commands = commandLine.split("\\s+");

            switch (commands[0]) {
                case "Create":
                    createAccount(accounts);
                    break;
                case "Deposit":
                    depositInAccount(accounts, commands);
                    break;
                case "SetInterest":
                    setInterestRate(commands);
                    break;
                case "GetInterest":
                    getInterestRate(accounts,commands);
                    break;
            }

        }
    }

    private static void getInterestRate(HashMap<Integer, BankAccount> accounts, String[] commands) {
        int id = Integer.valueOf(commands[1]);
        int years = Integer.valueOf(commands[2]);

        if(accounts.containsKey(id)){
            BankAccount account = accounts.get(id);
            double result =  account.getInterest(years);
            System.out.printf("%.2f%n", result);
        }
        else{
            System.out.println("Account does not exist");
        }
    }

    private static void depositInAccount(HashMap<Integer, BankAccount> accounts, String[] commands) {
        int commandId = Integer.valueOf(commands[1]);
        double amount = Double.valueOf(commands[2]);

        if (accounts.containsKey(commandId)) {
            try {
                BankAccount account = accounts.get(commandId);
                account.deposit(amount);

                System.out.printf("Deposited %.0f to %s%n",amount, account);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account %s created%n", account);
    }

    private static void setInterestRate(String[] commands) {
        Double interest = Double.parseDouble(commands[1]);
        BankAccount.setInterestRate(interest);
    }
}
