package lightmanager;

import sun.text.normalizer.VersionInfo;

/**
 * Diese Klasse hält alle grundlegenden Informationen über den Lightmanager
 *
 * @author Korbinian, 01.10.16
 */
public class LightManagerMetaData
{
    private static final String NAME = "WhoAmI:";
    private static final String PORT = "HTTP ";
    private static final String LOGIN = "Login ";
    private static final String PASSWORD = "Pass";
    private static final String FW_VERSION = "FWverion";
    private static final String HW_VERSION = "HWversion";
    private static final String SSID = "SSID";
    private static final String TYPE = "Type";

    private String name;
    private int port;
    private String login;
    private String password;
    private VersionInfo firmwareVersion;
    private VersionInfo hardwareVersion;
    private String type;
    private String ssid;

    public LightManagerMetaData(String pData)
    {
        name = _findValue(pData, NAME);
        port = Integer.parseInt(_findValue(pData, PORT));
        login = _findValue(pData, LOGIN);
        password = _findValue(pData, PASSWORD);
        firmwareVersion = VersionInfo.getInstance(_findValue(pData, FW_VERSION));
        hardwareVersion = VersionInfo.getInstance(_findValue(pData, HW_VERSION));
        ssid = _findValue(pData, SSID);
        type = _findValue(pData, TYPE);
    }

    private String _findValue(String pData, String pIdentifier)
    {
        return pData.split(pIdentifier)[1].split("\n")[0];
    }

    /**
     * Gibt den Namen des Lightmanagers zurück
     * @return Namen des Lightmanagers
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gibt den Port zurück, unter welchem der Lightmanager erreichbar ist.
     * @return LM Port
     */
    public int getPort()
    {
        return port;
    }

    /**
     * Gibt den Username des Logins zurück
     * @return Username des Logins
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Gibt das Passwort des Logins zurück
     * @return Passwort des Logins
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Gibt die Firmware Version zurück
     * @return Firmware Version
     */
    public VersionInfo getFirmwareVersion()
    {
        return firmwareVersion;
    }

    /**
     * Gibt die Hardware Version zurück
     * @return Hardware Version
     */
    public VersionInfo getHardwareVersion()
    {
        return hardwareVersion;
    }

    /**
     * Gibt den Typen des Lightmanagers zurück
     * @return Typen des Lightmanagers
     */
    public String getType()
    {
        return type;
    }

    /**
     * Gibt die SSID des W-LANs zurück, mit welchem sich der Lightmanager verbunden hat.
     * @return SSID des W-LANs
     */
    public String getSSID()
    {
        return ssid;
    }
}
