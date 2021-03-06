//rotate array a leftwords d times...

static int[] rotLeft(int[] a, int d) {
        int [] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            int newLocation = (i + (a.length - d))%a.length;
            result[newLocation] = a[i];
        }
        return result;
  }
