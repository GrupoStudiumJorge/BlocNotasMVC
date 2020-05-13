package es.studium.BlocNotasMVC;

public class BlocNotasMVC
{
	public static void main(String[] args)
	{
		BlocNotasVista bnv = new BlocNotasVista();
		BlocNotasModelo bnm = new BlocNotasModelo();
		new BlocNotasControlador(bnv, bnm);
	}
}