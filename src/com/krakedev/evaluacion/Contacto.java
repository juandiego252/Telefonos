package com.krakedev.evaluacion;

import java.util.ArrayList;

import com.krakedev.evaluacion.Direccion;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> listaTelefonos;

	public Contacto(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.listaTelefonos = new ArrayList<Telefono>();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(ArrayList<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	public void imprimir() {

		System.out.println("Cedula:" + getCedula());
		System.out.println("Nombre:" + getNombre());
		System.out.println("Apellido:" + getApellido());
		System.out.println("Direccion:");
		if (getDireccion() == null && getDireccion() == null) {
			System.out.println("No tiene asociada una direccion");

		} else {
			System.out.println("Calle Principal:" + getDireccion().getCallePrincipal());
			System.out.println("Calle Secundaria:" + getDireccion().getCalleSecundaria());

		}

	}

	public void agregarTelefono(Telefono telefono) {
		listaTelefonos.add(telefono);
	}

	public void mostrarTelefonos() {
		System.out.println("Telefonos con estado 'C'");
		for (Telefono telefono : listaTelefonos) {
			if (telefono.getEstado().equals("C")) {
				System.out.println("Numero:" + telefono.getNumero());
				System.out.println("Tipo:" + telefono.getTipo());
			}
		}
	};

	public void recuperarIncorrectos() {
		ArrayList<Telefono> listaTelefonosIncorrectos = new ArrayList<Telefono>();
		int aux = 0;
		for (Telefono telefono : listaTelefonos) {
			if (telefono.getEstado().equals("E")) {
				listaTelefonosIncorrectos.add(telefono);
				aux++;
			}
		}

		System.out.println("Incorrectos: " + aux);

		if (aux > 0) {
			System.out.println("Detalles de los teléfonos incorrectos:");
			for (Telefono telefono : listaTelefonosIncorrectos) {
				System.out.println("Número: " + telefono.getNumero());
				System.out.println("Tipo: " + telefono.getTipo());
				System.out.println("Estado: " + telefono.getEstado());
				System.out.println("-----");
			}
		}
	};

}
