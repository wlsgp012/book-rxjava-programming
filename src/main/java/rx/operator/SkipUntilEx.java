package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class SkipUntilEx {

  public static void main(String[] args) {
    String[] data = {"1", "2", "3", "4", "5", "6"};

    Observable<String> source = Observable.fromArray(data)
        .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (val, notUsed) -> val)
        .skipUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));

    source.subscribe(Log::i);
    CommonUtils.sleep(1000);
  }
}
