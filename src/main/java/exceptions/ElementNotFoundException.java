package exceptions;

public class ElementNotFoundException extends RuntimeException{

    static final long serialVersionUID = -8034897190745766939L;

    public ElementNotFoundException (String message) {
        super (message);
    }

}
