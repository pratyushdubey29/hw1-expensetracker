

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The Transaction class controls creation and modification of the object
 * that holds the data of a given transaction.
 */
public class Transaction {
  /**
   * The amount of this transaction
   */
  private double amount;
  /**
   * The category of this transaction
   */
  private String category;
  /**
   * The timestamp of this transaction
   */
  private String timestamp;

  /**
   * This is a constructor method of the Transaction class.
   * @param amount the amount of this transaction
   * @param category the category of this transaction
   */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /**
   * This is a getter method for the amount object
   * @return Returns the amount object
   */
  public double getAmount() {
    return amount;
  }

  /**
   * This is a setter method for the amount object
   * @param amount the amount to be set
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * This is a getter method for the category object
   * @return Returns the category object
   */
  public String getCategory() {
    return category;
  }

  /**
   * This is a setter method for the category object
   * @param category the category to be set
   */
  public void setCategory(String category) {
    this.category = category; 
  }

  /**
   * This is a getter method for the timestamp object
   * @return Returns the timestamp object
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * This method generates a new timestamp, formats it in the given format and returns it
   * @return the generated and formatted time string
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}