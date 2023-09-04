package adm;

import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;

public class AdmCliente {

	private List<Cliente> clientes;

	public AdmCliente() {
		this.clientes = new ArrayList<Cliente>();
	}

	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {

		if (!existeCliente(dni)) {

			int id = generarAutoIncremental();
			Cliente clienteObj = new Cliente(id, cliente, dni, direccion);

			if (this.clientes.add(clienteObj))
				return true;

		}
		throw new Exception(String.format("El cliente con DNI %d ya existe", dni));

	}

	private boolean existeCliente(long dni) {
		boolean clienteEcontrado = false;
		if (!clientes.isEmpty()) {
			int i = 0;
			while ((i < this.clientes.size()) && (!clienteEcontrado)) {
				if (clientes.get(i).getDni() == dni) {
					clienteEcontrado = true;
				}
				i++;
			}
			return clienteEcontrado;
		}
		return false;
	}

	public Cliente traerCliente(int id) {

		boolean clienteEcontrado = false;
		Cliente clienteBuscado = null;

		if (!this.clientes.isEmpty()) {
			int i = 0;
			while ((i < this.clientes.size()) && (!clienteEcontrado)) {
				if (this.clientes.get(i).getId() == id) {
					clienteEcontrado = true;
					clienteBuscado = this.clientes.get(i);
				}
				i++;
			}
			if (clienteEcontrado)
				return clienteBuscado;
		}
		return null;
	}

	// a implementar: verificar si el cliente tiene un carrito
	public boolean eliminarCliente(int id) throws Exception {

		Cliente clienteBuscado = traerCliente(id);

		if ((clienteBuscado != null) && (this.clientes.remove(clienteBuscado))) {
			return true;
		}
		throw new Exception(String.format("El cliente con id %d no existe", id));
	}

	public int generarAutoIncremental() {
		if (this.clientes.isEmpty())
			return 1;
		return this.clientes.get(clientes.size() - 1).getId() + 1;
	}
}
