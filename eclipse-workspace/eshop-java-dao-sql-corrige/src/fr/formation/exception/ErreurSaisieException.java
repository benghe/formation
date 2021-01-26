package fr.formation.exception;

//Exception = on veut forcer la gestion de cette exception (try ... catch - obligatoire)
//RuntimeException = on veut pas forcer la gestion de cette exception

//public class ErreurSaisieException extends Exception {
public class ErreurSaisieException extends RuntimeException {
	private static final long serialVersionUID = -4970056313632803040L;
}