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

	private void enterAmount(FxRobot robot, int num, String target)
	{
		robot.clickOn(target);
		robot.write(String.valueOf(num));
	}

	private void checkSum(FxRobot robot, int expected)
	{
		robot.clickOn("#addButt");
		Assertions.assertThat(robot.lookup("#sum").queryAs(Label.class)).hasText(String.valueOf(expected));
	}
	
	private void checkAddNums(FxRobot robot, int num1, int num2) {
		enterAmount(robot, num1, "#num1");
		enterAmount(robot, num2, "#num2");
		checkSum(robot, num1+num2);
	}
	
	@Test
	public void testAdds(FxRobot robot) {
		checkAddNums(robot, 1, 1);
		checkAddNums(robot, -1, 1);
		checkAddNums(robot, 10, 100);
		checkAddNums(robot, 1, 1);
	}
}
