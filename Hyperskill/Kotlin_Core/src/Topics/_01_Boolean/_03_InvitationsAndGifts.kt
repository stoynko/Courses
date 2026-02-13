package Topics._01_Boolean

import java.util.*

/*Mr. Groundhog is throwing a party. He’s known for his pragmatism, so only those who bring a gift will be allowed to attend the party.
And, of course, a guest must have an invitation. Write a program that checks if a guest should be allowed at the party.
The program should read two booleans, each on a separate line:
    •	One showing whether the guest has an invitation.
    •	Another indicating if the guest brought a gift.

Print true if both conditions are met and false if not.*/

fun main() {

    val scanner = Scanner(System.`in`);
    val hasInvitation: Boolean = scanner.nextLine().toBoolean();
    val hasGift: Boolean = scanner.nextLine().toBoolean();

    println(hasInvitation && hasGift)
}