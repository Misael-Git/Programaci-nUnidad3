package unidad3;

public class Figuras {

	public static void main(String[] args) {

		for (int i = 0; i<53; i++) {
			if (i<20 || i>32) {
				System.out.print("#");
			} else {
				if (i==20 || i==32) {
					System.out.println("#");
				}
				if (i!=26) {
					System.out.print("#");
				} else {
					System.out.print(" FIGURAS ");
				}
			}
		}
		
		for (int space=0; space<=1; space++) {
			System.out.println("");
		}
		
		for (int i=4; i>=0; i--) {
			for (int ast=i*2; ast>=0; ast--) {
				System.out.print(" ");
			}
			for (int ast=i*2; ast<=8; ast+=2) {
				System.out.print("*");
			}
			for (int ast=i*2; ast>=0; ast--) {
				System.out.print(" ");
			}
			for (int ast=i*2; ast<=8; ast++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for (int i=4; i>=0; i--) {
			for (int ast=i*2; ast>=0; ast-=2) {
				System.out.print("*");
			}
			for (int ast=i*2; ast<=8; ast++) {
				System.out.print(" ");
			}
			for (int ast=i*2; ast>=0; ast--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("\n\nCuadrado:");
		System.out.println();
		
		for (int i=0; i<4; i++) {
			for (int x=0; x<4; x++) {
				System.out.print("# ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Rectángulo:");
		System.out.println();
		
		for (int i=0; i<3; i++) {
			for (int x=0; x<10; x++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Triángulo:");
		System.out.println();
		
		for (int i=0; i<7; i++) {
			for (int x=i; x<8; x++) {
				System.out.print(" ");
			}
			for (int x=i*2-1; x>0; x--) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Rombo:");
		System.out.println();
		
		for (int i=0; i<5; i++) {
			for (int x=i; x<7; x++) {
				System.out.print(" ");
			}
			for (int x=i*2-1; x>0; x--) {
				System.out.print("#");
			}
			System.out.println();
		}
			
		for (int i=0; i<5; i++) {
			for (int x=i; x>-2; x--) {
				System.out.print(" ");
			}
			for (int x=i*2-1; x<8; x++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Escalera:");
		System.out.println();
		
		for (int i=0; i<8; i++) {
			for (int x=i; x<9; x++) {
				System.out.print(" ");
			}
			for (int x=i; x>0; x--) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Círculo:");
		System.out.println();
		
		int e = 1;
		
		for (int i=0; i<8; i+=2) {
			for (int x=i; x<10; x++) {
				System.out.print(" ");
			}
			for (int x=i*2-1; x>0; x--) {
				System.out.print("#");
			}
			System.out.println();
		}
			
		for (int i=0; i<8; i+=2) {
			for (int x=i; x>-2; x--) {
				System.out.print(" ");
			}
			for (int x=i*2-1; x<14; x++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
	}

}
