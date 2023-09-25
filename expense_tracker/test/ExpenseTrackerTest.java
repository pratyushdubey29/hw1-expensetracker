import org.junit.Before;
import org.junit.Test;

import javax.swing.table.DefaultTableModel;

import static org.junit.Assert.assertEquals;

/**
 * This is the test class for testing the working of Transaction object creation
 * and can be extended to test other functioning of ExpenseTrackerView and ExpenseTrackerApp
 * if needed.
 */
public class ExpenseTrackerTest {
    /**
     * Test ExpenseTrackerView object
     */
    private ExpenseTrackerView view;
    /**
     * Test ExpenseTrackerApp object
     */
    private ExpenseTrackerApp app;

    /**
     * This method sets up the initial table model, view and the app object
     */
    @Before
    public void setup() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Serial");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Category");
        tableModel.addColumn("Date");
        view = new ExpenseTrackerView(tableModel);
        app = new ExpenseTrackerApp();
    }

    /**
     * This method tests the proper creation of a Transaction object
     * when given a category and an amount
     */
    @Test
    public void testAddTransaction() {
        // Create a new transaction
        double amount = 100.0;
        String category = "Food";
        Transaction transaction = new Transaction(amount, category);

        // Add the transaction to the view
        view.addTransaction(transaction);

        // Get the transactions from the view
        java.util.List<Transaction> transactions = view.getTransactions();

        // Verify that the transaction was added
        assertEquals(1, transactions.size());
        assertEquals(amount, transactions.get(0).getAmount(), 0.001);
        assertEquals(category, transactions.get(0).getCategory());
    }
}