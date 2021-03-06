/* NamedStyleImpl.java

	Purpose:
		
	Description:
		
	History:
		Dec 10, 2014 2:28:34 PM, Created by henrichen

	Copyright (C) 2014 Potix Corporation. All Rights Reserved.
*/

package io.keikai.model.impl;

import java.io.Serializable;

import io.keikai.model.SBook;
import io.keikai.model.SBorder;
import io.keikai.model.SCellStyle;
import io.keikai.model.SColor;
import io.keikai.model.SFill;
import io.keikai.model.SFont;
import io.keikai.model.SNamedStyle;

/**
 * @author henri
 * @since 3.7.0
 */
public class NamedStyleImpl implements SNamedStyle, Serializable {
	private static final long serialVersionUID = -3301182398902275997L;
	final private String name;
	final private boolean custom;
	final private int index;
	final private BookImpl book;
	final private int builtinId;
	
	public NamedStyleImpl(String name, boolean custom, int builtinId, SBook book, int index) {
		this.builtinId = builtinId;
		this.custom = custom;
		this.book = (BookImpl) book;
		this.name = name;
		this.index = index;
	}
	
	@Override
	public SColor getFillColor() {
		return book.getDefaultCellStyle(index).getFillColor();
	}

	@Override
	public SColor getBackColor() {
		return book.getDefaultCellStyle(index).getBackColor();
	}

	@Override
	public SFill.FillPattern getFillPattern() {
		return book.getDefaultCellStyle(index).getFillPattern();
	}

	@Override
	public Alignment getAlignment() {
		return book.getDefaultCellStyle(index).getAlignment();
	}
	
	@Override
	public VerticalAlignment getVerticalAlignment() {
		return book.getDefaultCellStyle(index).getVerticalAlignment();
	}

	@Override
	public boolean isWrapText() {
		return book.getDefaultCellStyle(index).isWrapText();
	}

	@Override
	public SBorder.BorderType getBorderLeft() {
		return book.getDefaultCellStyle(index).getBorderLeft();
	}

	@Override
	public SBorder.BorderType getBorderTop() {
		return book.getDefaultCellStyle(index).getBorderTop();
	}

	@Override
	public SBorder.BorderType getBorderRight() {
		return book.getDefaultCellStyle(index).getBorderRight();
	}

	@Override
	public SBorder.BorderType getBorderBottom() {
		return book.getDefaultCellStyle(index).getBorderBottom();
	}

	@Override
	public SColor getBorderTopColor() {
		return book.getDefaultCellStyle(index).getBorderTopColor();
	}

	@Override
	public SColor getBorderLeftColor() {
		return book.getDefaultCellStyle(index).getBorderLeftColor();
	}

	@Override
	public SColor getBorderBottomColor() {
		return book.getDefaultCellStyle(index).getBorderBottomColor();
	}

	@Override
	public SColor getBorderRightColor() {
		return book.getDefaultCellStyle(index).getBorderRightColor();
	}

	@Override
	public String getDataFormat() {
		return book.getDefaultCellStyle(index).getDataFormat();
	}

	@Override
	public boolean isDirectDataFormat() {
		return book.getDefaultCellStyle(index).isDirectDataFormat();
	}

	@Override
	public boolean isLocked() {
		return book.getDefaultCellStyle(index).isLocked();
	}

	@Override
	public boolean isHidden() {
		return book.getDefaultCellStyle(index).isHidden();
	}

	@Override
	public void setFillColor(SColor fillColor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBackgroundColor(SColor backColor) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setBackColor(SColor backColor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFillPattern(SFill.FillPattern fillPattern) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAlignment(Alignment alignment) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWrapText(boolean wrapText) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderLeft(SBorder.BorderType borderLeft) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderLeft(SBorder.BorderType borderLeft, SColor color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderTop(SBorder.BorderType borderTop) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderTop(SBorder.BorderType borderTop, SColor color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderRight(SBorder.BorderType borderRight) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderRight(SBorder.BorderType borderRight, SColor color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderBottom(SBorder.BorderType borderBottom) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderBottom(SBorder.BorderType borderBottom, SColor color) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderTopColor(SColor borderTopColor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderLeftColor(SColor borderLeftColor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderBottomColor(SColor borderBottomColor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBorderRightColor(SColor borderRightColor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDataFormat(String dataFormat) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDirectDataFormat(String dataFormat) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLocked(boolean locked) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setHidden(boolean hidden) {
		throw new UnsupportedOperationException();
	}

	@Override
	public SFont getFont() {
		return book.getDefaultCellStyle(index).getFont();
	}

	@Override
	public void setFont(SFont font) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void copyFrom(SCellStyle src) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
 		return name;
	}

	@Override
	public int getIndex() {
		return index;
	}
	
	@Override
	public boolean isCustomBuiltin() {
		return custom;
	}
	
	@Override
	public int getBuiltinId() {
		return builtinId;
	}

	//ZSS-918
	@Override
	public int getRotation() {
		return book.getDefaultCellStyle(index).getRotation();
	}

	//ZSS-918
	@Override
	public void setRotation(int rotation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndention() {
		return book.getDefaultCellStyle(index).getIndention();
	}

	@Override
	public void setIndention(int indent) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public SBorder.BorderType getBorderVertical() {
		return book.getDefaultCellStyle(index).getBorderVertical();
	}

	//ZSS-977
	@Override
	public SBorder.BorderType getBorderHorizontal() {
		return book.getDefaultCellStyle(index).getBorderHorizontal();
	}

	//ZSS-977
	@Override
	public SBorder.BorderType getBorderDiagonal() {
		return book.getDefaultCellStyle(index).getBorderDiagonal();
	}

	//ZSS-977
	@Override
	public SColor getBorderVerticalColor() {
		return book.getDefaultCellStyle(index).getBorderVerticalColor();
	}

	//ZSS-977
	@Override
	public SColor getBorderHorizontalColor() {
		return book.getDefaultCellStyle(index).getBorderHorizontalColor();
	}

	//ZSS-977
	@Override
	public SColor getBorderDiagonalColor() {
		return book.getDefaultCellStyle(index).getBorderDiagonalColor();
	}

	//ZSS-977
	@Override
	public void setBorderVertical(SBorder.BorderType borderVertical) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderVertical(SBorder.BorderType borderVertical, SColor color) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderHorizontal(SBorder.BorderType borderHorizontal) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderHorizontal(SBorder.BorderType borderHorizontal, SColor color) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderDiagonal(SBorder.BorderType borderDiagonal) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderDiagonal(SBorder.BorderType borderDiagonal, SColor color) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderVerticalColor(SColor color) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderHorizontalColor(SColor color) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public void setBorderDiagonalColor(SColor color) {
		throw new UnsupportedOperationException();
	}

	//ZSS-977
	@Override
	public SBorder getBorder() {
		return book.getDefaultCellStyle(index).getBorder();
	}

	//ZSS-977
	@Override
	public SFill getFill() {
		return book.getDefaultCellStyle(index).getFill();
	}

	//ZSS-1145
	@Override
	public boolean isShowDiagonalUpBorder() {
		return book.getDefaultCellStyle(index).isShowDiagonalUpBorder();
	}

	//ZSS-1145
	@Override
	public boolean isShowDiagonalDownBorder() {
		return book.getDefaultCellStyle(index).isShowDiagonalDownBorder();
	}
}
