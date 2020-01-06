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

    public boolean isValidString(String string) {
        return string != null;
    }

    public boolean isValidStringWithBoundaries(String string, Integer lowerBound, Integer upperBound) {
        if (!isValidString(string)) {
            return false;
        }

        int stringLength = string.length();

        if (lowerBound == null && upperBound == null) {
            return true;
        }

        if (lowerBound == null) {
            return stringLength <= upperBound;
        }

        if (upperBound == null) {
            return stringLength >= lowerBound;
        }

        return stringLength <= upperBound && stringLength >= lowerBound;
    }
}
