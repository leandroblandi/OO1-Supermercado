package modelos;

public class Producto {
	private int id;
	private String producto;
	private float precio;

	public Producto(int id, String producto, float precio) {
		this.setId(id);
		this.setProducto(producto);
		this.setPrecio(precio);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0)
			this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		if (producto.length() > 0)
			this.producto = producto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		if (precio > 0)
			this.precio = precio;
	}

	public boolean equals(Producto producto) {
		return (this.id == producto.getId()) && (this.producto == producto.getProducto());
	}

	@Override
	public String toString() {
		return String.format("Producto(id=%d, producto=%s, precio=%.2f)", id, producto, precio);
	}
}