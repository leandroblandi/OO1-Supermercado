package adm;

import java.util.ArrayList;
import java.util.List;

import modelos.Producto;

public class AdmProducto {

	private List<Producto> productos;

	public AdmProducto() {
		this.productos = new ArrayList<Producto>();
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {

		if (!existeProducto(producto)) {

			int id = generarAutoIncremental();
			Producto productoObj = new Producto(id, producto, precio);

			if (this.productos.add(productoObj))
				return true;
		}
		throw new Exception(String.format("El producto con nombre %s ya existe", producto));

	}

	public Producto traerProducto(int id) {

		boolean productoEncontrado = false;
		Producto productoBuscado = null;

		if (!this.productos.isEmpty()) {
			int i = 0;
			while ((i < this.productos.size()) && (!productoEncontrado)) {
				if (this.productos.get(i).getId() == id) {
					productoEncontrado = true;
					productoBuscado = this.productos.get(i);
				}
				i++;
			}
			if (productoEncontrado)
				return productoBuscado;
		}
		return null;
	}

	public boolean eliminarProducto(int id) throws Exception {

		Producto productoBuscado = traerProducto(id);

		if ((productoBuscado != null) && (this.productos.remove(productoBuscado))) {
			return true;
		}
		throw new Exception(String.format("El producto con id %d no existe", id));
	}

	private boolean existeProducto(String producto) {
		boolean productoEncontrado = false;
		if (!productos.isEmpty()) {
			int i = 0;
			while ((i < this.productos.size()) && (!productoEncontrado)) {
				if (productos.get(i).getProducto().equalsIgnoreCase(producto)) {
					productoEncontrado = true;
				}
				i++;
			}
			return productoEncontrado;
		}
		return false;
	}

	public int generarAutoIncremental() {
		if (this.productos.isEmpty())
			return 1;
		return this.productos.get(productos.size() - 1).getId() + 1;
	}

}
