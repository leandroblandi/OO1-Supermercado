package adm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelos.Carrito;
import modelos.Cliente;

public class AdmCarrito {

	private List<Carrito> carritos;

	public AdmCarrito() {
		this.carritos = new ArrayList<Carrito>();
	}

	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {

		if (!existeCarrito(cliente)) {

			int id = generarAutoIncremental();
			Carrito carritoObj = new Carrito(id, cliente, fecha, hora);

			if (this.carritos.add(carritoObj))
				return true;

		}
		throw new Exception(String.format("El carrito con Cliente %s ya existe", cliente));
	}

	public Carrito traerCarrito(int id) {

		boolean carritoEncontrado = false;
		Carrito carritoBuscado = null;

		if (!this.carritos.isEmpty()) {
			int i = 0;
			while ((i < this.carritos.size()) && (!carritoEncontrado)) {
				if (this.carritos.get(i).getId() == id) {
					carritoEncontrado = true;
					carritoBuscado = this.carritos.get(i);
				}
				i++;
			}
			if (carritoEncontrado)
				return carritoBuscado;
		}
		return null;
	}

	public boolean eliminarCarrito(int id) throws Exception {

		Carrito carritoBuscado = traerCarrito(id);

		if ((carritoBuscado != null) && (this.carritos.remove(carritoBuscado))) {
			return true;
		}
		throw new Exception(String.format("El carrito con id %d no existe", id));
	}

	private boolean existeCarrito(Cliente cliente) {
		boolean carritoEncontrado = false;
		if (!carritos.isEmpty()) {
			int i = 0;
			while ((i < this.carritos.size()) && (!carritoEncontrado)) {
				if (carritos.get(i).getCliente().equals(cliente)) {
					carritoEncontrado = true;
				}
				i++;
			}
			return carritoEncontrado;
		}
		return false;
	}

	private int generarAutoIncremental() {
		if (this.carritos.isEmpty())
			return 1;
		return this.carritos.get(carritos.size() - 1).getId() + 1;
	}

}
