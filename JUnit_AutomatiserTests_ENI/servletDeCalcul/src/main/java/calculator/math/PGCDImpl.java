package calculator.math;

public class PGCDImpl {
    public Long calculer(Long a, Long b) {
      while(b != 0) {
         if(a > b)
            a -= b;
         else
            b -= a;
      }

      return a;
    }
}
