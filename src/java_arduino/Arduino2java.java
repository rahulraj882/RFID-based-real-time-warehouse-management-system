package java_arduino;
import Database.RetriveData;
import arduino.Arduino;
import java.io.*;
import gnu.io.*;
import java.util.*;
import rfid_based_smartshoppingsystem.AddItem;
import rfid_based_smartshoppingsystem.UserSideInterface;

/*
 * line:76 -> Check the your COM port of arduino connected to Arduino with RC522 module and enter here appropriate
    one in place of "COM3" in System.setProperty("gnu.io.rxtx.SerialPorts", "COM3");
 *
 */


public class Arduino2java implements SerialPortEventListener {
        AddItem add=new AddItem();
        UserSideInterface n=new UserSideInterface();
        boolean choice;
        
        public Arduino2java(){
            choice=true;
        }
        public Arduino2java(int a){
            choice=false;
        }
        SerialPort serialPort;
        String inputLine;
        
        private String uname;
        
        public void setUname(String s){
            uname=s;
        }
        
        /** The port we're normally going to use. */
	private static final String PORT_NAMES[]= { 
			"/dev/tty.usbserial-A9007UX1", // Mac OS X
                        "/dev/ttyACM0", // Raspberry Pi
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	/**
	* A BufferedReader which will be fed by a InputStreamReader 
	* converting the bytes into characters 
	* making the displayed results codepage independent
	*/
    private boolean c=true;
    String row[]=new String[3];

    public static boolean i=true;
    
    boolean bool=false;
    private int count=1;
   //private javax.swing.JTable Table;
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;

    public void selection(){
        if(choice==true){
            n.setUname(uname);
            n.setVisible(true);
            }else if(choice==false){
                add.setVisible(true);
            }
    }
    
    
    public void initialize() {
            System.setProperty("gnu.io.rxtx.SerialPorts", "COM3");
        
            selection();
            
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

            while (portEnum.hasMoreElements()) {
                    CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

                    for (String portName : PORT_NAMES) {
                            if (currPortId.getName().equals(portName)) {
                                    portId = currPortId;
                                    break;
                            }
                    }
            }

            if (portId == null) {
                    System.out.println("Could not find COM port.");
                    System.exit(0);
            }

            try {
                    // open serial port, and use class name for the appName.
                    serialPort = (SerialPort) portId.open(this.getClass().getName(),
                                    TIME_OUT);

                    // set port parameters
                    serialPort.setSerialPortParams(DATA_RATE,
                                    SerialPort.DATABITS_8,
                                    SerialPort.STOPBITS_1,
                                    SerialPort.PARITY_NONE);

                    // open the streams
                    input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                    output=serialPort.getOutputStream();
                    serialPort.addEventListener(this);
                    serialPort.notifyOnDataAvailable(true);
            } catch (Exception e) {
                    System.err.println(e.toString());
            }
    }

    public synchronized void close() {
        if (serialPort != null) {
                serialPort.removeEventListener();
                serialPort.close();
        }else{

        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
            if ( oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                    try {
                            row[0]="";
                            row[1]="";
                            row[2]="";

                            inputLine=input.readLine();
                            System.out.println(inputLine);
                            if(choice==true){
                              if(new RetriveData().rfidFound(inputLine)){
                                    String [] s=new RetriveData().retriveRfid(inputLine);
                                    row[0]=Integer.toString(count);
                                    row[1]=s[1];
                                    row[2]=s[2];
                                    //System.out.println(row[0]+" "+row[1]+" "+row[2]);
                                    n.setList(row);
                                    count++;

                                }
                                
                            }else if(choice==false){
                                add.setUid(inputLine);
                            }
                    } catch (Exception e) {
                            //System.err.println(e.toString());
                    }

            }   else{
        try {
            serialPort.close();
            input.close();
    } catch (IOException ex) {
            //Logger.getLogger(Arduino2java.class.getName()).log(Level.SEVERE, null, ex);
        }
            }

    }

    public void call(){
        Arduino2java main = new Arduino2java ();
        if(i==true){
            main.initialize();
            i=false;
        }else{
            if(choice==true){
            n.setUname(uname);
            n.setVisible(true);
            }else if(choice==false){
                add.setVisible(true);
            }
        }
        Thread t=new Thread() {
                public void run() {

                    try {Thread.sleep(1000000);} catch (InterruptedException ie) {}

                }
        };
        t.start();
        System.out.println("Started");
    } 

    /*public static void main(String[] args) throws Exception {

        Arduino2java con=new Arduino2java();
        con.call();

    }*/

}
