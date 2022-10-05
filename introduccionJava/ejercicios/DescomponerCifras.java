import org.iesalandalus.programacion.utilidades.Entrada;

public class DescomponerCifras {

    public static void main(String[] args) {
    	int numero;
        do {
        	System.out.print("Introduce un número mayor que cero: ");
        	numero = Entrada.entero();
        } while (numero <= 0);
        int posicionCifra = (int) Math.log10(numero);
        while (posicionCifra >= 0) {
            System.out.println(numero / (int) Math.pow(10, posicionCifra));
            numero = numero % (int) Math.pow(10, posicionCifra);
            posicionCifra--;
        }
    }

}
