package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;

public class MyIntervalRange {

  public static void main(String[] args) {
  }

  public static Observable<Long> intervalRange(long start, long count, long initDelay, long period, TimeUnit unit){
    return Observable.interval(initDelay, period, unit).map(i -> i+start).take(count);
  }

}
