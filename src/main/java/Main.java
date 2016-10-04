import lightmanager.LightManagerAir;
import lightmanager.LightmanagerNetworkHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Korbinian, 23.09.16
 */
public class Main
{
    public static void main(String[] args) throws MalformedURLException
    {
        try
        {
            LightManagerAir air = new LightManagerAir(new File("/Users/Korbinian/Documents/Java/Projekte/SmartHome/config.xml"), new URL("http://192.168.178.114/"));
            air.addBUSListener(System.out::println);
            air.sendCommand("togglemkr=10");

            String req = new LightmanagerNetworkHandler(new URL("http://192.168.178.114/")).sendHTTPRequest("");
            System.out.println(req);
        }
        catch (MalformedURLException pE)
        {
            pE.printStackTrace();
        }
    }
}
