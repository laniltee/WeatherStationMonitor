
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license heasder, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author VMARALA
 */
public class MonitorProxy extends UnicastRemoteObject implements Monitorable {
    
    private MonitorUI parentInterface;

    public MonitorProxy() throws RemoteException{
        super();
    }
    
    @Override
    public void monitorWarning(String location, String sensor, String timestamp, float reading) throws RemoteException {
        //parentInterface.showAlert("Weather Alert ! ! !");
        parentInterface.addAlert(location, sensor, timestamp, reading);
    }
    
    public void registerInterface(MonitorUI m){
        parentInterface = m;
        parentInterface.showAlert("Interface Binded to the proxy");
    }

}
