package tests;

import java.time.LocalDate;
import java.time.LocalTime;

import modelos.Carrito;
import modelos.Cliente;
import modelos.Producto;

public class TestItemCarrito {

	public static void main(String[] args) {

		Carrito carrito = new Carrito(1, new Cliente(1, "Leandro", 44098528, "Av. 123"), LocalDate.now(),
				LocalTime.now());

		System.out.println(carrito.agregarItem(new Producto(1, "Coca Cola", 125.00f), 2));
		try {
			System.out.println(carrito.eliminarItem(new Producto(1, "Coca Cola", 125.00f), 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(carrito.traerItem(1));

	}

}
