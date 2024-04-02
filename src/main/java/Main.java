import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.AdderModel;
import views.SumController;

public class Main extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/MainView.fxml"));

		AnchorPane view = loader.load();

		SumController controller = loader.getController();
		AdderModel model = new AdderModel();
		controller.setModel(model);

		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
