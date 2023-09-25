

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 

/**
 * The ExpenseTrackerView class that stores the tracker table content
 * and controls the table view creation and actions
 */
public class ExpenseTrackerView extends JFrame {

  /**
   * Object to store the transaction table
   */
  private JTable transactionsTable;
  /**
   * Object for the Add Transaction Button
   */
  private JButton addTransactionBtn;
  /**
   * Object for the Amount Field
   */
  private JTextField amountField;
  /**
   * Object for the Category Field
   */
  private JTextField categoryField;
  /**
   * Table model object for this view
   */
  private DefaultTableModel model;
  /**
   * A list of Transaction objects
   */
  private List<Transaction> transactions = new ArrayList<>();


  /**
   * This is a getter method for the transactionsTable object
   * @return transactionsTable
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  /**
   * This is a method to obtain the text field value from the amountField object
   * and cast it to a double datatype.
   * @return amount
   */
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  /**
   * This is the setter method for the amountField object
   * @param amountField Amount to be set
   */
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  /**
   * This is a method to obtain the text field value from the categoryField object
   * @return categoryField.getText()
   */
  public String getCategoryField() {
    return categoryField.getText();
  }

  /**
   * This is the setter method for the categoryField object
   * @param categoryField Category to be set
   */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  /**
   * This is a getter method for the addTransactionBtn object
   * @return addTransactionBtn
   */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  /**
   * This is a getter method for the table model object
   * @return model
   */
  public DefaultTableModel getTableModel() {
    return model;
  }

  /**
   * This is a constructor method of the ExpenseTrackerView class.
   * @param model The table model to initialize the view
   */
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);
  
    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel); 
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);
  
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);
  
    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPanel, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  /**
   * This method takes the updated list of transactions and refreshes/updates the view (in the UI)
   * @param transactions The list of updated transaction
   */
  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  /**
   * This method fetches all the transactions and calls the refreshTable() to update the view
   */
  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  /**
   * This is a getter method for the transactions object
   * @return transactions
   */
  public List<Transaction> getTransactions() {
    return transactions;
  }

  /**
   * This method accepts a new transaction t and updates the table model and the view (in the UI)
   * @param t Transaction to be added
   */
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
  }
  


  // Other view methods
}
