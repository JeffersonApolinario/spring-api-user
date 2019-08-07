package application.common;

public class CustomErrorMessage {
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    public CustomErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
