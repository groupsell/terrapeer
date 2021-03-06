package terrapeer.vui.j3dui.control.inputs;

import java.util.*;
import javax.media.j3d.*;

/**
Splits (multicasts) the source event to multiple event targets.

@author Jon Barrilleaux,
copyright (c) 1999 Jon Barrilleaux,
All Rights Reserved.
*/

public class InputModifierSplitter
 implements InputModifierTarget {
	
	// public interface =========================================

	/**
	Constructs an InputModifierSplitter with no event targets.
	*/
	public InputModifierSplitter() {}

	/**
	Adds event target <target> to the list of event targets
	to receive events.
	@param target Event target to be added.
	@return Returns true if the event target list actually
	changed.
	*/
	public boolean addEventTarget(InputModifierTarget target) {
		return _eventTargets.add(target);
	}

	/**
	Removes event target <target> from the event target list.
	@param target Event target to be removed.
	@return Returns true if the event target list actually
	changed.
	*/
	public boolean removeEventTarget(
	 InputModifierTarget target) {
		return _eventTargets.remove(target);
	}

	/**
	Removes all event targets from the event target list.
	*/
	public void clearEventTargets() {
		_eventTargets.clear();
	}

	/**
	Gets an iterator for the event target list.
	@return Event target list iterator.
	*/
	public Iterator getEventTargets() {
		return _eventTargets.iterator();
	}
	
	// InputModifierTarget implementation
	
	public void setInputModifier(int modifier) {
		if(_lockout) return;
		_lockout = true;
	 
		Iterator targetI = getEventTargets();
		while(targetI.hasNext()) {
			InputModifierTarget target =
			 (InputModifierTarget)targetI.next();
		
			target.setInputModifier(modifier);
		}
		
		_lockout = false;
	}
			
	// personal body ============================================
	
	/** If true input events are ignored. */
	private boolean _lockout = false;
	
	/** List of event targets. */
	private ArrayList _eventTargets = new ArrayList();	

}