package modelos;

import java.util.ArrayList;
import java.util.List;

public class AdmCarrito {

	private List<Carrito> carritos;

	public AdmCarrito() {
		this.carritos = new ArrayList<Carrito>();
	}

	public boolean agregarItem(Producto producto, int cantidad) {
		return true;
	}

	public boolean eliminarItem(Producto producto, int cantidad) {
		return true;
	}

	public float calcularSubtotal() {
		return 0F;
	}

	public float calcularTotal() {
		return 0F;
	}

}
