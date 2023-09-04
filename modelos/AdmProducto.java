package modelos;

import java.util.ArrayList;
import java.util.List;

public class AdmProducto {

	private List<Producto> productos;

	public AdmProducto() {
		productos = new ArrayList<Producto>();
	}

	private boolean existeProducto(Producto productoBuscado) {
		for (Producto producto : productos) {
			if (producto.equals(productoBuscado))
				return true;
		}
		return false;
	}

	public boolean agregarProducto(Producto producto) {
		if ((producto != null) && !(existeProducto(producto))) {
			this.productos.add(producto);
			return true;
		}
		return false;
	}

	public Producto traerProducto(int id) {
		for (Producto producto : productos) {
			if (producto.getId() == id)
				return producto;
		}
		return null;
	}

	public boolean eliminarProducto(int id) {
		Producto producto = traerProducto(id);

		if (producto != null) {
			productos.remove(producto);
			return true;
		}
		return false;
	}
}
