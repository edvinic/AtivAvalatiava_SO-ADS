
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;

public class ExemploFTP {
    private FTPClient client;
    private String username;
    private String password;
    private String host;
    private int port;

    public ExemploFTP() {
        client = new FTPClient();
        username = "user";
        password = "psswrd";
        port = 21;
        host = "xxx.xxx.xxx.5";

    }

    public void conectar() {
        try {
            client.connect(host, port);
            client.login(username, password);
            client.enterLocalPassiveMode();
            client.setFileType(2);

        } catch (Exception e) {

        }
    }

    public void desconectar() {

        try {
            if (client.isConnected()) {
                client.logout();
                client.disconnect();
            }

        } catch (Exception e) {

        }

    }

    public boolean enviar(String localFile, String remoteFile) {

        try {
            if (client.isConnected()) {
                new File(localFile);
                InputStream inputStream = new FileInputStream(localFile);
                // String arquivoRemoto = remoteFile;
                System.out.println("Enviando arquivo...");
                boolean done = client.storeFile(remoteFile, inputStream);
                inputStream.close();

                if (done) {
                    System.out.println("Arquivo Enviado");
                }
            } else {
                System.out.println("Conta está desconectada");
            }
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
