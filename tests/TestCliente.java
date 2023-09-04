package tests;

import adm.AdmCliente;

public class TestCliente {

	public static void main(String[] args) {

		AdmCliente admCliente = new AdmCliente();

		try {
			System.out.println(admCliente.agregarCliente("Leandro Blandi", 44098528, "Ceferino Namuncura 63"));
			System.out.println(admCliente.traerCliente(1));
			System.out.println(admCliente.eliminarCliente(1));
			System.out.println(admCliente.traerCliente(1));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
