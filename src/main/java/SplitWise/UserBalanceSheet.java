package SplitWise;

import SplitWise.User.User;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserBalanceSheet {

    Map<User,Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserBalanceSheet()
    {
        userVsBalance=new HashMap<>();
    }


}
