package response;

public class RespStatus {
    
    private Integer code;
    private String message;
    
    private static final Integer SUCCESS_CODE = 1;
    private static final String SUCCESS_MESSAGE = "Success";
    
    public RespStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespStatus() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public static RespStatus getSuccessMessage(){
        return new RespStatus(SUCCESS_CODE,SUCCESS_MESSAGE);
    }
    
}
