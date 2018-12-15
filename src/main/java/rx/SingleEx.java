package rx;


import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleEx {

  public static void main(String[] args) {
    Observable<String> source = Observable.just("Hello Single1");
    Single.fromObservable(source).subscribe(System.out::println);

    Observable.just("Hello single2").single("default item").subscribe(System.out::println);

    String[] colors = {"red", "blue", "gold"};
    Observable.fromArray(colors).first("default value").subscribe(System.out::println);

    Observable.empty().single("default value").subscribe(System.out::println);

    Observable.just(1,2,3,4,5).take(1).single(0).subscribe(System.out::println);

  }

}
