package lightmanager;

import lightmanager.listeners.IUDPListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Kümmert sich um jegliche Kommunikation zwischen API und Lightmanager über das Netzwerk
 *
 * @author Korbinian, 01.10.16
 */
public class LightmanagerNetworkHandler
{
    private URL url;
    private IUDPListener listener;
    private DatagramSocket clientSocket;
    private DatagramPacket receivePacket;
    private LightManagerMetaData metaData;
    private AtomicBoolean receiving = new AtomicBoolean();
    private Timer receivingTimer;

    public LightmanagerNetworkHandler(URL pUrl)
    {
        url = pUrl;
        receivingTimer = new Timer();
        try
        {
            clientSocket = new DatagramSocket();
            byte[] receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData,
                    receiveData.length,
                    InetAddress.getLocalHost(),
                    Constants.RECEIVE_PORT);
        }
        catch (IOException pE)
        {
            throw new RuntimeException("Fehler bei der Initialisierung des Netzwerkhandlers");
        }
    }

    public void setUDPListener(IUDPListener pListener)
    {
        listener = pListener;
    }

    public void startUDPListening()
    {
        if(!receiving.get())
        {
            receiving.set(true);

            TimerTask task = new TimerTask()
            {
                @Override
                public void run()
                {
                    try
                    {
                        _sendDiscovery();
                    }
                    catch (IOException pE)
                    {
                        throw new RuntimeException("Fehler beim Senden der Discovery Nachricht");
                    }
                }
            };

            //Alle 3 Minuten eine Discovery-Nachricht senden um verbunden zu bleiben
            receivingTimer.scheduleAtFixedRate(task, 0, Constants.SENDING_RATE);

            new Thread(() ->
            {
                try
                {
                    while (receiving.get())
                    {
                        String result = _receive();

                        if (receiving.get())
                            listener.receive(result);
                    }
                }
                catch (IOException pE)
                {
                    receiving.set(false);
                    throw new RuntimeException("Fehler beim Empfangen der UDP Nachricht");
                }
            }).start();
        }
    }

    public void stopUDPListening()
    {
        receiving.set(false);
        receivingTimer.cancel();
    }

    public String sendHTTPRequest(String pMessage)
    {
        try
        {
            String response = "";
            URL obj = new URL("http://" + url.getHost()+ "/" + pMessage);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            InputStreamReader reader = new InputStreamReader(con.getInputStream());
            try(BufferedReader in = new BufferedReader(reader))
            {
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    response += inputLine;
            }
            return response;
        }
        catch (IOException pE)
        {
            return null;
        }
    }

    public LightManagerMetaData getMetaData()
    {
        if(metaData == null)
        {
            try
            {
                _sendDiscovery();
                String receive = _receive();
                metaData = new LightManagerMetaData(receive);
            }
            catch (IOException pE)
            {
                throw new RuntimeException("Fehler beim Empfangen der Metadaten");
            }
        }

        return metaData;
    }

    private void _sendDiscovery() throws IOException
    {
        InetAddress IPAddress = InetAddress.getByName(url.getHost());
        byte[] sendData = Constants.DISCOVERY_CONTENT.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,
                sendData.length,
                IPAddress, Constants.SEND_PORT);
        clientSocket.send(sendPacket);
    }

    private String _receive() throws IOException
    {
        clientSocket.receive(receivePacket);
        return new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
    }
}
