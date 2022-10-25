import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

public class fileMaker {

    private String raiz = "c:/tmp/";
    private File diretorio;

    public fileMaker() {
        diretorio = new File(raiz);
        if (diretorio.exists() == false) {
            diretorio.mkdir();
        }

    }

    public void escreverArquivo(LinkedList<Long> listaPrimos) {

        try {

            FileWriter fw = new FileWriter(raiz + "Eduardo.txt", false);
            BufferedWriter escrita = new BufferedWriter(fw);

            long linha;

            for (int i = 0; i < listaPrimos.size(); i++) {
                linha = listaPrimos.get(i);
                escrita.write(linha + "\n"); // gravando linha;

            }

            escrita.close(); // fecha arquivo
            fw.close(); // fecha

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
