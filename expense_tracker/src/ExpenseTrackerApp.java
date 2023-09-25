import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    InputValidation validator = new InputValidation();

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");


    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {

      StringBuilder exceptionMessageBuilder = new StringBuilder();

      double amount = 0;
      try {
        // Get transaction data from view
        amount = view.getAmountField();
        if(!validator.isAmountValueValid(amount)) {
          exceptionMessageBuilder.append("Please enter amount between 0 and 1000.");
        }
      } catch (NumberFormatException nfe) {
        exceptionMessageBuilder.append("Please enter a numeric amount.");
      }

      String category = view.getCategoryField();
      if(!validator.isCategoryValid(category)) {
        exceptionMessageBuilder.append("Please enter a valid category");
      }

      String exception = exceptionMessageBuilder.toString();

      if(!exception.isEmpty()) {
        view.showException(exception);
        return;
      }

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}