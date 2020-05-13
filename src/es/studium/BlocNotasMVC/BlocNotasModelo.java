package es.studium.BlocNotasMVC;

import java.util.StringTokenizer;

public class BlocNotasModelo
{
	public BlocNotasModelo(){}

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
