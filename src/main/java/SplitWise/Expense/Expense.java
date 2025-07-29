package SplitWise.Expense;

import SplitWise.Split;
import SplitWise.User.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Expense {

    int expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType expenseSplitType;
    List<Split> splits=new ArrayList<>();
}
