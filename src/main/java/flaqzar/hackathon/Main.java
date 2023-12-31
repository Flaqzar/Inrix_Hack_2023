package flaqzar.hackathon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
	private Scene scene;
	
	@Override
    public void start(Stage stage)
    {
		stage.setTitle("Test");
        this.scene = new Scene(new HTMLRegion("/testing.html", null), 750, 500, Color.web("#666970"));
        stage.setScene(this.scene);
        stage.show();
    }
 
    public static void main(String[] args)
    {
        launch(args);
    }
}
