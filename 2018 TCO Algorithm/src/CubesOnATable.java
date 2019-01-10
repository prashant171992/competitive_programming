import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CubesOnATable {
	
	public int[] placeCubes(int surface) {
		int sum = 6;
		int blockX = 0;
		int blockY = 0;
		for (int i = 0; i <	10; ++i) {
			blockX++;
			int temp = sum - blockX;
			if (surface % temp == 0) {
				break;
			}
			blockY = blockX+1;
			for (int j = 0; j < 10; ++j) {
				sum+= 6 - blockX;
				if (surface % temp == 0) {
					break;
				}
			}
		}
		return null;

	}
}
