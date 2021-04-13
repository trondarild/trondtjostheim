package trondtjostheim.utils;
import java.util.Arrays;

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


    
}