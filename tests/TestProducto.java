package tests;

import adm.AdmProducto;

public class TestProducto {

	public static void main(String[] args) {

		AdmProducto admProducto = new AdmProducto();

		try {

			System.out.println(admProducto.agregarProducto("Coca Cola Zero", 125.00f));
			System.out.println(admProducto.traerProducto(1));
			System.out.println(admProducto.agregarProducto("Coca Cola Zero", 125.00f));
			System.out.println(admProducto.eliminarProducto(1));
			System.out.println(admProducto.traerProducto(1));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
