package L01DefiningClasses.L01BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] arguments = line.split("\\s+");

            String command = arguments[0];

            switch (command) {
                case "Create":
                    createBankAccount(bankAccounts, arguments);
                    break;
                case "Deposit":
                    depositInBankAccount(bankAccounts, arguments);
                    break;
                case "Withdraw":
                    withdrawFromBankAccount(bankAccounts, arguments);
                    break;
                case "Print":
                    printBankAccount(bankAccounts, arguments);
                    break;
            }
        }
    }

    private static void printBankAccount(HashMap<Integer, BankAccount> bankAccounts, String[] arguments) {
        Integer bankAccountId = Integer.valueOf(arguments[1]);
        if(!bankAccounts.containsKey(bankAccountId)){
            System.out.println("Account does not exist");
            return;
        }

        BankAccount account = bankAccounts.get(bankAccountId);
        System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
    }

    private static void withdrawFromBankAccount(HashMap<Integer, BankAccount> map, String[] arguments) {
        Integer bankAccountId = Integer.valueOf(arguments[1]);
        Double moneyToWithDraw = Double.parseDouble(arguments[2]);

        if(!map.containsKey(bankAccountId)){
            System.out.println("Account does not exist");
            return;
        }

        try{
            map.get(bankAccountId).withdraw(moneyToWithDraw);
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    private static void depositInBankAccount(HashMap<Integer, BankAccount> map, String[] arguments) {
        Integer bankAccountId = Integer.valueOf(arguments[1]);
        Double moneyToDeposit = Double.parseDouble(arguments[2]);

        if(!map.containsKey(bankAccountId)){
            System.out.println("Account does not exist");
            return;
        }

        try{
            map.get(bankAccountId).deposit(moneyToDeposit);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    private static void createBankAccount(HashMap<Integer, BankAccount> map, String[] arguments) {
        int bankAccountId = Integer.valueOf(arguments[1]);

        if (!map.containsKey(bankAccountId)) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(bankAccountId);
            map.put(bankAccountId, bankAccount);
            return;
        }
        System.out.println("Account already exists");
    }
}
