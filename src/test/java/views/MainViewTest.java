package views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import models.AdderModel;

@ExtendWith(ApplicationExtension.class)
public class MainViewTest
{

	@Start
	public void start(Stage stage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/MainView.fxml"));

		AnchorPane view = loader.load();

		SumController controller = loader.getController();
		AdderModel model = new AdderModel();
		controller.setModel(model);

		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}

	private void enterAmount(FxRobot robot, String num, String target)
	{
		robot.clickOn(target);
		robot.write(num);
	}

	private void checkSum(FxRobot robot, String expected)
	{
		robot.clickOn("#addButt");
		Assertions.assertThat(robot.lookup("#sum").queryAs(Label.class)).hasText(expected);
	}
	
	private void checkAddNums(FxRobot robot, String num1, String num2, String expected) {
		enterAmount(robot, num1, "#num1");
		enterAmount(robot, num2, "#num2");
		checkSum(robot, expected);
	}
	
	@Test
	public void testAdds(FxRobot robot) {
		checkAddNums(robot, "0", "1", "1"); // test identity
		checkAddNums(robot, "-1", "1", "0"); // test negative numbers 
		checkAddNums(robot, "10", "100", "110"); // test small-large
		checkAddNums(robot, "100", "10", "110"); // test large-small
		checkAddNums(robot, "0", "0", "0"); // test 0
		checkAddNums(robot, "NaN", "1.2", null); // test non-numbers
		checkAddNums(robot, "1", "1.2", null); // test number w/ float
		checkAddNums(robot, "NaN", "12", null); // test non-numbers w/ number
	}
}
