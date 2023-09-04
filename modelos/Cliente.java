package modelos;

public class Cliente {
	private int id;
	private String cliente;
	private long dni;
	private String direccion;

	public Cliente(int id, String cliente, long dni, String direccion) {
		this.setId(id);
		this.setCliente(cliente);
		this.setDni(dni);
		this.setDireccion(direccion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0)
			this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		if (cliente.length() > 0)
			this.cliente = cliente;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		if ((dni >= 1000000) && (dni <= 100000000))
			this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion.length() > 0)
			this.direccion = direccion;
	}

	@Override
	public String toString() {
		return String.format("Cliente(id=%d, cliente=%s, dni=%d, direccion=%s)", id, cliente, dni, direccion);
	}

	public boolean equals(Cliente cliente) {
		return (this.getId() == cliente.getId()) && (this.getDni() == cliente.getDni());
	}
}
