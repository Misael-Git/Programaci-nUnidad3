package unidad3;

public class EjemploBucles4 {

	public static void main(String[] args) {

		System.out.println("Números pares hasta el 40");
		for (int i = 0; i < 40; i++) {
			if ((i + 1) % 2 != 0)
				continue;
			System.out.println(i + 1);
		}
	}

}
