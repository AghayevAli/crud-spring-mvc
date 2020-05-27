package az.com.course.util.responseBody;

public enum ResponseBodyCodeAndMessage {
    SUCCESS(200),
    SUCCESS_MESSAGE("SUCCESS");

    private int code;
    private String message;

    ResponseBodyCodeAndMessage(int i) {
        this.code = i;
    }

    ResponseBodyCodeAndMessage(String success) {
        this.message = success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
