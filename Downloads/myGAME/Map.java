import javafx.animation.KeyFrame;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.*;
import java.io.*;
public class Map extends Pane{
	private int unit;
	private int size;
	private int [][] map;
	private Position start;
	private int num;
  public Map(String filename) throws FileNotFoundException{
		    File file = new File(filename);
        Scanner input = new Scanner(file);
        unit=40; //we gave unit for height and width
        size=input.nextInt(); //reads matrix size
        map=new int [size][size]; //we gave size for double array and opened it
        for(int row=0; row<size;row++){ 
        	for(int col=0; col<size;col++){
                num=input.nextInt(); // scan the numver
                map[col][row]=num; // found a number
          		if(num==2){
          			start=new Position(col,row); // if a number is 2 we statr position
          		}
              if(num==0 || num==2){// if number is 0 and 2 draws white rectangle
                Rectangle rec= new Rectangle(col*unit,row*unit,unit,unit); // Rectangle(x,y,height,width)
                rec.setFill(Color.WHITE); //set inner color 
                rec.setStroke(Color.PINK);// set outer color
                this.getChildren().add(rec); //add rectangle
              }
          		if(num==1){
          			Rectangle rec= new Rectangle(col*unit,row*unit,unit,unit);
          			rec.setFill(Color.PINK);
          			this.getChildren().add(rec);
          		}
          		
            }
        }
  }
  public int getUnit(){
      	return unit;// we return the size of one cell
	}
	public int getSize(){
		return size;
	}
	// we return size of map(number of columns/rows)
	
	public int[][] getMap(){
		return map;
		//we return map
	}
	public Position getStartPosition(){
		return start;//we return starting position
	}
 
  
}


