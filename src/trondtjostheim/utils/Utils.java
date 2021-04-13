package trondtjostheim.utils;
//import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Utils{

public void print(String s){
    System.out.print(s);
}
public void println(){
    println("");
}
public void println(String s){
    System.out.println(s);
}

public void printArray(String s, float [] a){
  if (s!="") {print(s+": "); println();}
  for (int i=0; i<a.length; i++)
    print(Float.toString(a[i]) + "; "); 
  println();
}

public void printMatrix(String s, float[][] a){
  if (s!="") {print(s+": "); println();}
  for (int i=0; i<a.length; i++)
    printArray("", a[i]); 
  println();
}

/**
 * Reads and image and returns discrete channels for argb
 * @param file image file to read
 * @return float array: 0-alpha, 1-red, 2-green, 3-blue
 * @throws IOException
 */
public float[][][] readImageChannels(String file) throws IOException {
    BufferedImage image;
    float[][][] retval = null;
    try {
        image = ImageIO.read(new File(file));
        retval = convertToChannels(image);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    
    return retval;

}

public float [][][] convertToChannels(BufferedImage image) {

    final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    final int width = image.getWidth();
    final int height = image.getHeight();
    final boolean hasAlphaChannel = image.getAlphaRaster() != null;
    float[][][] result = new float[4][height][width];
    int pixel = 0;
    if (hasAlphaChannel) {
        // pixels are stored per column, so iterate j first
        for(int i=0; i<width; i++)
            for(int j=0; j<height; j++){
                float alpha = (float)( (pixels[pixel++] & 0xff));// << 24)); // alpha
                float blue = (float)(pixels[pixel++] & 0xff); // blue
                float green = (float)( pixels[pixel++] & 0xff);// << 8); // green
                float red = (float)( pixels[pixel++] & 0xff);//(float)(((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[0][j][i] = alpha;
                result[1][j][i] = red;
                result[2][j][i] = green;
                result[3][j][i] = blue;
            }
    }
    else{
        for(int i=0; i<width; i++)
            for(int j=0; j<height; j++){
                // float alpha = (float)( (pixels[pixel++] & 0xff));// << 24)); // alpha
                float blue = (float)(pixels[pixel++] & 0xff); // blue
                float green = (float)( pixels[pixel++] & 0xff);// << 8); // green
                float red = (float)( pixels[pixel++] & 0xff);//(float)(((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[0][j][i] = 255.f;
                result[1][j][i] = red;
                result[2][j][i] = green;
                result[3][j][i] = blue;
            }
    }
    
    
    
    /*
    if (hasAlphaChannel) {
       final int pixelLength = 4;
       for (int pixel = 0, row = 0, col = 0; pixel + 3 < pixels.length; pixel += pixelLength) {
          float alpha = (float)( (pixels[pixel] & 0xff));// << 24)); // alpha
          float blue = (float)(pixels[pixel + 1] & 0xff); // blue
          float green = (float)( pixels[pixel + 2] & 0xff);// << 8); // green
          float red = (float)( pixels[pixel + 3] & 0xff);//(float)(((int) pixels[pixel + 3] & 0xff) << 16); // red
          result[0][row][col] = alpha;
          result[1][row][col] = red;
          result[2][row][col] = green;
          result[3][row][col] = blue;
          col++;
          if (col == width) {
             col = 0;
             row++;
          }
       }
    } else {
       final int pixelLength = 3;
       for (int pixel = 0, row = 0, col = 0; pixel + 2 < pixels.length; pixel += pixelLength) {
          float blue = (float)((int) pixels[pixel + 1] & 0xff); // blue
          float green = (float)(((int) pixels[pixel + 2] & 0xff) << 8); // green
          float red = (float)(((int) pixels[pixel + 3] & 0xff) << 16); // red
          result[0][row][col] = 255.f;
          result[1][row][col] = red;
          result[2][row][col] = green;
          result[3][row][col] = blue;
          col++;
          if (col == width) {
             col = 0;
             row++;
          }
       }
    }*/

    return result;
 }

    
}