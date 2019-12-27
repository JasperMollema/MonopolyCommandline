package jmol.jasper.UserInterface.Logic;

public class ExpressionValidator {
    private static ExpressionValidator instance;

    private ExpressionValidator() {
    }

    public static ExpressionValidator getInstance() {
        if (instance == null) {
            return new ExpressionValidator();
        }
        return instance;
    }

    public boolean isValidBoolean(Boolean booleanToBeChecked) {
        return booleanToBeChecked != null;
    }

    public boolean isValidInteger(Integer integer) {
        return integer != null;
    }

    public boolean isStringWithinLength(String string, int lowerBound, int upperBound) {
        return string != null && string.length() >= lowerBound && string.length() <= upperBound;
    }
}
