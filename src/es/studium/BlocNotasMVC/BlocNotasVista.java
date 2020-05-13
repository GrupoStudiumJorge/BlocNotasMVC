package es.studium.BlocNotasMVC;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

public class BlocNotasVista extends Frame
{
	private static final long serialVersionUID = 1L;

	// En primer lugar creamos la barra de menú
	MenuBar barraMenu = new MenuBar();

	// Ahora creamos los elementos principales del menú
	Menu archivo = new Menu("Archivo");
	Menu gestion = new Menu("Gestión");

	// MenuItem del menú archivo
	MenuItem archivoNuevo = new MenuItem("Nuevo");
	MenuItem archivoAbrir = new MenuItem("Abrir");
	MenuItem archivoGuardar = new MenuItem("Guardar");
	MenuItem archivoSalir = new MenuItem("Salir");

	// MenuItem del menú gestion
	MenuItem gestionContarPalabras = new MenuItem("Contar palabras");
	MenuItem gestionContarLetras = new MenuItem("Contar letras");
	MenuItem gestionContarVocales = new MenuItem("Contar vocales");

	// Creamos el textarea
	TextArea ta = new TextArea(20,60);

	// Creamos la ventana de diálogo
	Dialog d = new Dialog(this, "", true);

	// Y una etiqueta
	Label lblDialogo = new Label();
	
	// FileDialog
	FileDialog fd = new FileDialog(this, "Indicar ubicación y nombre del archivo");

	public BlocNotasVista()
	{
		// SIN Layout para que ocupe toda la pantalla y que se adapte siempre que esta cambie de tamaño
		setTitle("Bloc de Notas MVC");

		// Establecemos la barra de menú
		setMenuBar(barraMenu);

		// Añadimos los elementos al menú archivo
		archivo.add(archivoNuevo);
		archivo.add(archivoAbrir);
		archivo.add(archivoGuardar);
		archivo.addSeparator();
		archivo.add(archivoSalir);

		// Añadimos los elementos al menú gestion
		gestion.add(gestionContarPalabras);
		gestion.add(gestionContarLetras);
		gestion.add(gestionContarVocales);

		// Por último agregamos los elementos archivo y gestion a la barra
		barraMenu.add(archivo);
		barraMenu.add(gestion);

		// Añadimos el textarea
		this.add(ta);

		setSize(450,400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void mostrarDialogo(String titulo, String mensajeLbl)
	{
		d.setLayout(new FlowLayout());
		d.setTitle(titulo);
		lblDialogo.setText(mensajeLbl);            
		d.add(lblDialogo);
		d.setSize(200,150);
		d.setLocationRelativeTo(null);
		d.setVisible(true);
	}
}
