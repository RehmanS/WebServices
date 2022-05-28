package exception;

public class WebServicesException extends RuntimeException{
    
    Integer code;
    
    public WebServicesException() {
    }
    
    public WebServicesException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    
    public Integer getCode(){
        return code;
    }
}
