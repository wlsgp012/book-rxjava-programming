package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class ConcatMapEx {

  public static void main(String[] args) {
    CommonUtils.exampleStart();
    Integer[] balls = {1, 3, 5};
    Observable<Integer> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
        .map(Long::intValue).map(idx -> balls[idx])
        .take(balls.length).concatMap(
            ball -> Observable.interval(200L, TimeUnit.MILLISECONDS).map(n -> ball + 100).take(2));

    source.subscribe(Log::it);
    CommonUtils.sleep(2000);
  }
}
