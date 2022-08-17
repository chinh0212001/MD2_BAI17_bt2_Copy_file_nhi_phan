import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        copyFile("C:\\Users\\Chinh\\IdeaProjects\\MD2_BAi17-bt2_Copy_binary\\src\\data.txt","C:\\Users\\Chinh\\IdeaProjects\\MD2_BAi17-bt2_Copy_binary\\src\\copy-data.txt");
    }
    public static void copyFile(String src, String dest){
        File in = new File(src);
        File out = new File(dest);
        if (!in.exists()){
            System.out.println("Source file does not exist");
            return;
        }
        if (out.exists()){
            System.out.println("Destination file already exists and will be overwritten");

        }
        try {
            InputStream is = Files.newInputStream(in.toPath());
            OutputStream os = Files.newOutputStream(out.toPath());
            int sum = 0;
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                sum += len;
                os.write(buffer,0,len);
            }
            System.out.println(sum);

        }catch (IOException e){
            System.out.println("Error");
        }
    }
}