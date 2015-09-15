package para.m2m.alpha;

/**
 * Created by swapnil on 15/9/15.
 */
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tools {
    public String batterypercentage(String dump){
        String pat="level: (\\d+)";
        Pattern p=Pattern.compile(pat);
        Matcher m=p.matcher(dump);
        if (m.find( )) {
            return m.group(1);
        }
        else return "NF";
    }
    public String batterytemp(String dump){
        String pat="temperature: (\\d+)";
        Pattern p=Pattern.compile(pat);
        Matcher m=p.matcher(dump);
        if (m.find( )) {
            return m.group(1);
        }
        else return "NF";
    }
    public String getBatterydump(){
        StringBuffer output = new StringBuffer();
        String command="su dumpsys battery";
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = output.toString();
        System.out.println("saldnsaklndlaks");
        System.out.println(response);
        System.out.println("sdalkdksl");
        return response;
    }
}
