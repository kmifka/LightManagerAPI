package lightmanager;

import lightmanager.intefaces.ILightManagerAir;
import lightmanager.listeners.IBUSListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Stellt den Lightmanager Air dar.
 * Diese Klasse ist die Hauptklasse der Lightmanager API.
 *
 * Über diese Klasse können alle Zonen, Szenen und Marker des LMAirs geladen werden.
 *
 * @author Korbinian, 24.09.16
 */
public class LightManagerAir extends LightManagerDataGrabber implements ILightManagerAir
{
    private final URL url;
    private final LightmanagerNetworkHandler networkHandler;
    private final List<IBUSListener> listeners = new ArrayList<>();

    public LightManagerAir(File pConfig, URL pURL)
    {
        super(pConfig);
        url = pURL;
        networkHandler = new LightmanagerNetworkHandler(url);
        _checkLMType();
        setNetworkHandler(networkHandler);
        networkHandler.setUDPListener(this::_fireBusListener);
    }

    @Override
    public void addBUSListener(IBUSListener pListener)
    {
        listeners.add(pListener);
        networkHandler.startUDPListening();
    }

    @Override
    public void removeBUSListener(IBUSListener pListener)
    {
        listeners.remove(pListener);

        if(listeners.size() == 0)
            networkHandler.stopUDPListening();
    }

    @Override
    public double getTemperature()
    {
        return 0;
    }

    @Override
    public LightManagerMetaData getMetaData()
    {
        return networkHandler.getMetaData();
    }

    @Override
    public boolean sendCommand(String pContent)
    {
        String value = networkHandler.sendHTTPRequest(Constants.HTTP_QUERY + pContent);
        return value != null && value.contains(Constants.OK);
    }

    private void _fireBusListener(String pMessage)
    {
        if(pMessage.contains(Constants.RECEIVE_IDENTIFIER))
        {
            String id = pMessage.split(Constants.RECEIVE_IDENTIFIER)[1];

            for (IBUSListener listener : listeners)
                listener.receive(id);
        }
    }

    private void _checkLMType()
    {
        String type = getMetaData().getType();
        if(!type.equals(Constants.LMAIR))
            throw new RuntimeException("Dieser Lightmanagertyp wird nicht unterstützt -> " + type);
    }
}
