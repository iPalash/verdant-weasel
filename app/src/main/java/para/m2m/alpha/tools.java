package para.m2m.alpha;

/**
 * Created by swapnil on 15/9/15.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class tools {
    public String getBattery(){
        StringBuffer output = new StringBuffer();
        String command="dumpsys batterymanager";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = output.toString();
        return response;
    }
}
