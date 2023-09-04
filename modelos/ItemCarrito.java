package modelos;

public class ItemCarrito {
	private int id;
	private Producto producto;
	private int cantidad;
	
	public ItemCarrito(int id, Producto producto, int cantidad) {
		this.setId(id);
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}

	public float calcularSubTotal() {
		return producto.getPrecio() * cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id >= 0) this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		if(cantidad > 0) this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return String.format("ItemCarrito(id=%d, producto=%s, cantidad=%d)", id, producto, cantidad);
	}
}
