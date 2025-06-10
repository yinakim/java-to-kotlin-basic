package lec02;

public class Lec02Main {

  public static void main(String[] args) {

  }

  // 1. null일 경우 exception 발생
  public boolean startsWithA1(String str) {
    if (str == null) {
      throw new IllegalArgumentException("null이 들어왔습니다");
    }
    return str.startsWith("A");
  }

  // 2. null일 경우 null 리턴
  public Boolean startsWithA2(String str) {
    if (str == null) {
      return null;
    }
    return str.startsWith("A");
  }

  // 3. null일 경우 false 리턴
  public boolean startsWithA3(String str) {
    if (str == null) {
      return false;
    }
    return str.startsWith("A");
  }

}
