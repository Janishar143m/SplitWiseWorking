package SplitWise;

import SplitWise.User.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BalanceSheetController {

    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount)
    {
        UserBalanceSheet paidByUserBalanceSheet=expensePaidBy.getUserBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalPayment()+totalExpenseAmount);

        for(Split split:splits)
        {
            User userOwe=split.getUser();
            UserBalanceSheet userOweBalanceSheet=userOwe.getUserBalanceSheet();
            double amountYouOwe=split.getAmount();
            if(userOwe.getUserId()==expensePaidBy.getUserId())
            {
                paidByUserBalanceSheet.setTotalYourExpense(paidByUserBalanceSheet.getTotalYourExpense()+amountYouOwe);
            }
            else
            {
                //Setting amount to get back for user who has paid
                paidByUserBalanceSheet.setTotalYouGetBack(paidByUserBalanceSheet.getTotalYouGetBack()+amountYouOwe);
                //Balance  of user who has to pay in paidByUser balance sheet
                Balance userOweBalance=paidByUserBalanceSheet.getUserVsBalance().getOrDefault(userOwe,new Balance());
                //Updating Balance  of user who has to pay
                userOweBalance.setAmountToGetBack(userOweBalance.getAmountToGetBack()+amountYouOwe);
                //Updating Balance  of user who has to pay in paidByUser balance sheet
                paidByUserBalanceSheet.getUserVsBalance().put(userOwe,userOweBalance);
                //Updating total amount to be paid by owed user in his balance sheet
                userOweBalanceSheet.setTotalYouOwe(userOweBalanceSheet.getTotalYouOwe()+amountYouOwe);
                //Updating total expenses by owed user in his balance sheet
                userOweBalanceSheet.setTotalYourExpense(userOweBalanceSheet.getTotalYourExpense()+amountYouOwe);
                //Getting user balalance who has paid amount from User who ows balance sheet
                Balance paidUserBalance=userOweBalanceSheet.getUserVsBalance().getOrDefault(expensePaidBy,new Balance());
                //Updating user balance who has paid amount
                paidUserBalance.setAmountToPay(paidUserBalance.getAmountToPay()+amountYouOwe);
                //Updating user balance who has paid amount in Owed user balance sheet
                userOweBalanceSheet.getUserVsBalance().put(expensePaidBy,paidUserBalance);


            }
        }
    }

    public void dispalyUserBalance(User user)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("Balance sheet of user :"+user.getUserId());
        double totalYourExpense;
        double totalPayment;
        double totalYouOwe;
        double totalYouGetBack;
        System.out.println("Total your expenses: "+user.getUserBalanceSheet().getTotalYourExpense());
        System.out.println("Total your payment: "+user.getUserBalanceSheet().getTotalPayment());
        System.out.println("Total your owe: "+user.getUserBalanceSheet().getTotalYouOwe());
        System.out.println("Total your getback: "+user.getUserBalanceSheet().getTotalYouGetBack());
        Map<User,Balance> userBalanceMap=user.getUserBalanceSheet().getUserVsBalance();
        for(Map.Entry<User,Balance> userBalanceEntry: userBalanceMap.entrySet())
        {
            System.out.println("User id:"+userBalanceEntry.getKey().getUserId()+" you owe:"+userBalanceEntry.getValue().getAmountToPay()+" you get back:"+userBalanceEntry.getValue().getAmountToGetBack());

        }

    }



}
