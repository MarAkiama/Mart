public class Position{
	private int x;
	private int y;

	public Position(int x, int y){  //put Position
		this.x=x;
		this.y=y;
	}
	public Position(int i){

	}

	public int getX(){
		//we return x
		return this.x;
	}

	public int getY(){
		// we return y
		return this.y;
	}
	public void setX(int x){
		//we replace initial x with new x(set a new x)
		this.x=x;
	}

	public void setY(int y){
		//we replace initial x with new x
		this.y=y;
	}
	public boolean equals(Position another){
		return this.x==another.x && this.y==another.y;
		// this method returns true or false, if it is similar the answer will be true else false
	}
}