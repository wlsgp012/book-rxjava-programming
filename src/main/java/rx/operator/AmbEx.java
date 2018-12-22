package rx.operator;

import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class AmbEx {

  public static void main(String[] args) {
    String[] data1 = {"1", "3", "5"};
    String[] data2 = {"2-R", "4-R"};

    Observable<String> source1 = Observable.fromArray(data1)
        .doOnComplete(() -> Log.d("source 1 complete"));
    Observable<String> source2 = Observable.fromArray(data2).delay(100L, TimeUnit.MILLISECONDS)
        .doOnComplete(() -> Log.d("source 2 complete"));

    Observable.amb(List.of(source2, source1)).doOnComplete(() -> Log.d("result on complete"))
        .subscribe(Log::i);

    CommonUtils.sleep(1000);
  }
}
