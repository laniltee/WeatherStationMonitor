/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VMARALA
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.*;

public class MonitorCLI {
    
    public static void main(String[] args) {
        
        try {
            BufferedReader keyInput = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter Server Host: ");
            String serverHost = keyInput.readLine();
            
            Weatherable weatherService = (Weatherable) Naming.lookup("rmi://" + serverHost + ":1099/weatherservice");
            System.out.println("Connected To Weather Service");
            
            while(true){
                System.out.print("Enter Location: ");
                String reqLocation = keyInput.readLine();
                System.out.print("Enter Sensor: ");
                String reqSensor = keyInput.readLine();
                
                System.out.println("Current Weather: " + weatherService.getCurrentReading(reqLocation, reqSensor));
            }
            
        } catch (IOException | NotBoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
