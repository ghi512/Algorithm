import java.util.Scanner;

public class Main {

  private int max; // 스택의 용량
  private int ptr; // 스택 포인터
  private char[] stk; // 스택의 본체

  public class EmptyInStackException extends RuntimeException { // 스택이 비어있을 경우 에러 발생
    public EmptyInStackException() {}
  }
  public class OverflowIntStackException extends RuntimeException{ // 스택이 꽉 착을 때 에러 발생 -> 넘침
    public OverflowIntStackException() {}
  }
  public Main(int capacity) { // 생성자. 매개변수로 스택의 용량을 줌
    ptr = 0; // 스택 포인터는 스택의 바닥을 가리키고 있음
    max = capacity;
    try {
      stk = new char[max];
    } catch (OutOfMemoryError e) {
      max = 0;
    }
  }

  // 스택에 x를 push
  public char push(char x) throws Main.OverflowIntStackException {
    if (ptr >= max) // 스택이 가득차있으면
      throw new Main.OverflowIntStackException();
    return stk[ptr++] = x;
  }

  // 스택에서 데이터를 pop -> 데이터를 꺼내서 버림
  public char pop() throws Main.EmptyInStackException {
    if(ptr <= 0) // 스택이 빈 경우 pop할 데이터가 없으므로
      throw new Main.EmptyInStackException();
    return stk[ptr--];
  }

  // 스택에서 데이터를 peak -> 데이터를 꺼내서 확인
  public char peak() throws Main.EmptyInStackException {
    if(ptr <= 0) {
      throw new Main.EmptyInStackException();
    }
    return stk[ptr -1];
  }

  // 스택을 비움
  public void clear() {
    ptr = 0;
  }

  // 스택에서 x를 찾아 인덱스 반환
  public int indexOf(int key) {
    for(int i=ptr-1; i>=0; i--) { // 꼭대기부터 선형 검색
      if(stk[i] == key) // 검색 성공
        return i;
    }
    return -1; // 검색 실패
  }

  // 스택의 용량을 반환
  public int getCapacity() { // max는 private한 변수이므로 max값을 얻기 위한 함수 이용
    return max;
  }

  // 스택에 쌓여있는 데이터 개수 반환
  public int size() {
    return ptr;
  }

  // 스택이 비어 있는가?
  public boolean isEmpty() {
    return ptr <= 0;
  }

  // 스택이 가득 찼는가?
  public boolean isFull() {
    return ptr >= max;
  }

  // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
  public void dump() {
    if (ptr <= 0) {
      System.out.println("스택이 비어있습니다.");
    }
    else {
      for (int i = 0; i < ptr; i++) {
        System.out.println(stk[i]);
      }
      System.out.println();
    }
  }

  public static String result(String s) {
    Main stack = new Main(50);

    int len = s.length(); // s 문자열의 길이
    for(int i=0; i<len; i++) {
      char ch = s.charAt(i); // s 문자열의 i번째 문자
      // 여는 괄호 입력 - push
      if(ch == '(') {
        stack.push(ch);
      }
      // 닫는 괄호 입력 - 스택인 빈 경우 "NO" 리턴
      else if (stack.isEmpty()) {
        return "NO";
      }
      // 닫는 괄호 입력 - 스택에 '('가 있는 경우 pop
      else {
        stack.pop();
      }
    }
    // 검사를 마치고 잔여 요소 검사
    if(stack.isEmpty()) {
      return "YES";
    }
    else {
      return "NO";
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    scanner.nextLine(); // 개행문자 제거

    // 문자열 입력
    String[] input = new String[n];
    for(int i=0; i<n; i++) {
     input[i] = scanner.nextLine();
    }

    // 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO” 출력
    for(int i=0; i<n; i++) {
      System.out.println(result(input[i]));
    }

  }
}
