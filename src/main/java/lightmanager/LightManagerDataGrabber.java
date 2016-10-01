package lightmanager;

import lightmanager.intefaces.*;
import lightmanager.intefaces.objects.IActuator;
import lightmanager.intefaces.objects.IMarker;
import lightmanager.intefaces.objects.IScene;
import lightmanager.intefaces.objects.IZone;
import lightmanager.objects.Actuator;
import lightmanager.objects.Zone;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Klasse zum Laden der Zonen, Szenen und Markerinformationen aus der config.xml
 *
 * @author Korbinian, 24.09.16
 */
class LightManagerDataGrabber implements ILightManagerBasic
{
    private Document config;
    private LightmanagerNetworkHandler networkHandler;

    public IZone[] getZones()
    {
        ArrayList<IZone> zones = new ArrayList<>();
        Element element = config.getRootElement();
        List<Element> xmlZones = element.getChildren(XMLConstants.ZONE);
        for (Element child : xmlZones)
        {
            List<IActuator> actuators = new ArrayList<>();
            Element xmlName = child.getChild(XMLConstants.ZONENAME);
            List<Element> xmlAktuators = child.getChild(XMLConstants.AKTUATORS).getChildren(XMLConstants.AKTUATOR);
            for (Element aktuator : xmlAktuators)
            {
                IActionExecutor executor = LightManagerUtil.getActionExecutor(aktuator);
                executor.setListener(pSrc -> sendCommand(pSrc.getCommand()));
                IActuator actuator = new Actuator(executor, aktuator);
                actuators.add(actuator);
            }

            IZone zone = new Zone(xmlName.getValue(), actuators.toArray(new Actuator[0]));
            zones.add(zone);
        }
        return zones.toArray(new IZone[0]);
    }

    public IMarker[] getMarker()
    {
        return new IMarker[0];
    }

    public IScene[] getScenes()
    {
        return new IScene[0];
    }

    /**
     * Setzt den zu verwendenden NetworkHandler
     * @param pNetworkHandler zu verwendenden NetworkHandler
     */
    final void setNetworkHandler(LightmanagerNetworkHandler pNetworkHandler)
    {
        networkHandler = pNetworkHandler;
    }

    /**
     * Setzt die Config.xml Datei
     * @param pConfig
     */
    final void setConfig(File pConfig)
    {
        try
        {
            config = new SAXBuilder().build(pConfig);
        }
        catch (Exception pE)
        {
            throw new RuntimeException("Fehler beim Lesen der config.xml", pE);
        }
    }
}
