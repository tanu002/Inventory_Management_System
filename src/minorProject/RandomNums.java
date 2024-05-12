package minorProject;

import java.util.Random;

public class RandomNums {
	public int genProductId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	public int genSupplierId() {
	    Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2,4)) * 10000 + r.nextInt(10000));
	}
	
}
