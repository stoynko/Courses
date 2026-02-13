package Topics._01_Boolean

import java.util.*

/*Write a program that reads three boolean variables x, y, and z (each on a separate line)
and then prints the result of the following logical expression: NOT(x AND y) OR (z).*/

fun main() {
    val scanner = Scanner(System.`in`);
    val varX = scanner.nextLine().toBoolean();
    val varY = scanner.nextLine().toBoolean();
    val varZ = scanner.nextLine().toBoolean();

    val result =  !(varX && varY) || varZ
    println(result)
}