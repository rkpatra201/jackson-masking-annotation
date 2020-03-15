import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppTest {
    public static void main(String[] args) throws Exception {

       // Builder("git clone https://github.com/rkpatra201/jackson-masking-annotation.git");

        String command = "mvn clean install -DskipTests";
        Builder(command);
    }

    public static void Builder(String cmdCommand) {
        String path = "./";
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"" + path + "\"&&" + cmdCommand);
            builder.redirectErrorStream(true);
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
