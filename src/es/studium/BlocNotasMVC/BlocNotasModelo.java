package es.studium.BlocNotasMVC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlocNotasModelo
{
	public BlocNotasModelo(){}
	
	public String abrir(String fichero)
	{
		String resultado = "";
		try
		{
			// Buffer de lectura enlazado al FileReader que enlaza con el fichero físico
			BufferedReader entrada = new BufferedReader(new FileReader(fichero));
			String s;
			// Bucle para sacar toda la información del archivo línea a línea
			while((s=entrada.readLine())!=null)
			{
				// Añadimos el texto al final del textarea
				resultado += s;
				// Añadimos un salto de línea en el textarea para que cada línea aparezca por separado
				resultado += ("\n");
			}
			// Cerrar el objeto entrada
			entrada.close();
		}
		catch(IOException i)
		{
			resultado = "Error";
		}
		return resultado;
	}
	public boolean guardar(String fichero, String contenido)
	{
		boolean resultado = true;
		try
		{
			// Buffer de escritura enlazado al FileWriter que enlaza con el fichero físico
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			// Objeto para la escritura en el Buffer
			PrintWriter salida = new PrintWriter(bw);
			// Copia en el archivo el contenido del textarea
			salida.println(contenido);
			// Cerrar objetos de salida
			bw.close();
			salida.close();
		}
		catch(IOException i)
		{
			resultado = false;
		} 
		return resultado;
	}

	public int gestionContarPalabras(String miCadena)
	{
		// Buscamos palabras separadas por " " y por \n o Intro
		StringTokenizer auxiliar1 = new StringTokenizer(miCadena, " ");
		StringTokenizer auxiliar2 = new StringTokenizer(miCadena, "\n");
		int numPalabras = auxiliar1.countTokens() + auxiliar2.countTokens();
		// Si el TextArea tiene contenido debemos quitar uno, pues cuenta uno de más siempre
		if(numPalabras!=0)
		{
			numPalabras--;
		}
		return numPalabras;
	}
	
	public int gestionContarLetras(String texto)
	{
		int numLetras = 0;
		char c = 0;
		// Contamos Letras. No se cuentan los espacios y ni otros símbolos de control
		for(int i=0; i<texto.length();i++)
		{
			c = texto.charAt(i);

			if(Character.isLetter(c))
				numLetras++;
		}
		return numLetras;
	}
	
	public int gestionContarVocales(String texto)
	{
		int numVocales = 0;
		char c = 0;
		for(int i=0; i<texto.length();i++)
		{
			// Recorremos letra a letra 
			c = texto.charAt(i);

			if(Character.isLetter(c))
			{
				// Vocales minúsculas sin tilde
				if ((c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u'))
				{
					numVocales++;
				}
				// Vocales minúsculas con tilde
				else if ((c=='á')||(c=='é')||(c=='í')||(c=='ó')||(c=='ú'))
				{
					numVocales++;
				}
				// Vocales mayúsculas sin tilde
				else if ((c=='A')||(c=='E')||(c=='I')||(c=='O')||(c=='U'))
				{
					numVocales++;
				}
				// Vocales mayúsculas con tilde
				else if ((c=='Á')||(c=='É')||(c=='Í')||(c=='Ó')||(c=='Ú'))
				{
					numVocales++;
				}
			}
		}
		return numVocales;
	}
}
