package Topics._01_Boolean

import java.util.*

/*A boolean value is either true or false. Given an integer value, determine if it is 'truthy' or 'falsy' according to these rules:
0 is 'falsy', and any other value is 'truthy'. Read an integer value from standard input and print 'true' if it is truthy,
or 'false' if it is falsy. */

fun main(){

    val scanner = Scanner(System.`in`);
    val number = scanner.nextLine().toInt()
    val result: Boolean

    result = number != 0

    println(result)
}
