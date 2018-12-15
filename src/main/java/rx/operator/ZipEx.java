package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class ZipEx {

  public static void main(String[] args) throws InterruptedException {
    String[] shapes = {"Ball", "Pentagon", "Star"};
    String[] colredTriangles = { "2-T", "6-T", "4-T"};

    Observable.zip(
        Observable.fromArray(shapes),
        Observable.fromArray(colredTriangles),
        (suffix, color) -> color + suffix
    ).subscribe(Log::i);

    Observable<String> zip = Observable.zip(
        Observable.just("RED", "GREEN", "BLUE"),
        Observable.interval(200L, TimeUnit.MILLISECONDS),
        (value, i) -> value
    );

    CommonUtils.exampleStart();
    zip.subscribe(Log::it);
    TimeUnit.SECONDS.sleep(2L);
  }
}
