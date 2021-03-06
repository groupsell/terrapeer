package terrapeer.vui.j3dui.control;

import java.util.*;

import terrapeer.vui.j3dui.utils.Debug;

/**
 Splits (multicasts) the source event to multiple event targets.

 @author Jon Barrilleaux,
 copyright (c) 1999 Jon Barrilleaux,
 All Rights Reserved.
 */

public class EnableSplitter implements EnableTarget
{

  // public interface =========================================

  /**
    Constructs an EnableSplitter with no event targets.
   */
  public EnableSplitter()
  {}

  /**
    Adds event target <target> to the list of event targets
    to receive events.
    @param target Event target to be added.
    @return Returns true if the event target list actually
    changed.
   */
  public boolean addEventTarget(EnableTarget target)
  {
    return _eventTargets.add(target);
  }

  /**
    Removes event target <target> from the event target list.
    @param target Event target to be removed.
    @return Returns true if the event target list actually
    changed.
   */
  public boolean removeEventTarget(EnableTarget target)
  {
    return _eventTargets.remove(target);
  }

  /**
    Removes all event targets from the event target list.
   */
  public void clearEventTargets()
  {
    _eventTargets.clear();
  }

  /**
    Gets an iterator for the event target list.
    @return Event target list iterator.
   */
  public Iterator getEventTargets()
  {
    return _eventTargets.iterator();
  }

  // EnableTarget implementation

  public void setEnable(boolean enable)
  {
    if (_lockout)
    {
      return;
    }
    _lockout = true;

    if (Debug.getEnabled())
    {
      Debug.println("EnableSplitter",
                    "SPLIT:EnableSplitter:setEnable:" +
                    " enable=" + enable);
    }

    Iterator targetI = getEventTargets();
    while (targetI.hasNext())
    {
      EnableTarget target =
          (EnableTarget)targetI.next();

      target.setEnable(enable);
    }

    _lockout = false;
  }

  // personal body ============================================

  /** If true input events are ignored. */
  private boolean _lockout = false;

  /** List of event targets. */
  private ArrayList _eventTargets = new ArrayList();

}
