import java.util.LinkedList;

public class Primos extends Thread {

    private long inicio = 1_010_101_010_101_010l;
    private LinkedList<Long> listaPrimos = new LinkedList<>();
    private int ct = 0;

    @Override
    public void run() {

        do {
            if (isPrimo(inicio)) { //se primo
                ct++; // contador aumenta
                listaPrimos.add(inicio); // adiciono a uma lista, o numero primo.
            }

            inicio ++; // somo mais um numero a inicio
        } while (ct < 30); // enquanto não receber 16 numeros primos, faça tudo dnv;

        System.out.println(listaPrimos);

    }

    public boolean isPrimo(long n) {
        if (n % 2 == 0) {
            return n == 2;
        }
        long raiz = ((long) Math.sqrt(n)) + 1;
        long i = 3;
        while (i < raiz) {
            if (n % i == 0) {
                return false;
            }
            i += 2;
        }
        return true;
    }

    public LinkedList<Long> getnPrimos() {
        return listaPrimos;
    }

}