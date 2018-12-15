package rx.operator;

import io.reactivex.Observable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import rx.common.CommonUtils;
import rx.common.Log;

public class DeferEx {
    static Iterator<Integer> colors = Arrays.asList(1, 3, 5, 6).iterator();

  public static void main(String[] args) {

    Callable<Observable<String>> supplier = () -> getObservable();
    Observable<String> source = Observable.defer(supplier);
//    Observable<String> source = getObservable();

    source.subscribe(val -> Log.i("#1:"+val));
    source.subscribe(val -> Log.i("#2:"+val));
    source.subscribe(val -> Log.i("#3:"+val));
    source.subscribe(val -> Log.i("#4:"+val));
    source.subscribe(val -> Log.i("#5:"+val));

    CommonUtils.exampleComplete();
  }

  private static Observable<String> getObservable(){
    if(colors.hasNext()){
      Integer color = colors.next();
      return Observable.just("BAll-" +color,"RECT-"+color,"PENTA-"+color);
    }
    return Observable.empty();
  }
}
