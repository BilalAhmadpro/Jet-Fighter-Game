

public class MyPoint 
{
         private int x;
	 private int y;
	
	MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	MyPoint(MyPoint p)
	{
		x = p.x;
		y = p.y;
	}

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
