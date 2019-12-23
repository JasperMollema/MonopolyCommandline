package jmol.jasper.UserInterface.Logic;

public class ExpressionProvider {
    private static ExpressionProvider instance;

    private ExpressionProvider() {}

    public static ExpressionProvider getInstance() {
        if (instance == null) {
            return new ExpressionProvider();
        }
        return instance;
    }

    public boolean getBoolean(String message, UserInputReader userInputReader) {
        System.out.println(message);
        Boolean userResponse = userInputReader.getBoolean();
        while (!ExpressionValidator.getInstance().isValidBoolean(userResponse)) {
            System.out.println("Voer ja, j, yes, y voor ja en nee, no, n voor nee");
            userResponse = userInputReader.getBoolean();
        }
        return userResponse;
    }
}
