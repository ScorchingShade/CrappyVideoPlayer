package application;
	

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	Player player;
	FileChooser fileChoser;
	@Override
	public void start(final Stage primaryStage) {
		MenuItem open=new MenuItem("Open");
		Menu file=new Menu("File");
		MenuBar menu=new MenuBar();

		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChoser=new FileChooser();
		open.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				// TODO Auto-generated method stub
				player.player.pause();
				File file=fileChoser.showOpenDialog(primaryStage);
				
				if(file!=null){
					try {
						player=new Player(file.toURI().toURL().toExternalForm());
						Scene scene=new Scene(player,640,395,Color.BLACK);
						primaryStage.setScene(scene);
						player.setTop(menu);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		
		player=new Player("file:///C:/first.mp4");
		player.setTop(menu);
		Scene scene=new Scene(player,640,395,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ankush's Video Player");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
