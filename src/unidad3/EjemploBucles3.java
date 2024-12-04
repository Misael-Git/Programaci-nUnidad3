package unidad3;

public class EjemploBucles3 {

	public static void main(String[] args) {

		for (int i=0; i<=20; i+=2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Tablas de multiplicar:");
		System.out.println();
		
		for (int i=0; i<10; i++) {
			System.out.println("Tabla del " + (i+1) + ":");
			for (int l=0; l<10; l++) {
				System.out.print("-");
			}
			System.out.println();
			for (int x=0; x<10; x++) {
				System.out.println((i+1) + " x " + (x+1) + " = " + (i+1)*(x+1));
			}
			System.out.println();
		}
		
	}

}
