package excepciones;

@SuppressWarnings("serial")
public class ProductoInexistenteException extends Exception {
	public ProductoInexistenteException(int id) {
		super(String.format("El producto con id %d no existe", id));
	}
}
