import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import java.util.*;
import javafx.scene.input.*;

public class Game extends Application{
	private Map maps;
	private MyPlayer ball;
	private Food food;
	private static String s;

	public static void main(String[] args) throws FileNotFoundException{
	try{
			s=args[0];//reads file
	}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Can not find");//will print it if it doesnt exist

		}
		Application.launch(args);

	}

	@Override
    public void start(Stage primaryStage) throws FileNotFoundException{
    	


    	maps=new Map(s); //open the map 
    	ball= new MyPlayer(maps); // open the ball
    	food = new Food(maps, ball);
    	Scene scene = new Scene(maps, 900, 900); // size


    	scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.UP) {
				ball.moveUp();
			}
			else if  (e.getCode() == KeyCode.DOWN) {
				ball.moveDown();
			}
			else if  (e.getCode()==KeyCode.RIGHT){
				ball.moveRight();
			}
			else if (e.getCode()==KeyCode.LEFT){
				ball.moveLeft();
			}
		});
		 



		primaryStage.setTitle("Eater"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	
	}

}
