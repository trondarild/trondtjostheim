package trondtjostheim.math;

public class Maths {
    public float[][] zeros(int rows, int cols){
        float[][] ret = new float[rows][cols];
        return ret;
      }
      public float[] zeros (int dim){
        float [] ret = new float[dim];
        return ret;
      }
      public float[][] id(int sz){
        float [][] ret = zeros(sz, sz);
        for (int j=0; j < ret.length; j++)
          for (int i=0; i < ret[0].length; i++)
            if (j==i) ret[j][i] = 1;
        return ret;
      }
      public float[][] ones(int rows, int cols){
        float [][] ret = zeros(rows, cols);
        for (int j=0; j<ret.length; j++)
          for (int i=0; i<ret[0].length; i++)
            ret[j][i] = 1;
        return ret;
      }
      public float [][] reset(float[][] a){
        for (int j=0; j<a.length; j++)
          for (int i=0; i<a[0].length; i++)
            a[j][i] = 0;
        return a;
      }
      public float[][] multiply(float val, float[][] mat){
        float [][] ret = zeros(mat.length, mat[0].length);
        for (int j=0; j<ret.length; j++)
          for (int i=0; i<ret[0].length; i++)
            ret[j][i] = val * mat[j][i];
        return ret;
      }
      public float[][] addMatrix(float val, float[][] mat){
        float [][] ret = zeros(mat.length, mat[0].length);
        for (int j=0; j<ret.length; j++)
          for (int i=0; i<ret[0].length; i++)
            ret[j][i] = val + mat[j][i];
        return ret;
      }
      public float[][] addMatrix(float[][] a, float[][] b){
        float [][] ret = zeros(a.length, a[0].length);
        for (int j=0; j<ret.length; j++)
          for (int i=0; i<ret[0].length; i++)
            ret[j][i] = a[j][i] + b[j][i];
        return ret;
      }
      public float[] ravel(float[][] a){
        float []ret = zeros(a.length*a[0].length);
        int cnt = 0;
        for (int j=0; j<a.length; j++)
          for (int i=0; i<a[0].length; i++)
            ret[cnt++] = a[j][i];
        return ret;
      }
      public float[][] subtractMatrix(float[][] a, float[][] b){
        float [][] ret = zeros(a.length, a[0].length);
        for (int j=0; j<ret.length; j++)
          for (int i=0; i<ret[0].length; i++)
            ret[j][i] = a[j][i] - b[j][i];
        return ret;
      }
      public float[][] threshold(float val, float[][] mat){
        float [][] ret = zeros(mat.length, mat[0].length);
        for (int j=0; j<ret.length; j++)
          for (int i=0; i<ret[0].length; i++)
            if(mat[j][i] >= val)
              ret[j][i] = mat[j][i];
        return ret;
      }
    
      /**
       * Winner takes all for an array;
       * Sets everything other than highest val to zero
       * @param a
       * @return
       */
      public float[] wta(float[] a){
        float[] retval = new float[a.length];
        int i = argmax(a); 
        retval[i] = a[i];
        return retval;
      }

    public int argmax(float[] a) {
      float re = Float.MIN_VALUE;
      int arg = -1;
      for (int i = 0; i < a.length; i++) {
          if (a[i] > re) {
              re = a[i];
              arg = i;
          }
      }
      return arg;
    }
}
