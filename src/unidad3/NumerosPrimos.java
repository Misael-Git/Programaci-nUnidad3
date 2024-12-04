package unidad3;

public class NumerosPrimos {

	public static void main(String[] args) {
		
		int suma = 0;
		
		System.out.print("Los números primos son: ");

		for (int num=1; num<500; num++){
			for (int div=2; div<(num-1); div++) {
				if (num%div == 0) {
					suma = 1;
				}
			}
			if (suma == 0) {
				System.out.print(num + ", ");
			}
			suma = 0;
		}
		System.out.println("etc.");
		
	}

}
