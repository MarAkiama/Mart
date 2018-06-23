
import javafx.scene.shape.Circle;
import javafx.scene.image.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Color;
import java.util.*;

public class MyPlayer implements Player{
	private  Image image= new Image ("ball.gif");
	private Circle ball; 
	private Map map; 
	private Position position;
	private int [][] card;		
	int count = 0; //position of card
	
	public MyPlayer(Map map) { 
		this.map=map;
		position=map.getStartPosition();//we use position to impliment ball
		ball= new Circle(position.getX()*map.getUnit()+map.getUnit()/2,position.getY()*map.getUnit()+map.getUnit()/2,map.getUnit()/2);//x,y,height,width
		count = map.getSize();// we get size of matrix
		ball.setFill(new ImagePattern(image,0,0,1,1,true)); // set color to the ball
		map.getChildren().add(ball); // add ball to our pane
		card= new int[count][count];
		card=map.getMap();
	}
	@Override
	public void moveRight(){//key event right
		if(position.getX()<map.getSize()-1 && card[position.getX()+1][position.getY()]!=1){//condition for border
					position.setX(position.getX()+1);//we get x coordinate and set a new one by addind one
					ball.setCenterX(position.getX()*map.getUnit()+map.getUnit()/2);			
				}
	}
	@Override 
	public void moveLeft() { 
		if(position.getX()>0 && card[position.getX()-1][position.getY()]!=1){//condition for border
			
					position.setX(position.getX()-1);//we get x coordinate and set a new one by addind one
					ball.setCenterX(position.getX()*map.getUnit()+map.getUnit()/2);			
				}
	}
	@Override
	public void moveUp() {
		if(position.getY()>0 && card[position.getX()][position.getY()-1]!=1){//condition for border
					position.setY(position.getY()-1);//we get y coordinate and set a new one by addind one
					ball.setCenterY(position.getY()*map.getUnit()+map.getUnit()/2);			
				} 
	} 
	@Override
	public void moveDown() {
		if(position.getY()<map.getSize()-1 && card[position.getX()][position.getY()+1]!=1){//condition for border
					position.setY(position.getY()+1);//we get y coordinate and set a new one by addind one
					ball.setCenterY(position.getY()*map.getUnit()+map.getUnit()/2);			
			}
	} 
	@Override
	public Position getPosition(){
		return this.position;
	}
}