# CS3230-CheckingSavings

## Given Starter Code
You are given the following starter code:
* `CheckingAccount` class, designed to represent an individual's checking account within a banking institution.
* `SavingsAccount` class, designed to represent an individual's savings account within a banking institution.

## Your Tasks
You need to implement the following items based on the given starter code:

### Complete `CheckingAccount` class
* finish implementing `deposit` method to deposit a certain amount in the checking account.
* finish implementing `withdraw` method to withdraw a certain amount from the checking account. If there is no enough money in the account, display an error message "No Enough Balance!".
* finish implementing `setLimit` method to set a limit for this account, if you try to set a negative limit, it will display a message "Invalid limit!".
* finish implementing `isLimitMet` method to return true if balance is less than the limit, false otherwise.

### Complete `SavingsAccount` class
* finish implementing a constructor that takes three parameters: `name`, `balance`, and `interestRate`;
* finish implementing `calculateMonthlyInterest`, this method should calculate the interest amount for one month based on the current balance, and it returns the interest;
* finish implementing `updateBalanceWithInterest`, this method should update balance based on the monthly interest;
* finish implementing `deposit` method to deposit a certain amount in the checking account.
* finish implementing `withdraw` method to withdraw a certain amount from the checking account. If there is no enough money in the account, display an error message "No Enough Balance!".

## Testing
Unit tests have been written to test your code. While crafting your solution, feel free to run tests at any point to verify the correctness of your code. To execute tests on your local machine, you can either right-click on the `src/test/java` package in the left pane and choose `Run All Tests`, or use the mvn test command from the IntelliJ Maven button on the right vertical bar, or open a command prompt or terminal, navigate to the project folder, and execute the command `mvn test`. You can run tests for a particular program by right-clicking on the corresponding test code and choosing to run the test. As an example, within IntelliJ, you can right-click on the `HelloWorldTest` file under the test directory and then select `Run HelloWorldTest`.

## Submission
Ensure that your source code is committed and pushed to GitHub.com. Additionally, adhere to any instructions provided on Canvas for the submission of any other necessary documents to fulfill the grading requirements. When you're prepared to upload your solution code to GitHub.com, proceed to commit and push your changes. Feel free to stage, commit, and push the code to GitHub as often as necessary. GitHub.com will autonomously execute tests on its platform to validate your code.
