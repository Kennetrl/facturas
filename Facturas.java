import java.util.Scanner;
import java.util.InputMismatchException;
public class Facturas {
	public static int num;
	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int [] codigos= new int [100];
		double [] precios = new double [100];
		String [] nombres = new String [100];
		boolean correcto = false;
		do {
			menu(leer, num, correcto);
			opciones(leer, num, correcto,nombres, codigos, precios);
		}while(num!=5);
	}
	
	public static void menu (Scanner leer, int n, boolean correcto) {
		System.out.println("Elija una opción");
		System.out.println("1 - Ingresar Productos");
		System.out.println("2 - Ingresar Factura");
		System.out.println("3 - Listar Productos");
		System.out.println("4 - Listar Facturas");
		System.out.println("5 - Salir del Programa");
		
		do {
			try {
				num = leer.nextInt();
				if (num<1 || num>5){
					throw new ArithmeticException();
				}
				correcto = false;
			}catch(ArithmeticException ae) {
				System.out.println("Ingrese la opción correctamente");
				System.out.println("Digite el numero");
				correcto = true;
			}catch (InputMismatchException ime) {
				System.out.println("Ingrese necesariamente numeros");
				System.out.println("Digite el numero");
				leer.next();
				correcto = true;
			}
		}while(correcto);
		
	}
	
	public static void opciones(Scanner leer, int num, boolean correcto, String[] nombres, int[] codigos, double[] precios) {
		String elegir ="";		
		switch (num) {
		case 1:
			System.out.println("¿Desea ingresar un producto? Digite Si o No");
			elegir = leer.next().toLowerCase();
			break;
		case 2:
			System.out.println("Opcion2");
			break;
		case 3:
			System.out.println("Opcion3");
			break;
		case 4:
			System.out.println("Opcion4");
			break;
		case 5:
			System.out.println("Gracias por usar el programa");
			break;
		}
	}
}