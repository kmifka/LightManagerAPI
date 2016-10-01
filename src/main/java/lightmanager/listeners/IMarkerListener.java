package lightmanager.listeners;

import lightmanager.enums.EMarkerState;

/**
 * Listener für den Marker.
 *
 * @author Korbinian, 24.09.16
 */
public interface IMarkerListener
{
    /**
     * Löst aus, wenn sich der Status des Markers geändert hat
     * @param pNewState neue Marker Status
     * @param pOldState alter Marker Status
     */
    void change(EMarkerState pNewState, EMarkerState pOldState);
}
