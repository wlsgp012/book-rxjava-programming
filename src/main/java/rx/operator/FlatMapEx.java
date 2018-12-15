package rx.operator;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import rx.common.Log;

public class FlatMapEx {

  public static void main(String[] args) {
    Function<Integer, Observable<String>> getDoubleDiamonds = ball -> Observable.just(ball + "<>", ball + "<>");

    Integer[] balls = {1, 3, 5};

    Observable<String> source = Observable.fromArray(balls).flatMap(getDoubleDiamonds);

    source.subscribe(Log::i);
  }

}
