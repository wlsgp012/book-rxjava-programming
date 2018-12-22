package rx.operator;

import io.reactivex.Observable;
import io.reactivex.schedulers.Timed;
import rx.common.CommonUtils;
import rx.common.Log;

public class TimeIntervalEx {

  public static void main(String[] args) {
    String[] data = {"1", "3", "7"};

    CommonUtils.exampleStart();
    Observable<Timed<String>> source = Observable.fromArray(data).delay(item -> {
      CommonUtils.doSomething();
      return Observable.just(item);
    }).timeInterval();
    source.subscribe(Log::it);
    CommonUtils.sleep(1000);
  }
}
