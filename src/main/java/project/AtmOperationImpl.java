package project;

 


 

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AtmOperationImpl implements AtmOperationInterf {
    private Atm atm = new Atm();
    private Map<Double, String> ministmt = new HashMap<>();

    @Override
    public double viewBalance() {
        return atm.getBalance();
    }

    @Override
    public String withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                atm.setBalance(atm.getBalance() - withdrawAmount);
                ministmt.put(withdrawAmount, "Amount Withdrawn");
                return "Success! Collect the cash: " + withdrawAmount;
            } else {
                return "Insufficient Balance!";
            }
        } else {
            return "Please enter the amount in multiples of 500.";
        }
    }

    @Override
    public String depositAmount(double depositAmount) {
        atm.setBalance(atm.getBalance() + depositAmount);
        ministmt.put(depositAmount, "Amount Deposited");
        return "Deposit Successful! Amount: " + depositAmount;
    }

    @Override
    public String viewMiniStatement() {
        StringBuilder statement = new StringBuilder();
        Set<Double> set = ministmt.keySet();
        for (Double d : set) {
            statement.append(d).append(" - ").append(ministmt.get(d)).append("<br>");
        }
        return statement.toString();
    }
}
