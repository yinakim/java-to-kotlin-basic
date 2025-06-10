package com.yina.lec01

import com.lannstark.lec01.Person

fun Lec01Main() {
    var number1 = 10L // (1) 가변
    val number2 = 10L // (2) 불변 final

    // 초기화 하지 않고 선언만 하려면 타입명시해야 에러 없음
    var unInitNumber: Long
    unInitNumber = 10L

    /** 코드를 깔끔하게 작성하려면 모든변수는 우선 val로 작성, 필요시 var로 변경하는것을 권장 */

    // Java에서 (1) primitive type vs (3) reference type - 연산할 때 primitive 사용권장인데
    // kotlin은 Long 타입이라도 알아서 연산시 내부적으로 long으로 언박싱해서 처리한다.

    var nullableNum : Long? // nullable은 타입? 으로 명시

    var person = Person("김이나") // 객체 생성 시 new 키워드 사용하지 않음
}