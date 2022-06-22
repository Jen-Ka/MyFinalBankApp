package app.model.bankproduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditService {

    private static List<Credit> credits = new ArrayList<>();

    public static Credit getById(String userId) {

        Credit result = new Credit();
        result.setClientId("-1");

        for (Credit credit : credits) {
            if (credit.getClientId().equals(userId)) {
                result = credit;
            }
        }
        return result;
    }

    public boolean add(Credit credites) {

        for (Credit credit : credits) {
            if (credit.getProductNumber() == credites.getProductNumber() && credit.getClientId().equals(credites.getClientId())) {
                return false;
            }
        }
        return credits.add(credites);
    }

    public boolean creditIsExist( String userId) {

        boolean result = false;

        for (Credit credit : credits) {
            if (credit.getClientId().equals(userId)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
