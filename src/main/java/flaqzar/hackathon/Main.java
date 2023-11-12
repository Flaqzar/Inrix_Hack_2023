package flaqzar.hackathon;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

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
		String content = null;
		URLConnection connection = null;
		try {
		  connection = new URL("https://en.wikipedia.org/wiki/Santa_Clara_County,_California").openConnection();
		  Scanner scanner = new Scanner(connection.getInputStream());
		  scanner.useDelimiter("\\Z");
		  content = scanner.next();
		  scanner.close();
		}catch ( Exception ex ) {
		    ex.printStackTrace();
		}
		
		
		System.out.println(content);
		
        stage.setTitle("Test");
        this.scene = new Scene(new HTMLRegion("/testing.html"), 750, 500, Color.web("#666970"));
        stage.setScene(this.scene);
        stage.show();
    }
 
    public static void main(String[] args)
    {
        launch(args);
    }
}
