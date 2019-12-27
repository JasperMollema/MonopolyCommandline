package jmol.jasper.UserInterface.Logic;

public class ExpressionProvider {
    private static ExpressionProvider instance;
    private UserInputReader userInputReader;
    private String defaultErrorMessage;

    private ExpressionProvider() {
        userInputReader = new UserInputReader();
        defaultErrorMessage = "Dat is geen geldige invoer.";
    }

    public static ExpressionProvider getInstance() {
        if (instance == null) {
            return new ExpressionProvider();
        }
        return instance;
    }

    public Integer getNumberWithinBoundary(String question, int lowerBound, int upperBound, String errorMessage) {
        System.out.println(question);
        Integer number = userInputReader.getIntegerWithBoundary(lowerBound, upperBound);
        boolean isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        while (!isValidInteger) {
            System.out.println(errorMessage);
            System.out.println(question);
            number = userInputReader.getIntegerWithBoundary(lowerBound, upperBound);
            isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        }
        return number;
    }

    /**
     * Gets a number from tbe user.
     * @param question The question.
     * @return the number chosen.
     */
    public Integer getNumber(String question) {
        System.out.println(question);
        Integer number = userInputReader.getInteger();
        boolean isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        while (!isValidInteger) {
            System.out.println(defaultErrorMessage);
            System.out.println(question);
            number = userInputReader.getInteger();
            isValidInteger = ExpressionValidator.getInstance().isValidInteger(number);
        }
        return number;
    }

    /**
     *  Presents an x number of options and let the user choose one.
     * @param options The options from which the user can choose.
     * @return the index of the option chosen.
     */
    public Integer getOption(String[] options, String question) {
        System.out.println(question);
        for (int i=0; i<options.length; i++) {
            int option = i + 1;
            System.out.println("Kies " + option + ": " + options[i]);
        }
        Integer choice = userInputReader.getIntegerWithBoundary(1, options.length);
        boolean isValidChoice = ExpressionValidator.getInstance().isValidInteger(choice);
        while (!isValidChoice) {
            System.out.println(defaultErrorMessage);
            System.out.println(question);
            choice = userInputReader.getIntegerWithBoundary(1, options.length);
            isValidChoice =  ExpressionValidator.getInstance().isValidInteger(choice);
        }
        return choice - 1;
    }

    /**
     * Gets a yes or no answer from the user.
     * @param question The question from which you want a yes or no answer.
     * @return The answer from the user.
     */
    public Boolean getBoolean(String question) {
        System.out.println(question);
        Boolean userResponse = userInputReader.getBoolean();
        while (!ExpressionValidator.getInstance().isValidBoolean(userResponse)) {
            System.out.println(question);
            System.out.println("Voer ja, j, yes, y voor ja en nee, no, n voor nee");
            userResponse = userInputReader.getBoolean();
        }
        return userResponse;
    }
}
