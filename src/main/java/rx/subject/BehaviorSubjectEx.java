package rx.subject;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectEx {

  public static void main(String[] args) {
    BehaviorSubject<Integer> subject = BehaviorSubject.createDefault(6);
    subject.subscribe(new Print("#1"));
    subject.onNext(1);
    subject.onNext(3);
    subject.subscribe(new Print("#2"));
    subject.onNext(5);
    subject.onComplete();
    subject.onNext(99);
  }

}
