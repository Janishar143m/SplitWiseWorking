package SplitWise;

import SplitWise.Expense.ExpenseController;
import SplitWise.Expense.ExpenseSplitType;
import SplitWise.Group.Group;
import SplitWise.Group.GroupController;
import SplitWise.User.User;
import SplitWise.User.UserController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SplitWise {

    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public SplitWise()
    {
        userController=new UserController();
        groupController=new GroupController();
        balanceSheetController=new BalanceSheetController();
    }



    public static void main(String[] args) {
        SplitWise splitWise=new SplitWise();
        splitWise.createUser();
        splitWise.createGroup();
        splitWise.createExpense();


    }

    private void createExpense() {

        Group group1= groupController.getGroup(1);
        Split split1=new Split(userController.getUser(1),40,1200);
        Split split2=new Split(userController.getUser(2),30, 900);
        Split split3=new Split(userController.getUser(3),30,900);
        group1.getExpenseController().createExpense(1,"Party",3000, Arrays.asList(split1,split2,split3), ExpenseSplitType.PERCENTAGE, userController.getUser(1));
        group1.getExpenseController().createExpense(2,"Lunch",3000, Arrays.asList(split1,split2,split3), ExpenseSplitType.PERCENTAGE, userController.getUser(2));
        group1.showAllBalances();


    }

    private void createGroup() {
        Group group1=new Group();
        group1.setId(1);
        groupController.addGroup(group1);
        groupController.addUser(userController.getUser(1),group1);
        groupController.addUser(userController.getUser(2),group1);
        groupController.addUser(userController.getUser(3),group1);
    }

    private void createUser() {

        User user1=new User(1,"Jan",9123077508l,new UserBalanceSheet());
        User user2=new User(2,"Tan",8981739330l,new UserBalanceSheet());
        User user3=new User(3,"Ran",8981345012l,new UserBalanceSheet());
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
    }

}
