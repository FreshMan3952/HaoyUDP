import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class HaoyServer {
    private int port;
    private boolean running;
    private Thread serverThread;
    private Thread clientDropHandlerThread;
    private DatagramSocket datagramSocket;


    //constructor
    public HaoyServer(int port) throws SocketException {
        this.port = port;
        this.datagramSocket = new DatagramSocket(port);
        this.initServerThread();
        this.initClientDropHandler();
    }
    //what the server does when it starts
    public void start() {
        if (!this.running) {
            running = true;
            serverThread.start();
            clientDropHandlerThread.start();
            System.out.println("[RUDPServer] Server started on UDP port " + this.port);
        }
    }
    //things to be done inside of initServerThread
    private void initServerThread(){
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){
                    byte [] buffer = new byte[Constants.RECEIVE_MAX_SIZE];
                    DatagramPacket dataPacket = new DatagramPacket(buffer,buffer.length);
                    try {
                        datagramSocket.receive(dataPacket);
                    } catch (IOException e) {
                        System.err.println("server having trouble receiving a packet");
                        e.printStackTrace();
                    }
                    byte[] data = new byte[dataPacket.getLength()];

                    System.arraycopy(dataPacket.getData(), dataPacket.getOffset(), data, 0, dataPacket.getLength());

                    handlePacket(data, datagramPacket.getAddress(), datagramPacket.getPort());

                    dataPacket.setLength(Constants.RECEIVE_MAX_SIZE);

                }
            }
        });
    }
    //things to be done inside of ClientDropHandler
    private void initClientDropHandler(){
        serverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){

                }
            }
        });
    }

}
