package api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Computer<T> extends Remote {
	
	public static String PORT = "1099";
	public static String SERVICE_NAME = "SERVICE";
	
	public <T> T execute(Task<T> task) throws RemoteException;

}
