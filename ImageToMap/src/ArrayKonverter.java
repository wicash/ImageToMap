import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class ArrayKonverter {
	BufferedImage image;
	int height;
	int width;
	
	ArrayKonverter(BufferedImage a){
		this.image = a;
	}
	
	 public static int[][] convertToArray(BufferedImage image)

	 {

	     if (image == null || image.getWidth() == 0 || image.getHeight() == 0)
	         return null;

	     // This returns bytes of data starting from the top left of the bitmap
	     // image and goes down.
	     // Top to bottom. Left to right.
	     final byte[] pixels = ((DataBufferByte) image.getRaster()
	             .getDataBuffer()).getData();

	     final int width = image.getWidth();
	     final int height = image.getHeight();
	     
	   

	     int[][] result = new int[height][width];

	     boolean done = false;
	     boolean alreadyWentToNextByte = false;
	     int byteIndex = 0;
	     int row = 0;
	     int col = 0;
	     int numBits = 0;
	     byte currentByte = pixels[byteIndex];
	     while (!done)
	     {
	         alreadyWentToNextByte = false;

	         result[row][col] = (currentByte & 0x80) >> 7;
	         currentByte = (byte) (((int) currentByte) << 1);
	         numBits++;

	         if ((row == height - 1) && (col == width - 1))
	         {
	             done = true;
	         }
	         else
	         {
	             col++;

	             if (numBits == 8)
	             {
	                 currentByte = pixels[++byteIndex];
	                 numBits = 0;
	                 alreadyWentToNextByte = true;
	             }

	             if (col == width)
	             {
	                 row++;
	                 col = 0;

	                 if (!alreadyWentToNextByte)
	                 {
	                     currentByte = pixels[++byteIndex];
	                     numBits = 0;
	                 }
	             }
	         }
	     }

	     return result;
	 }
	 
	 int[][] giveArray(){
		 
		 return this.convertToArray(image);
		 
	 }
}
