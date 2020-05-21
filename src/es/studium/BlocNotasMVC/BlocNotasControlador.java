package es.studium.BlocNotasMVC;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class BlocNotasControlador implements WindowListener, ActionListener
{
	BlocNotasVista bnv = null;
	BlocNotasModelo bnm = null;

	public BlocNotasControlador(BlocNotasVista bnv, BlocNotasModelo bnm)
	{
		this.bnv = bnv;
		this.bnm = bnm;
		// Escuchador de la ventana
		bnv.addWindowListener(this);
		// Para poder cerrar el Diálogo
		bnv.d.addWindowListener(this);
		// Listeners de las opciones de los submenús
		bnv.archivoNuevo.addActionListener(this);
		bnv.archivoAbrir.addActionListener(this);
		bnv.archivoGuardar.addActionListener(this);
		bnv.archivoSalir.addActionListener(this);

		bnv.gestionContarPalabras.addActionListener(this);
		bnv.gestionContarLetras.addActionListener(this);
		bnv.gestionContarVocales.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		Object a;
		a = ae.getSource();
		// Archivo Nuevo
		if(a.equals(bnv.archivoNuevo))
		{
			// Borramos el textarea
			bnv.ta.selectAll();
			bnv.ta.setText("");
		}
		// Archivo Abrir
		else if(a.equals(bnv.archivoAbrir))
		{
			bnv.fd.setMode(FileDialog.LOAD);
			// Establecer el Tipo de fichero
			bnv.fd.setFile("*.txt");
			// Mostrar el FiledDialog fd
			bnv.fd.setVisible(true);
			// Elaboramos la ruta al fichero y el nombre con los datos aportados por el usuario
			String filename = bnv.fd.getDirectory()+bnv.fd.getFile();

			// Si el archivo NO existe
			if (filename == "")
			{
				// Mostrar el Diálogo
				bnv.mostrarDialogo("Archivo No encontrado", "Archivo No encontrado");
				bnv.d.addWindowListener(this);
			}
			else
			{
				// Vaciamos el TextArea
				bnv.ta.selectAll();
				bnv.ta.setText("");
				// Cargamos el contenido del fichero en el TextArea
				if(bnm.abrir(filename).equals("Error"))
				{
					// Mostrar el Diálogo
					bnv.mostrarDialogo("Archivo No encontrado","Archivo No encontrado");
					bnv.d.addWindowListener(this);
				}
				else
				{
					bnv.ta.append(bnm.abrir(filename));
				}
			}
		}
		// Archivo Guardar
		else if(a.equals(bnv.archivoGuardar))
		{
			bnv.fd.setMode(FileDialog.SAVE);
			// Establecer el Tipo de fichero
			bnv.fd.setFile("*.txt");
			// Mostrar el FiledDialog fd
			bnv.fd.setVisible(true);
			// Elaboramos la ruta al fichero y el nombre con los datos aportados por el usuario
			String filename = bnv.fd.getDirectory()+bnv.fd.getFile();
			if(bnm.guardar(filename, bnv.ta.getText()))
			{
				// Mostrar el Diálogo
				bnv.mostrarDialogo("Archivo guardado","Guardado archivo " + bnv.fd.getFile());
				bnv.d.addWindowListener(this);
			}
			else
			{
				// Mostrar el Diálogo
				bnv.mostrarDialogo("Error al guardar Archivo", "Error al guardar Archivo");
				bnv.d.addWindowListener(this);
			}           
		}
		// Archivo Salir
		else if(a.equals(bnv.archivoSalir))
		{
			System.exit(0);
		}
		else if(a.equals(bnv.gestionContarPalabras))
		{
			// Sacamos el contenido del TextArea
			String miCadena = bnv.ta.getText();
			int numPalabras = bnm.gestionContarPalabras(miCadena);

			// Mostrar el Diálogo
			bnv.mostrarDialogo("Contador de Palabras","Hay " + numPalabras + " palabras en el texto.");
			bnv.d.addWindowListener(this);
		}
		else if(a.equals(bnv.gestionContarLetras))
		{
			int numLetras = 0;

			// Sacamos el contenido del TextArea
			String texto = bnv.ta.getText();
			numLetras = bnm.gestionContarLetras(texto);

			// Mostrar el Diálogo
			bnv.mostrarDialogo("Contador de Letras", "Hay " + numLetras + " letras en el texto.");
			bnv.d.addWindowListener(this);
		}
		else 
		{
			int numVocales = 0;

			// Sacamos el contenido del TextArea
			String texto = bnv.ta.getText();
			numVocales = bnm.gestionContarVocales(texto);

			// Mostrar el Diálogo
			bnv.mostrarDialogo("Contador de Vocales", "Hay " + numVocales + " vocales en el texto.");
			bnv.d.addWindowListener(this);
		}      
	}
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) 
	{
		// Si el diálogo tiene el foco
		if(bnv.d.hasFocus())
		{
			// Ocultamos la ventana
			bnv.d.setVisible(false);
		}
		// Si no tiene el foco, cerramos el programa
		else
		{
			System.exit(0);
		}
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
}
