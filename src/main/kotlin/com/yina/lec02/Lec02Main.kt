package com.yina.lec02

import lec02.Person

fun main(){

    // safe call
    val str: String? = "ABC"
    // println(str.length) // 불가능 - Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    println(str?.length) //  가능

    // Elvis 연산자
    str?.length ?: 0 // str.length가 safe call로 null인 경우 뒤의 값인 0을 사용  (early return 할때도 사용)

    // println("null이 아님을 단언 !!")
    // notnullEver(null)

    val person = Person("김이나") // java 코드를 가져다 쓰는 경우 - @Nullable등 null 어노테이션 있는 경우
    startWithA(person.name) // 코틀린 함수 선언시 notnull로 선언되었는데 @Nullable 호출하는 경우 - Type mismatch: inferred type is String? but String was expected

    // 플랫폼타입 - @Nullable, @NotNull등 없어서 컴파일러가 null에 대한 판단을 할 수 없는 경우 -> 실행시 NPE 발생
    val platformTypePerson = Person(null)
    startWithA(platformTypePerson.name)
}


/**
 * [1] kotlin에서의 기본 null체크
 */
// 1. null일 경우 exception 발생
fun startsWithA1(str: String?) : Boolean { // String? - null 이 들어올 수 있음을 명시
    if(str == null) throw IllegalArgumentException("null이 들어왔습니다")
    return str.startsWith("A")
}

// 2. null일 경우 null 리턴
fun startsWithA2(str: String?) : Boolean?{ // Boolean? - null을 반환할 수 있음을 명시
    if (str == null) return null
    return str.startsWith("A")
}

// 3. null일 경우 false 리턴
fun startsWithA3(str: String?) : Boolean {
    if (str == null) return false
    return str.startsWith("A")
}

/**
 * [2] Safe Call / Elvis 연산자를 사용해서 더 코틀린스럽게 작성하기
 * */
// 좀 더 코틀린스럽게 - safe call & Elvis 연산자 사용
fun startsWithA1_refactor(str: String?) : Boolean {
    return str?.startsWith("A") // safe call
        ?: throw IllegalArgumentException("null이 들어왔습니다") // elvis
}

// 좀 더 코틀린스럽게 - safe call 사용, null인 경우 바로 null로 리턴
fun startsWithA2_refactor(str: String?) : Boolean?{
    return str?.startsWith("A")
}

// 좀 더 코틀린스럽게 - safe call & Elvis 연산자 사용, null인 경우 false 리턴
fun startsWithA3_refactor(str: String?) : Boolean{
    return str?.startsWith("A") ?: false
}

/**
 * [3] null 이 아님을 단언하는 방법
 */
fun notnullEver(str: String?) : Boolean{ // nullable 변수를 받도록 되어있으나, 함수 내부 로직에서 null이 안된다는것을 명시
    return str!!.startsWith("A") // null들어오면 NPE 발생
}

/**
 * [4] 플랫폼타입확인용
  */
fun startWithA(str: String) : Boolean {
    return str.startsWith("A")
}
