package rx.operator;


import io.reactivex.Observable;
import rx.common.Log;

public class ScanEx {

  public static void main(String[] args) {
    Integer[] balls = {1,3,5};
    Observable<String> scan = Observable.fromArray(balls).map(String::valueOf)
        .scan((first, second) -> second + "(" + first + ")");
    scan.subscribe(Log::i);
  }
}
