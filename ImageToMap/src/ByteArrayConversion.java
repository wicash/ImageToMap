import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class ByteArrayConversion {
	 public static void main(String[] args) throws Exception {
	      BufferedImage image = ImageIO.read(new File("sample3.bmp")); //To-Do: Muss es eine monochromatische BMP sein?
	      ByteArrayOutputStream output = new ByteArrayOutputStream();
	      ImageIO.write(image, "jpg", output );
	      byte [] data = output.toByteArray();
	      
	      
	      ArrayKonverter konverter = new ArrayKonverter(image);
	      int[][] temp = konverter.giveArray();
	      
	      System.out.println(temp.length);
	      System.out.println(temp[1].length);
	      for(int y=0; y<temp.length; y++) {
	    	  System.out.println();
	    	  for(int x=0; x<temp[y].length; x++) {
	    		  System.out.print(temp[y][x]);
	    		  
	    	 }
	    	  
	      }
	   }	
}
