package rx.operator;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import rx.common.CommonUtils;
import rx.common.Log;

public class MergeEx {

  public static void main(String[] args) {
    String[] data1= {"1", "3"};
    String[] data2 ={"2","4", "6"};

    Observable<String> source1 = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS)
        .map(Long::intValue)
        .map(idx -> data1[idx])
        .take(data1.length);

    Observable<String> source2 = Observable.interval(50L, TimeUnit.MILLISECONDS)
        .map(Long::intValue)
        .map(idx -> data2[idx])
        .take(data2.length);
    Observable<String> source = Observable.merge(source1, source2);

    source.subscribe(Log::i);

    CommonUtils.sleep(1000);
  }


}
