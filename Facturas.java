package exam;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Facturas {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int num=0;
		boolean correcto=false;
		menu(leer, num, correcto);
	}
	
	public static void menu (Scanner leer, int num, boolean correcto) {
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
}
