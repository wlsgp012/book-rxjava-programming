package rx.subject;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class ConnectableObservableEx {

  public static void main(String[] args) throws InterruptedException {
    Integer[] dt = {1, 3, 5};
    Observable<Integer> balls = Observable.interval(1000L, TimeUnit.MILLISECONDS).map(Long::intValue)
        .map(i -> dt[i]).take(dt.length);
    ConnectableObservable<Integer> source = balls.publish();
    source.subscribe(new Print("#1"));
    source.subscribe(new Print("#2"));
    source.connect();

    TimeUnit.SECONDS.sleep(3);
    source.subscribe(new Print("#3"));
    TimeUnit.SECONDS.sleep(5);

  }

}
