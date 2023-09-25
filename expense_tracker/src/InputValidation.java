import java.util.Arrays;

/**
 * This class is the validation class for the inputs in the expense tracker application
 */
public class InputValidation {
    /**
     * This is the minimum valid amount
     */
    final int MIN_AMT = 0;
    /**
     * This is the maximum valid amount
     */
    final int MAX_AMT = 1000;

    /**
     * This enum contains the valid categories
     */
    enum ValidCategory {
        FOOD,
        TRAVEL,
        BILLS,
        ENTERTAINMENT,
        OTHER
    }

    /**
     * This method checks of the amount is in the valid range
     * @param amt amount that is to be checked
     * @return boolean stating if the amount is valid
     */
    boolean isAmountValueValid(double amt) {
        return amt > MIN_AMT && amt < MAX_AMT;
        // NOTE: The requirements were "The amount should be greater than 0 and less than 1000"
    }

    /**
     * This method checks if the category entered is valid
     * @param category category to be checked
     * @return boolean stating if the category is valid
     */
    boolean isCategoryValid(String category) {
        return Arrays.stream(ValidCategory.values()).anyMatch((t) -> t.name().equals(category.toUpperCase()));
    }
}
