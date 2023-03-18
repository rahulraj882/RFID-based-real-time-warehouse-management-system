package java_arduino;
import arduino.Arduino;
import javafx.stage.Stage;
//import arduino.*;

/*
 * To be changed before ruuning
 * line:14 -> Check the your COM port of arduino connected to Arduino with LED's and enter here appropriate
    one in place of "COM4" in Arduino("COM4", 9600);
 */

public class Java2arduino {

    // create connection to adruino, check the com port in adruino IDE and paste it instead "COM8"
    static Arduino AdruinoCon = new Arduino("COM4", 9600);
    private int flag;
    public Java2arduino(int a) {
        flag = a;
    }

    //private boolean isOn = false; // state of the led
    char[] commands = {'1', '2', '3'}; // commands that adruino can recognize
    // JavaFX main function containing the logic

    public void call() {

        AdruinoCon.serialWrite(commands[flag - 1]); // flag=1 -> choice=1 ; flag=2 -> choice=2 ; flag=3 -> choice=3  

    }

    public void J2A() throws InterruptedException {
        AdruinoCon.openConnection();
            call();
        //launch(args);
    }

    /*public static void main(String[] args) throws InterruptedException {
        new Java2arduino(1).J2A(args);
    }*/

}
