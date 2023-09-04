package excepciones;


@SuppressWarnings("serial")
public class ProductoExistenteException extends Exception {
	public ProductoExistenteException(int id) {
		super(String.format("El producto con id %d ya existe en gondola", id));
	}
}
