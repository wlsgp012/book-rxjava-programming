package rx.subject;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectEx {

  public static void main(String[] args) {
    AsyncSubject<String> subject = AsyncSubject.create();
    subject.subscribe(data -> System.out.println("Subscriber #1 => "+ data));
    subject.onNext("1");
    subject.onNext("3");
    subject.subscribe(data -> System.out.println("Subscriber #2 => "+ data));
    subject.onNext("5");
    subject.onComplete();


    Float[] temp = {10.1f, 13.4f, 12.5f};
    Observable<Float> source = Observable.fromArray(temp);
    AsyncSubject<Float> subject1 = AsyncSubject.create();
    subject1.subscribe(data -> System.out.println("as Subscriber => "+ data));
    source.subscribe(subject1);

  }
}
