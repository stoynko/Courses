package Projects.Zookeeper;

public class _01_Rush_Into_Print {

/*Description:
There are many animals in the zoo, and all of them need care. The animals must be fed, cleaned, surrounded by their kin, and kept happy.
That is a difficult task for our large zoo, so one of your employers has suggested a more convenient way to keep track of everything.
She wants to be able to pull up a video feed of any animal in the zoo with the help of a program.
Being able to check on each habitat would help the zookeepers take care of our furry friends more efficiently!

In this project, you will create a program that helps the zookeepers check on the animals and make sure that they're doing well.
Your product will be able to process commands from the zookeepers and display the animals on a monitor.

Objectives:
    • To begin with, you will develop a simple printer. Your program should display the text from the output example. */

    public static void main(String[] args) {

        System.out.println("I love animals!");
        System.out.println("Let's check on the animals...");
        System.out.println("The deer looks fine.");
        System.out.println("The bat looks happy.");
        System.out.println("The lion looks healthy.");
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