package rx.subject;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectEx {

  public static void main(String[] args) {
    ReplaySubject<Integer> subject = ReplaySubject.create();
    subject.subscribe(new Print("#1"));
    subject.onNext(1);
    subject.onNext(3);
    subject.subscribe(new Print("#2"));
    subject.onNext(5);
    subject.subscribe(new Print("#3"));
    subject.onComplete();
    subject.subscribe(new Print("#4"));
  }
}
