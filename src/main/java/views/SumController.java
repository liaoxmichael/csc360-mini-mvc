package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import models.AdderModel;
import javafx.util.converter.NumberStringConverter;

public class SumController
{
	AdderModel model;
	
	@FXML
    private TextField num1;

    @FXML
    private TextField num2;

    @FXML
    private Label sum;

    @FXML
    void addNums(ActionEvent event) {
    	int n1 = Integer.parseInt(num1.getText());
    	int n2 = Integer.parseInt(num2.getText());
    	int s = n1 + n2;
    	model.setSum(s);
    }

	public void setModel(AdderModel model)
	{
		this.model = model;
		
		StringConverter<Number> number = new NumberStringConverter();
		
		Bindings.bindBidirectional(sum.textProperty(), model.sumProperty(), number);
	}

}
