import utilidades.Entrada;

public class NumCifras {

    public static void main(String[] args) {
    	int numero; 
    	do {
	        System.out.print("Introduce un número entero: ");
	        numero = Entrada.entero();
    	} while (numero <= 0);
        int cifras = 0;
        //Si cambiamos el while por este comentado, podriamos evitar la sentencia numero /= 10 y así no modificar numero
        //while (numero / (int)Math.pow(10,cifras) != 0) {	
        while (numero != 0) {
        	numero /= 10;
            cifras++;
        }
        System.out.println("Tiene " + cifras + " cifras");
    }

}
