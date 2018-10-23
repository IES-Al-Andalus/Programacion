import utilidades.Entrada;

public class DescomponerCifras {

    public static void main(String[] args) {
    	int numero;
        do {
        	System.out.print("Introduce un número entero: ");
        	numero = Entrada.entero();
        } while (numero <= 0);
        int cifras = (int) Math.log10(numero);
        do {
            System.out.println(numero / (int) Math.pow(10, cifras));
            numero = numero % (int) Math.pow(10, cifras);
            cifras--;
        } while (cifras >= 0);
    }

}
