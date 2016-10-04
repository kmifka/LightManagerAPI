package lightmanager.objects;

import lightmanager.XMLConstants;
import lightmanager.actionexecutor.SceneExecutor;
import lightmanager.intefaces.objects.IScene;
import org.jdom.Element;

/**
 * Stellt eine Szene dar
 *
 * @author Korbinian, 04.10.16
 */
public class Scene implements IScene
{
    private String name;
    private SceneExecutor executor;

    public Scene(SceneExecutor pExecutor, Element pElement)
    {
        name = pElement.getChildText(XMLConstants.NAME);
        executor = pExecutor;
    }

    @Override
    public void start()
    {
        executor.startScene();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
