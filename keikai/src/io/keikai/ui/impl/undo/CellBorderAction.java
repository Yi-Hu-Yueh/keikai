/* CellStyleAction.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2013/7/25, Created by Dennis.Chen
}}IS_NOTE

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
 */
package io.keikai.ui.impl.undo;

import io.keikai.api.CellOperationUtil;
import io.keikai.api.Range;
import io.keikai.api.Ranges;
import io.keikai.api.model.Book;
import io.keikai.api.model.CellStyle;
import io.keikai.api.model.Sheet;

/**
 * 
 * @author dennis
 * 
 */
public class CellBorderAction extends AbstractCellDataStyleAction {
	private static final long serialVersionUID = -235160919724611839L;
	
	private final Range.ApplyBorderType _applyType;
	private final CellStyle.BorderType _borderType;
	private final String _htmlColor;
	
	
	private final int _reservedRow,_reservedColumn,_reservedLastRow,_reservedLastColumn;
	
	public CellBorderAction(String label, Sheet sheet, int row, int column,
			int lastRow, int lastColumn, Range.ApplyBorderType applyType,
			CellStyle.BorderType borderType,String htmlColor) {
		super(label, sheet, row, column, lastRow, lastColumn,RESERVE_STYLE);
		this._applyType = applyType;
		this._borderType = borderType;
		this._htmlColor = htmlColor;
		
		
		//have to extend the reserve range in set border case.
		//(when set the left border of B2, it also sets the right border of A2) 
		Book book = sheet.getBook();
		_reservedRow = _row>0?_row-1:_row;
		_reservedColumn = _column>0?_column-1:_column;
		_reservedLastRow = lastRow<book.getMaxRows()-1?lastRow+1:lastRow;
		_reservedLastColumn = lastColumn<book.getMaxColumns()-1?lastColumn+1:lastColumn;
	}

	@Override
	protected int getReservedRow(){
		return _reservedRow;
	}
	@Override
	protected int getReservedColumn(){
		return _reservedColumn;
	}
	@Override
	protected int getReservedLastRow(){
		return _reservedLastRow;
	}
	@Override
	protected int getReservedLastColumn(){
		return _reservedLastColumn;
	}
	
	protected void applyAction() {
		Range r = Ranges.range(_sheet, _row, _column, _lastRow, _lastColumn);
		CellOperationUtil.applyBorder(r, _applyType, _borderType, _htmlColor);
	}

}
