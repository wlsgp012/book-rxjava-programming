package rx.operator;


import io.reactivex.Observable;

public class GroupByEx {

  public static void main(String[] args) {
    String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
    Observable.fromArray(objs).groupBy(GroupByEx::getShape).subscribe(obj ->{
      obj.subscribe(val -> System.out.println("GROUP:"+obj.getKey()+ "\t Value:"+val));
    });
  }

  public static String getShape(String obj){
    if(obj.endsWith("-T")){
      return "Triangle";
    }
    return "Ball";
  }

}
