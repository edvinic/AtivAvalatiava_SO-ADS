import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {
        Primos primo1 = new Primos();
        fileMaker fileMaker = new fileMaker();
        fileReader fileReader = new fileReader();
        ExemploFTP FTP = new ExemploFTP();

        String[] options = { "Criar arquivo", "Ler Arquivos" };

        int op = JOptionPane.showOptionDialog(null, "O que deseja", "Menu", 0, -1, null, options, options[0]);

        if (op == 0) {
            primo1.run();

            fileMaker.escreverArquivo(primo1.getnPrimos());

            // FTP
            FTP.conectar(); // conectar ao host
            FTP.enviar("c:/tmp/CG3023591.txt", "/CG3023591.txt"); // enviar o arquivo
            FTP.desconectar(); // desconectar do host
        } else {
           fileReader.max_Min(); 
        }

        

    }
}
