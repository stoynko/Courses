package Projects.Zookeeper;

import java.util.Scanner;

public class _04_Set_The_Program {

/* Description:
Now it's time to make our project user-friendly. In this final stage, you'll make your software ready for the zoo staff to use.
Your program should understand the habitat numbers, show the animals, and be able to work continuously without having to be restarted.

Objectives:
    Your tasks at this point:
        • Your program should repeat the behavior from the previous stage, but now in a loop.
        • Do not forget to include an exit opportunity: inputting exit should end the program.
        • When the program is done running, it should print: See you later! */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of the habitat you would like to view:");
        String input = scanner.nextLine();
        while (!"exit".equals(input)) {

            int option = Integer.parseInt(input);
            switch (option) {
                case 0 -> System.out.println(camel());
                case 1 -> System.out.println(lion());
                case 2 -> System.out.println(deer());
                case 3 -> System.out.println(goose());
                case 4 -> System.out.println(bat());
                case 5 -> System.out.println(rabbit());
            }
            System.out.println("Please enter the number of the habitat you would like to view:");
            input = scanner.nextLine();
        }
        System.out.println("See you later!");
    }

    public static String camel() {
        return """
                Switching on the camera in the camel habitat...
                 ___.-''''-.
                /___  @    |
                ',,,,.     |         _.'''''''._
                     '     |        /           \\
                     |     \\    _.-'             \\
                     |      '.-'                  '-.
                     |                               ',
                     |                                '',
                      ',,-,                           ':;
                           ',,| ;,,                 ,' ;;
                              ! ; !'',,,',',,,,'!  ;   ;:
                             : ;  ! !       ! ! ;  ;   :;
                             ; ;   ! !      ! !  ; ;   ;,
                            ; ;    ! !     ! !   ; ;
                            ; ;    ! !    ! !     ; ;
                           ;,,      !,!   !,!     ;,;
                           /_I      L_I   L_I     /_I
                Look at that! Our little camel is sunbathing!""";
    }

    public static String lion() {
        return """
                Switching on the camera in the lion habitat...
                                                               ,w.
                                                             ,YWMMw  ,M  ,
                                        _.---.._   __..---._.'MMMMMw,wMWmW,
                                   _.-""        '''           YP"WMMMMMMMMMb,
                                .-' __.'                   .'     MMMMW^WMMMM;
                    _,        .'.-'"; `,       /`     .--""      :MMM[==MWMW^;
                 ,mM^"     ,-'.'   /   ;      ;      /   ,       MMMMb_wMW"  @\\
                ,MM:.    .'.-'   .'     ;     `\\    ;     `,     MMMMMMMW `"=./`-,
                WMMm__,-'.'     /      _.\\      F'''-+,,   ;_,_.dMMMMMMMM[,_ / `=_}
                "^MP__.-'    ,-' _.--""   `-,   ;       \\  ; ;MMMMMMMMMMW^``; __|
                           /   .'            ; ;         )  )`{  \\ `"^W^`,   \\  :
                          /  .'             /  (       .'  /     Ww._     `.  `"
                         /  Y,              `,  `-,=,_{   ;      MMMP`""-,  `-._.-,
                        (--, )                `,_ / `) \\/"")      ^"      `-, -;"\\:
                The lion is roaring!""";
    }

    public static String deer() {
        return """
                Switching on the camera in the deer habitat...
                   /|       |\\
                `__\\       //__'
                   ||      ||
                 \\__`\\     |'__/
                   `_\\   //_'
                   _.,:---;,._
                   \\_:     :_/
                     |@. .@|
                     |     |
                     ,\\.-./ \\
                     ;;`-'   `---__________-----.-.
                     ;;;                         \\_\\
                     ';;;                         |
                      ;    |                      ;
                       \\   \\     \\        |      /
                        \\_, \\    /        \\     |\\
                          |';|  |,,,,,,,,/ \\    \\ \\_
                          |  |  |           \\   /   |
                          \\  \\  |           |  / \\  |
                           | || |           | |   | |
                           | || |           | |   | |
                           | || |           | |   | |
                           |_||_|           |_|   |_|
                          /_//_/           /_/   /_/
                Our 'Bambi' looks hungry. Let's go to feed it!""";
    }

    public static String goose() {
        return """
                Switching on the camera in the goose habitat...
                
                                                    _
                                                ,-"" "".
                                              ,'  ____  `.
                                            ,'  ,'    `.  `._
                   (`.         _..--.._   ,'  ,'        \\    \\
                  (`-.\\    .-""        ""'   /          (  d _b
                 (`._  `-"" ,._             (            `-(   \\
                 <_  `     (  <`<            \\              `-._\\
                  <`-       (__< <           :
                   (__        (_<_<          ;
                    `------------------------------------------
                The goose is staring intently at you... Maybe it's time to change the channel?""";
    }

    public static String bat() {
        return """
                Switching on the camera in the bat habitat...
                _________________               _________________
                 ~-.              \\  |\\___/|  /              .-~
                     ~-.           \\ / o o \\ /           .-~
                        >           \\  W  //           <
                       /             /~---~\\             \\
                      /_            |       |            _\\
                         ~-.        |       |        .-~
                            ;        \\     /        i
                           /___      /\\   /\\      ___\\
                                ~-. /  \\_/  \\ .-~
                                   V         V
                This bat looks like it's doing fine.""";
    }

    public static String rabbit() {
        return """
                Switching on the camera in the rabbit habitat...
                         ,
                        /|      __
                       / |   ,-~ /
                      Y :|  //  /
                      | jj /( .^
                      >-"~"-v"
                     /       Y
                    jo  o    |
                   ( ~T~     j
                    >._-' _./
                   /   "~"  |
                  Y     _,  |
                 /| ;-"~ _  l
                / l/ ,-"~    \\
                \\//\\/      .- \\
                 Y        /    Y
                 l       I     !
                 ]\\      _\\    /"\\
                (" ~----( ~   Y.  )
                It looks like we will soon have more rabbits!""";
    }
}
