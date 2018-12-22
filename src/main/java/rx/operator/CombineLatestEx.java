package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;
import rx.common.Shape;

public class CombineLatestEx {

  public static void main(String[] args) {
    String[] data1 = {"6", "7", "4", "2"};
    String[] data2 = {"DIAMOND", "STAR", "PENTAGON"};

    Observable<String> source = Observable.combineLatest(
        Observable.fromArray(data1).zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS),
            (shape, notUsed) -> Shape.getColor(shape)),
        Observable.fromArray(data2).zipWith(Observable.interval(150L, 200L, TimeUnit.MILLISECONDS),
            (shape, notUsed) -> Shape.getSuffix(shape)),
        (v1, v2) -> v1 + v2
    );

    source.subscribe(Log::i);
    CommonUtils.sleep(1000);
  }

}
