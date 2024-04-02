package models;

import javafx.beans.property.SimpleIntegerProperty;

public class AdderModel
{
	SimpleIntegerProperty sum;

	public AdderModel()
	{
		sum = new SimpleIntegerProperty();
	}

	public int getSum()
	{
		return sum.get();
	}

	public void setSum(int sum)
	{
		this.sum.set(sum);
	}
	
	public SimpleIntegerProperty sumProperty() 
	{
		return this.sum;
	}
}
