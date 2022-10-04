import java.util.Scanner;
import java.util.InputMismatchException;
public class Facturas {
	public static int aux;
	public static int num;
	public static int contProductos;
	public static String [] nombres = new String [100];
	public static int [] codigos= new int [100];
	public static double [] precios = new double [100];
	public static int [] nFacturas = new int [100];
	public static int nProductosFacturas;
	public static int cantidadProductos;
	public static String [] nombresFactura= new String [100];
	public static double [] preciosUFactura= new double[100];
	public static int [] codigosFacturas= new int[100];
	public static double [] subtotal = new double[100] ;
	public static double total;
	public static int []cantidad = new int [100];
	public static double [] totalFacturas = new double [100];
	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		total=0;
		boolean correcto = false;
		contProductos=0;
		do {
			menu(leer, correcto);
			opciones(leer, correcto);
		}while(num!=5);
	}
	
	public static void menu (Scanner leer, boolean correcto) {
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
	
	public static void opciones(Scanner leer, boolean correcto) {
		String elegir;
		switch (num) {
		case 1:
			do {
				try {
					System.out.println("¿Desea ingresar un producto? Digite Si o No");
					elegir = leer.next().toLowerCase();
					if (!elegir.equals("si") && !elegir.equals("no")) {
						throw new ArithmeticException();
					}
					if (elegir.equals("si")) {
						do {
							aux=0;
							String nombreAux="";
							System.out.println("Digite el nombre del producto");
							nombres[contProductos]=leer.next();
							nombreAux=nombres[contProductos];
							//Colocamos -1 para que no quede en un bucle porque el ultimo si es igual
							for(int i=0; i<contProductos; i++) {
								if(nombres[i].equals(nombreAux)) {
									aux=1;
									System.out.println("Producto repetido - Vuelva a intentarlo");
								} 
							}
						}while(aux==1);
						
						do {
							try {
								aux=0;
								int codigosAux=0;
								System.out.println("Digite el codigo del producto");
								codigos[contProductos]=leer.nextInt();
								if(codigos[contProductos]<0) {
									throw new ArithmeticException();
								}
								for(int i=0; i<contProductos; i++) {
									codigosAux=codigos[contProductos];
									if(codigos[i]==codigosAux) {
										aux=1;
										System.out.println("Codigo repetido - Vuelva a intentarlo");
									} 
								}
							}catch(ArithmeticException ae) {
								System.out.println("Los codigos son solamente con numeros positivos");
								aux=1;
							} catch (InputMismatchException ime) {
								System.out.println("Ingrese correctamente el codigo");
								leer.next();
								aux=1;
							}
						}while(aux==1);
						
						do {
							try {
								System.out.println("Digite el precio del producto");
								precios[contProductos]=leer.nextDouble();
								if(precios[contProductos]<=0) {
									throw new ArithmeticException();
								}
								
								correcto=false;
							}catch(ArithmeticException ae) {
								System.out.println("Digite bien el precio");
								correcto = true;
							} catch (InputMismatchException ime) {
								System.out.println("Ingrese correctamente el precio");
								leer.next();
								correcto = true;
							}
						}while(correcto);
						
						contProductos++;
						correcto=true;
					}
					if(elegir.equals("no")) {
						correcto=false;
					}
				}catch (ArithmeticException ae) {
					System.out.println("Digite Si o No correctamente");
					correcto=true;
				}
			}while(correcto);
			break;
			
		case 2:
			String elegir1="";
			do {
				correcto=false;
				int codigoAux=0;
				try {
					System.out.println("¿Desea ingresar una factura? Digite Si o No");
					elegir1 = leer.next().toLowerCase();
					if (!elegir1.equals("si") && !elegir1.equals("no")) {
						throw new ArithmeticException();
					}
					
					do {
						try {
							if (elegir1.equals("si")) {
								aux=0;
								System.out.println("Digite el codigo del producto");
								codigoAux=leer.nextInt();
								for(int i=0; i<contProductos; i++) {
									if (codigos[i]==codigoAux) {
										codigosFacturas[nProductosFacturas]= codigoAux;
										nombresFactura[nProductosFacturas]=nombres[codigoAux-1];
										preciosUFactura[nProductosFacturas]=precios[codigoAux-1];
										
										aux=0;
										break;
									} else {
										aux=1;
									}
								}
								if(aux==1){
									throw new ArithmeticException();
								}
							}
						}catch(ArithmeticException ae){
							System.out.println("Digite correctamente el codigo");
						} catch (InputMismatchException ime) {
							System.out.println("Digite correctamente el codigo");
							leer.next();
							aux=1;
						}
					}while(aux==1);
					do {
						
						try {
							if(elegir1.equals("si")) {
								System.out.println("Digite la cantidad de productos");
								cantidadProductos=leer.nextInt();
								subtotal[nProductosFacturas]=codigoAux*cantidadProductos;
								cantidad[nProductosFacturas]=cantidadProductos;
								total+=subtotal[nProductosFacturas];
								
								if(cantidadProductos<0) {
									throw new ArithmeticException();
								}
								nProductosFacturas++;
							}
							correcto=false;
						}catch (ArithmeticException ae){
							System.out.println("Digite cantidades positivas");
							correcto=true;
						}catch(InputMismatchException ime) {
							System.out.println("Digite especificamente numeros");
							correcto=true;
						}
					}while(correcto);
					
				}catch(ArithmeticException ae) {
					System.out.println("Digite Si o No correctamente");
					correcto=true;
				}
				
				if(elegir1.equals("si")) {
					correcto=true;
				} else {
					correcto=false;
				}
			}while(correcto);
			break;
		case 3:
			System.out.println("Lista de productos");
			System.out.println("Codigos"+ "	" + "Nombres"+ "	" + "Precios.U");
			for(int i=0; i<contProductos; i++) {
				System.out.println(codigos[i]+ "	" + nombres[i]+ "	" + precios[i]);
			}
			break;
		case 4:
			System.out.println("Lista de la Factura");
			System.out.println("Codigos"+ "	" + "Nombres"+ "	" + "Precios.U" + "	" + "Cantidad" + "	" + "Subtotal");
			for(int i=0; i<nProductosFacturas; i++) {
				System.out.println(codigosFacturas[i]+ "	 " + nombresFactura[i]+ "	 " + preciosUFactura[i] + "		 " + cantidad[i] + "		 "+subtotal[i]);
			}
			System.out.println("Total: " + total);
			break;
		case 5:
			System.out.println("Gracias por usar el programa");
			break;
		}
	}
}