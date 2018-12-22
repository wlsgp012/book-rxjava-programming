package rx.operator;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import rx.common.Log;
import rx.common.Shape;

public class AllEx {

  public static void main(String[] args) {
    String[] data = {"1","2", "3", "4"};

    Single<Boolean> source = Observable.fromArray(data).map(Shape::getShape).all(Shape.BALL::equals);

    source.subscribe((Consumer<Boolean>) Log::i);
  }
}
