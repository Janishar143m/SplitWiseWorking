package SplitWise;

import SplitWise.User.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Split {

    User user;
    double percentage;
    double amount;

}
