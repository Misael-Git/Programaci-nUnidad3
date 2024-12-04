package unidad3;

public class EjemploBucles1 {

	public static void main(String[] args) {

		for (int space=0; space<=1; space++) {
			System.out.println("");
		}
		
		for (int i=10; i>=0; i--) {
			for (int ast=i*2; ast>=0; ast--) {
				System.out.print(" ");
			}
			for (int ast=i*2; ast<=20; ast+=2) {
				System.out.print("*");
			}
			for (int ast=i*2; ast>=0; ast--) {
				System.out.print(" ");
			}
			for (int ast=i*2; ast<=20; ast++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for (int i=10; i>=0; i--) {
			for (int ast=i*2; ast>=0; ast-=2) {
				System.out.print("*");
			}
			for (int ast=i*2; ast<=20; ast++) {
				System.out.print(" ");
			}
			for (int ast=i*2; ast>=0; ast--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}

}
