package rx.subject;

import io.reactivex.functions.Consumer;

public class Print implements Consumer<Integer> {

  private String name;

  public Print(String name) {
    this.name = name;
  }

  @Override
  public void accept(Integer data) {
    System.out.println(name + " => " + data);
  }
}