package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> listaContactos;
	private Date fechaModificacion;
    private ArrayList<Contacto> correctos;
    private ArrayList<Contacto> incorrectos;
    private Telefono telefono;

	public Directorio() {
		this.listaContactos = new ArrayList<>();
		this.fechaModificacion = new Date();
	}

	public boolean agregarContacto(Contacto contacto) {
		// Verificar si el contacto ya existe antes de agregarlo
		if (contacto != null && !listaContactos.contains(contacto)) {
			listaContactos.add(contacto);
			fechaModificacion = new Date(); // Actualizar la fecha de modificación
			return true;
		}
		return false;
	}

	public Contacto buscarPorCedula(String cedula) {
		for (Contacto contacto : listaContactos) {
			if (contacto.getCedula().equals(cedula)) {
				return contacto;
			}
		}
		return null;
	}

	public Date consultarUltimaModificacion() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return fechaModificacion;
	}
	
    public int contarPerdidos() {
        int count = 0;
        for (Contacto contacto : listaContactos) {
            if (contacto.getDireccion() == null) {
                count++;
            }
        }
        return count;
    }
    
    public int contarFijos() {
        int count = 0;
        for (Contacto contacto : listaContactos) {
            if (contacto.getListaTelefonos() != null
                    && contacto.getTelefono().getTipo().equals("Convencional");
                count++;
            }
        return count;
    }
    
    public void depurar() {
        correctos.clear();
        incorrectos.clear();

        for (Contacto contacto : listaContactos) {
            if (contacto.getDireccion() != null) {
                correctos.add(contacto);
            } else {
                incorrectos.add(contacto);
            }
        }
    }

}
