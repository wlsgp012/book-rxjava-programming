package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class IntervalEx {

  public static void main(String[] args) throws InterruptedException {
    CommonUtils.exampleStart();
    Observable.interval(0L,100l, TimeUnit.MILLISECONDS).map(data -> (data + 1 * 100)).take(5)
        .subscribe(Log::it);
    TimeUnit.SECONDS.sleep(2L);

  }

}
