package model.exceptions;

public class DomainException extends Exception {//cria uma nova exceção
    private static final long serialVersionUID = 1L;//quando o tipo é serializable é preciso ter uma versão, o 1 é uma versão padrao

    public DomainException (String msg){
        super(msg);
    }

}
