package ua.shop.vitaly.models.product;

/*
 *@author WitalyGaiduchok 
 * Created 8-May-2017
 * */

public class NoSuchProductException extends Exception{
	public NoSuchProductException() {
        super();
    }

    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchProductException(Throwable cause) {
        super(cause);
    }

    protected NoSuchProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
