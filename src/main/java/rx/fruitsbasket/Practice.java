package rx.fruitsbasket;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import rx.common.Log;

public class Practice {

  public static void main(String[] args) throws InterruptedException {
    final List<String> basket1 = Arrays
        .asList(new String[]{"kiwi", "orange", "lemon", "orange", "lemon", "kiwi"});
    final List<String> basket2 = Arrays.asList(new String[]{"banana", "lemon", "lemon", "kiwi"});
    final List<String> basket3 = Arrays
        .asList(new String[]{"strawberry", "orange", "lemon", "grape", "strawberry"});
    final List<List<String>> baskets = Arrays.asList(basket1, basket2, basket3);
    final Observable<List<String>> basketPublisher = Observable.fromIterable(baskets);

    CountDownLatch countDownLatch = new CountDownLatch(1);

    basketPublisher.concatMap(basket -> {
      Observable<List<String>> distinctFruits = Observable.fromIterable(basket).doOnNext(x -> Log.it(x)).distinct().toList().toObservable().subscribeOn(
          Schedulers.computation());
      Observable<Map<String, Long>> fruitsMap = Observable.fromIterable(basket).doOnNext(x -> Log.it(x))
          .groupBy(fruit -> fruit)
//          .doOnNext(x -> System.out.println(x.getKey() + " : " + x.blockingIterable().toString()));
          .concatMap(group ->
              group.count().toObservable().map(count -> {
                Map<String, Long> fruitCount = new LinkedHashMap<>();
                fruitCount.put(group.getKey(), count);
                return fruitCount;
              })
          ).reduce((accMap, currentMap) -> new LinkedHashMap<String, Long>() {{
            putAll(accMap);
            putAll(currentMap);
          }}).toObservable().subscribeOn(Schedulers.computation());
      return Observable.zip(distinctFruits, fruitsMap, FruitInfo::new);
    }).subscribe(System.out::println, error -> {
      System.err.println(error);
      countDownLatch.countDown();
    }, () -> {
      System.out.println("complete");
      countDownLatch.countDown();
    });


    countDownLatch.await();
  }

}
