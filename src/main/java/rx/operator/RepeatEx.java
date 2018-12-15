package rx.operator;

import io.reactivex.Observable;
import rx.common.Log;

public class RepeatEx {

  public static void main(String[] args) {
    Integer[] balls= {1,3,5};
    Observable<Integer> source = Observable.fromArray(balls).repeat(3);
    source.doOnComplete(()-> Log.d("onComplete")).subscribe(Log::i);
  }
}
