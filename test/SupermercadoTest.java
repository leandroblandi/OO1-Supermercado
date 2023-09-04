package test;

import excepciones.ProductoExistenteException;
import modelos.Carrito;
import modelos.Producto;
import modelos.Supermercado;

public class SupermercadoTest {
	public static void main(String[] args) throws ProductoExistenteException {
		
		// instanciamos productos
		Producto p1 = new Producto(1, "Pelota", 500f);
		Producto p2 = new Producto(2, "Botines Nike", 1200f);
		Producto p3 = new Producto(3, "Guantes Adidas", 800f);
		
		// instanciamos supermercado
		Supermercado supermercado = new Supermercado();
		
		// hacemos add de cada producto
		supermercado.agregarProducto(p1);
		supermercado.agregarProducto(p2);
		supermercado.agregarProducto(p3);
		
		// traemos un producto
		System.out.println(supermercado.traerProducto(1));
		
		// instanciamos y hacemos add de los items con sus cantidades
		Carrito carrito = new Carrito(1);
		
		carrito.agregarItem(p1, 2);
		carrito.agregarItem(p2, 5);
		carrito.agregarItem(p3, 9);
		
		System.out.println(carrito);
		
		carrito.eliminarItem(p1, 2);
		System.out.println(carrito);
		
		System.out.println(carrito.traerItem(p2).calcularSubTotal());
		System.out.println(carrito.calcularTotal());
		
		

	}
}
