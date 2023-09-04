package modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> items;
	private Cliente cliente;

	public Carrito(int id, Cliente cliente, LocalDate fecha, LocalTime hora) {
		this.setId(id);
		this.setCliente(cliente);
		this.setFecha(fecha);
		this.setHora(hora);
		this.items = new ArrayList<ItemCarrito>();
	}

	public boolean agregarItem(Producto producto, int cantidad) {

		if (!existeItem(producto)) {
			int id = generarAutoIncremental();
			ItemCarrito itemCarritoObj = new ItemCarrito(id, producto, cantidad);

			if (this.items.add(itemCarritoObj))
				return true;
		}
		ItemCarrito itemExistente = traerItem(producto);
		int itemPos = items.indexOf(itemExistente);
		itemExistente.setCantidad(itemExistente.getCantidad() + cantidad);
		return items.add(items.set(itemPos, itemExistente));
	}

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		ItemCarrito itemBuscado = traerItem(producto);
		if (itemBuscado != null) {
			if (itemBuscado.getCantidad() > cantidad) {
				int posItem = items.indexOf(itemBuscado);
				int cantidadResultante = itemBuscado.getCantidad() - cantidad;
				itemBuscado.setCantidad(cantidadResultante);
				items.set(posItem, itemBuscado);
				return true;

			} else if (itemBuscado.getCantidad() == cantidad) {
				items.remove(itemBuscado);
				return true;
			}
			throw new Exception(
					String.format("No se puede restar mas de lo que hay en el carrito (cantidad=%d, a restar=%d)",
							itemBuscado.getCantidad(), cantidad));
		}
		throw new Exception(String.format("El item con id %d no existe", id));
	}

	public ItemCarrito traerItem(int id) {

		boolean itemEncontrado = false;
		ItemCarrito itemBuscado = null;

		if (!this.items.isEmpty()) {
			int i = 0;
			while ((i < this.items.size()) && (!itemEncontrado)) {
				if (this.items.get(i).getId() == id) {
					itemEncontrado = true;
					itemBuscado = this.items.get(i);
				}
				i++;
			}
			if (itemEncontrado)
				return itemBuscado;
		}
		return null;
	}

	public ItemCarrito traerItem(Producto producto) {

		boolean itemEncontrado = false;
		ItemCarrito itemBuscado = null;

		if (!this.items.isEmpty()) {
			int i = 0;
			while ((i < this.items.size()) && (!itemEncontrado)) {
				if (this.items.get(i).getProducto().equals(producto)) {
					itemEncontrado = true;
					itemBuscado = this.items.get(i);
				}
				i++;
			}
			if (itemEncontrado)
				return itemBuscado;
		}
		return null;
	}

	private boolean existeItem(Producto producto) {
		boolean itemEncontrado = false;
		if (!items.isEmpty()) {
			int i = 0;
			while ((i < this.items.size()) && (!itemEncontrado)) {
				if (items.get(i).getProducto().equals(producto)) {
					itemEncontrado = true;
				}
				i++;
			}
			return itemEncontrado;
		}
		return false;
	}

	private int generarAutoIncremental() {
		if (this.items.isEmpty())
			return 1;
		return this.items.get(items.size() - 1).getId() + 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0)
			this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		if (hora != null)
			this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		if (hora != null)
			this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return String.format("Carrito(id=%d, fecha=%s, hora=%s, cliente=%s, items=%s)", id, fecha, hora, cliente,
				items);
	}
}
