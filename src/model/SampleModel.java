package model;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;

public class SampleModel {
	private int x,y;
	private int size;
	private String indexID;
	private Color cloColor;
	private Boolean isCheck;
	public Boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	public SampleModel(int size, int x,int y,String indexID) {
		this.size = size;
		this.x = x;
		this.y = y;
		this.indexID = indexID;
		isCheck = false;
	}
	
	public Color getCloColor() {
		return cloColor;
	}

	public void setCloColor(Color cloColor) {
		this.cloColor = cloColor;
	}

	public String getIndexID() {
		return indexID;
	}

	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}

	public int getX() {
		return x;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	public void addYRam(int add) {
		this.y = y + add;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(indexID, size, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleModel other = (SampleModel) obj;
		return Objects.equals(indexID, other.indexID) && size == other.size && x == other.x && y == other.y;
	}

}
