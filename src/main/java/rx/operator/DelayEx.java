package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class DelayEx {

  public static void main(String[] args) {
    String[] data = {"1", "2", "3", "4"};
    Observable<String> source = Observable.fromArray(data).delay(100L, TimeUnit.MILLISECONDS);
    source.subscribe(Log::it);
    CommonUtils.sleep(1000);
  }
}
