package rx.operator;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.Scanner;
import rx.common.Log;

public class MultiplicationTableEx {

  public static void main(String[] args) throws InterruptedException {
    int x = 3;
    BiFunction<Integer, Integer, String> biFunction = (dan, multi) -> dan + " * " + multi + " = "
        + dan * multi;
    Function<Integer, String> function = (multi) -> biFunction.apply(x, multi);
//    Observable.interval(1l, TimeUnit.SECONDS).map(Long::intValue).skip(1).take(9).map(function).subscribe(Log::i);
//    TimeUnit.SECONDS.sleep(12L);
//    Observable.range(1,9).map(function).subscribe(Log::i);
//    step2();
    step3();
  }

  private static void step2() {
    int t = 3;
    Function<Integer, Observable<String>> f = dan -> Observable.range(1, 9)
        .map(multi -> dan + " * " + multi + " = " + dan * multi);
    Observable.just(t).flatMap(f).subscribe(Log::i);
  }

  private static void step3() {
    int dan = 3;
    Observable.just(dan)
        .flatMap(gugu -> Observable.range(1, 9), (gugu, i) -> gugu + "*" + i + "=" + gugu * i)
        .subscribe(Log::i);
  }


  private void oldWay() {
    Scanner in = new Scanner(System.in);
    System.out.println("Gugudan Input:");
    int dan = Integer.parseInt(in.nextLine());
    for (int row = 1; row <= 9; ++row) {
      System.out.println(dan + " * " + row + " = " + dan * row);
    }
    in.close();
  }

}
