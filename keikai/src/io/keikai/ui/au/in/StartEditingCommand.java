/* StartEditingCommand.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 18, 2007 12:10:40 PM     2007, Created by Dennis.Chen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under Lesser GPL Version 2.1 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package io.keikai.ui.au.in;


import java.util.Map;

import io.keikai.api.Ranges;
import io.keikai.api.model.Sheet;
import io.keikai.ui.Spreadsheet;
import org.zkoss.lang.Objects;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.mesg.MZk;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.UiException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import io.keikai.ui.event.StartEditingEvent;


/**
 * A Command (client to server) for handling user(client) start editing a cell
 * @author Dennis.Chen
 *
 */
public class StartEditingCommand extends AbstractCommand implements Command {

	public void process (AuRequest request) {
		final Component comp = request.getComponent();
		if (comp == null)
			throw new UiException(MZk.ILLEGAL_REQUEST_COMPONENT_REQUIRED, this);
		final Map data = (Map)request.getData();
		if (data == null || data.size() != 6)
			throw new UiException(MZk.ILLEGAL_REQUEST_WRONG_DATA, new Object[] {Objects.toString(data), this});

		String token = (String) data.get("token");
		String sheetId = (String) data.get("sheetId");
		int row = (Integer) data.get("row");
		int col = (Integer) data.get("col");
		String clienttxt = (String) data.get("clienttxt");
		String type = (String) data.get("type");

		Sheet sheet = ((Spreadsheet) comp).getSelectedSheet();
		if (!getSheetUuid(sheet).equals(sheetId))
			return;
		
		String editText = Ranges.range(sheet, row, col).getCellEditText();
		if(editText==null){
			editText = "";
		}
		
		StartEditingEvent event = new StartEditingEvent(
				io.keikai.ui.event.Events.ON_START_EDITING, comp, sheet,
				row, col, editText, clienttxt);
		Events.postEvent(event);
		Events.postEvent(new Event("onStartEditingImpl", comp, new Object[] {token, event, type}));
	}
}