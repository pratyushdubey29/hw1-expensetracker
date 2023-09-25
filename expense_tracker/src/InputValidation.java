import java.util.Arrays;

public class InputValidation {
    final int MIN_AMT = 0;
    final int MAX_AMT = 1000;
    enum ValidCategory {
        FOOD,
        TRAVEL,
        BILLS,
        ENTERTAINMENT,
        OTHER
    }
    boolean isAmountValueValid(double amt) {
        return amt >= MIN_AMT && amt <= MAX_AMT;
    }

    boolean isCategoryValid(String category) {
        return Arrays.stream(ValidCategory.values()).anyMatch((t) -> t.name().equals(category.toUpperCase()));
    }
}
