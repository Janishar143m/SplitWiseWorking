package SplitWise.Expense;

import SplitWise.BalanceSheetController;
import SplitWise.Split;
import SplitWise.User.User;
import lombok.Getter;

import java.util.List;
@Getter
public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController()
    {
        balanceSheetController=new BalanceSheetController();

    }

    public Expense createExpense(int expenseId, String desc, double expenseAmount, List<Split> splitDetails, ExpenseSplitType expenseSplitType, User paidByUser)
    {
        Expense expense= Expense.builder().expenseId(expenseId).description(desc).expenseAmount(expenseAmount).splits(splitDetails).paidByUser(paidByUser).build();
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitDetails,expenseAmount);
       // balanceSheetController.dispalyUserBalance(paidByUser);
        return expense;

    }

}
