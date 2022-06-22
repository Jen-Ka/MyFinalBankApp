package app.model.bankproduct;

import app.model.users.User;

import java.util.ArrayList;
import java.util.List;

public class BankAccountService { // перечень банковских счетов клиента: номер счёта, баланс, id клиента

    private static List<BankAccount> accounts = new ArrayList<>();

    public static BankAccount getById(String userId) {

        BankAccount result = new BankAccount();
        result.setClientId("-1");

        for (BankAccount baccs : accounts) {
            if (baccs.getClientId().equals(userId)) {
                result = baccs;
            }
        }
        return result;
    }

   public boolean add(BankAccount baccs) {

        for (BankAccount ba : accounts) {
            if (ba.getProductNumber() == baccs.getProductNumber() && ba.getClientId().equals(baccs.getClientId())) {
                return false;
            }
        }
        return accounts.add(baccs);
    }

    public boolean accIsExist( String userId) {

        boolean result = false;

        for (BankAccount baccs : accounts) {
            if (baccs.getClientId().equals(userId)) {
                result = true;
                break;
            }
        }
        return result;
    }


}
