package Projects.Zookeeper;

public class _02_Show_Me_An_Animal {

/* Description:
One of the most important parts of working with animals is keeping an eye on them.
We need to see the animals on the screen to know how they are doing, right?
Now we are ready to print something awesome: an image of an animal!

Objectives:
    • For the second stage, you will need to develop an animal printer.
      Your program should display the animal identified in the code field. */

    public static void main(String[] args) {
        printCamel();
    }

    private static void printCamel() {
        String camel = """
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
        System.out.println(camel);
    }
}
