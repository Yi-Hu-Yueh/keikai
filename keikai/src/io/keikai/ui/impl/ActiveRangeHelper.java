/* ActiveRangeHelper.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Jan 30, 2012 3:44:46 PM , Created by sam
}}IS_NOTE

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package io.keikai.ui.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import io.keikai.api.AreaRef;
import io.keikai.model.SSheet;
//import io.keikai.model.sys.XSheet;

/**
 * @author sam
 *
 */
public class ActiveRangeHelper implements Serializable {
	private static final long serialVersionUID = 4594859931532849803L;
	
	private HashMap<SSheet, AreaRef> activeRanges = new HashMap<SSheet, AreaRef>();
	
	public void setActiveRange(SSheet sheet, int tRow, int lCol, int bRow, int rCol) {
		AreaRef rect = activeRanges.get(sheet);
		if (rect == null) {
			activeRanges.put(sheet, rect = new AreaRef(tRow, lCol, bRow, rCol));
		} else {
			rect.setArea(tRow, lCol, bRow, rCol);
		}
	}
	
	public AreaRef getArea(SSheet sheet) {
		return activeRanges.get(sheet);
	}
	
	public boolean containsSheet(SSheet sheet) {
		return activeRanges.containsKey(sheet);
	}
	
	public boolean contains(SSheet sheet, int row, int col) {
		return contains(sheet, row, col, row, col);
	}
	
	public boolean contains(SSheet sheet, int tRow, int lCol, int bRow, int rCol) {
		AreaRef rect = activeRanges.get(sheet);
		if (rect == null)
			return false;
		return rect.contains(tRow, lCol, bRow, rCol);
	}
	
	//Remove this sheet from activeRanges
	//@since 3.7.0
	public AreaRef removeActiveRange(SSheet sheet) {
		return activeRanges != null ? activeRanges.remove(sheet) : null;
	}
	
	//Iterate sheets in ActiveRanges 
	public Iterator<SSheet> sheetIterator() {
		return new ArrayList<SSheet>(activeRanges.keySet()).iterator();
	}
}
