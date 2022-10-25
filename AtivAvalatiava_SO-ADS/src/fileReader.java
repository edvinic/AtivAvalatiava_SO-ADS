import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;

public class fileReader {

    private String raiz = "c:/tmp/";
    private File diretorio;
    private LinkedList<Long> fileRead = new LinkedList<>();
    private LinkedList<String> nomeArquivo = new LinkedList<>();

    // ler diretorio
    // ler arquivos
    // salvar min e max dos arquivos
    // comparar min e max
    // mostrar min e max

    public fileReader() {
        diretorio = new File(raiz);
        if (diretorio.exists() == false) {
            diretorio.mkdir();
        }

    }

    public void max_Min() {

        int ct = 0;

        DirectoryFiles();

        do {
            lerArquivo(nomeArquivo.get(ct));
            ct++;

        } while (ct < (nomeArquivo.size()));

        System.out.println(fileRead);

        System.out.println("Máximo: " + Collections.max(fileRead) + "\nMinimo: " + Collections.min(fileRead));

    }

    public void DirectoryFiles() { // ler diretorio
        String[] pathnames;
        File f = new File(raiz);

        pathnames = f.list();

        for (String pathname : pathnames) {
            nomeArquivo.add(pathname);
            System.out.println(pathname);
        }
    }

    public void lerArquivo(String nomeFile) { // ler arquivos

        try {
            FileReader fr = new FileReader(raiz + nomeFile);
            BufferedReader leitura = new BufferedReader(fr);
            String linha = "";

            do {
                linha = leitura.readLine();
                fileRead.add(Long.parseLong(linha));

            } while (linha != null);

            // System.out.println(fileRead);

            leitura.close();
            fr.close();

        } catch (Exception e) {

        }

    }

}
