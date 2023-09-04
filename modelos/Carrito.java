package modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


public class Carrito {

	private int id;
	private LocalDate fecha;
	private LocalDateTime hora;
	private List<ItemCarrito> items;
	private Cliente cliente;
	
	public Carrito(int id, Cliente cliente) {
		this.setId(id);
		this.setCliente(cliente);
		this.setFecha(LocalDate.now());
		this.setHora(LocalDateTime.now());
		this.items = new ArrayList<ItemCarrito>();
	}

	public ItemCarrito traerItem(Producto producto) {
		for (ItemCarrito itemCarrito : items) {
			if(producto.equals(itemCarrito.getProducto())) {
				return itemCarrito;
			}
		}
		return null;
	}
	
	public boolean agregarItem(Producto producto, int cantidad) {
		if((producto != null) && (cantidad >= 1)) {
			ItemCarrito item = new ItemCarrito(producto.getId(), producto, cantidad);
			int posicionItem = existeItem(item);
			
			// Si el item existe
			if(posicionItem != -1) {
				// Obtenemos la cantidad previa, sumamos las cantidades
				// y luego insertamos
				int cantidadPrevia = items.get(posicionItem).getCantidad();
				item.setCantidad(item.getCantidad() + cantidadPrevia);;
				items.set(posicionItem, item);	
			} else {
				return items.add( new ItemCarrito(producto.getId(), producto, cantidad) );
			}	
		}
		return false;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad) {
		if((producto != null) && (cantidad >= 1 )) {
			
			ItemCarrito itemCarritoBuscado = traerItem(producto);
			
			if(itemCarritoBuscado.getCantidad() > cantidad) {
				int cantidadResultante = itemCarritoBuscado.getCantidad() - cantidad;
				itemCarritoBuscado.setCantidad(cantidadResultante);
				return true;
				
			} else if(itemCarritoBuscado.getCantidad() == cantidad) {
				items.remove(itemCarritoBuscado);
				return true;
				
			} else {
				throw new IllegalArgumentException("La cantidad debe ser menor o igual que la cantidad actual del item");
			}
		}
		return false;
	}
	
	public float calcularTotal() {
		float total = 0.00f;
		for (ItemCarrito itemCarrito : items) {
			total += itemCarrito.calcularSubTotal();
		}
		return total;
	}
	
	/**
	 * @return element position if exists, otherwise, -1
	 */
	public int existeItem(ItemCarrito item) {
		for (ItemCarrito itemCarrito : items) {
			if(itemCarrito == item) return items.indexOf(itemCarrito);
		}
		return -1;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id >= 0) this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
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
		return String.format("Carrito(id=%d, fecha=%s, hora=%s, cliente=%s, items=%s)", id, fecha, hora, cliente, items);
	}
}
