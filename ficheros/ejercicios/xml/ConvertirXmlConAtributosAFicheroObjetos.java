package org.iesalandalus.programacion.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos.Persona;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConvertirXmlConAtributosAFicheroObjetos {
	
	private static final String FICHERO_OBJETOS = String.format("%s%s%s","ficheros", File.separator, "personas.dat");
	private static final String FICHERO_XML = String.format("%s%s%s", "ficheros", File.separator, "personasAtributos.xml");
	
	public static void main(String[] args) {
		Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO_XML);
		if (documentoXml != null) {
			System.out.println("Fichero XML leído correctamente.");
			escribirXmlConAtributosAFicheroObjetos(documentoXml);
		}
	}
	
	private static void escribirXmlConAtributosAFicheroObjetos(Document documentoXml) {
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_OBJETOS))){
			NodeList personas = documentoXml.getElementsByTagName("persona");
			for (int i = 0; i < personas.getLength(); i++) {
				Node persona = personas.item(i);
				if (persona.getNodeType() == Node.ELEMENT_NODE) {
					String nombre = ((Element)persona).getAttribute("nombre");
					int edad = Integer.parseInt(((Element)persona).getAttribute("edad"));
					salida.writeObject(new Persona(nombre, edad));
				}
			}
			System.out.println("Fichero de objetos escrito correctamente.");
		} catch (FileNotFoundException e) {
			System.out.printf("No se ha podido escribir el fichero %s.%n", FICHERO_OBJETOS);
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida.");
		}
	}
}
