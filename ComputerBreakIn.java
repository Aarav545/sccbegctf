import java.util.*;

class ComputerBreakIn {
    public static void main(String args[]) {
        ComputerBreakIn Breaks = new ComputerBreakIn();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter computer password: ");
        String userInput = scanner.next();
	String input = userInput.substring("ctf{".length(),userInput.length()-1);
	if (Breaks.checkPassword(input)) {
	    System.out.println("Access granted.");
	} else {
	    System.out.println("Access denied!");
        }
    }

    // Hint: The myBytes array is full of different encodings
    public boolean checkPassword(String password) {
        byte[] passBytes = password.getBytes();
        byte[] myBytes = {
            106 , 85  , 53  , 116 , 95  , 52  , 95  , 98  ,
            0x55, 0x6e, 0x43, 0x68, 0x5f, 0x30, 0x66, 0x5f,
            0142, 0131, 0164, 063 , 0163, 0137, 062 , 066 ,
            '7' , 'e' , '0' , '3' , 'd' , '1' , '1' , '6' ,
        };
        for (int i=0; i<32; i++) {
            if (passBytes[i] != myBytes[i]) {
                return false;
            }
        }
        return true;
    }
}
