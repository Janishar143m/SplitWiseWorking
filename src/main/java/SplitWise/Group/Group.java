package SplitWise.Group;

import SplitWise.Expense.Expense;
import SplitWise.Expense.ExpenseController;
import SplitWise.User.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
public class Group {

    int id;
    List<User> user;
    List<Expense> expenses;
    ExpenseController expenseController;

    public Group()
    {
        user=new ArrayList<>();
        expenses=new ArrayList<>();
        expenseController=new ExpenseController();
    }

    public void showAllBalances()
    {
         for(User user1:user)
         {
             expenseController.getBalanceSheetController().dispalyUserBalance(user1);
         }
    }

}
