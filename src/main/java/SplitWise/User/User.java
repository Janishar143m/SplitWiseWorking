package SplitWise.User;

import SplitWise.UserBalanceSheet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User
{
   int userId;
   String name;
   long mobileNumber;
   UserBalanceSheet userBalanceSheet;

}
