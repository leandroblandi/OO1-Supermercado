package modelos;

import java.util.ArrayList;
import java.util.List;

import excepciones.ProductoExistenteException;
import excepciones.ProductoInexistenteException;

/**
 * @author el3be
 *
 */
public class Supermercado {

	private List<Producto> productos;
	private List<Cliente> clientes;
	private List<Carrito> carritos;

	public Supermercado() {
		this.productos = new ArrayList<Producto>();
		this.clientes = new ArrayList<Cliente>();
		this.carritos = new ArrayList<Carrito>();
	}

	public boolean existeProducto(Producto productoBuscado) {

		for (Producto producto : productos) {
			if (producto.equals(productoBuscado))
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

	/**
	 * @param producto
	 * @return product index if exists, otherwise, returns -1
	 */
	private int traerIndiceProducto(Producto producto) {
		if (producto != null) {
			return productos.indexOf(producto);
		}
		return -1;
	}

	public boolean agregarProducto(Producto producto) throws ProductoExistenteException {
		if (!(existeProducto(producto)) && (producto != null)) {
			productos.add(producto);
			return true;
		}
		throw new ProductoExistenteException(producto.getId());
	}

	public boolean modificarProducto(int id, String producto, double precio) throws ProductoInexistenteException {
		Producto productoBuscado = traerProducto(id);
		if ((productoBuscado != null) && (producto.length() > 0) && (precio > 0.00f)) {

			int indiceProducto = traerIndiceProducto(productoBuscado);
			productoBuscado.setProducto(producto);
			productoBuscado.setPrecio((float) precio);
			productos.set(indiceProducto, productoBuscado);
			return true;
		}
		throw new ProductoInexistenteException(id);
	}

	public boolean eliminarProducto(int id) throws ProductoInexistenteException {
		Producto producto = traerProducto(id);
		if (producto != null) {
			productos.remove(producto);
			return true;
		}
		throw new ProductoInexistenteException(id);
	}
}
