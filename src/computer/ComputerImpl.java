package computer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import api.Computer;
import api.Task;

public class ComputerImpl extends UnicastRemoteObject implements Computer {

	protected ComputerImpl() throws RemoteException {
		super();
	}

	@Override
	public <T> T execute(Task<T> task) throws RemoteException {
		return task.call();
	}
	
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		LocateRegistry.createRegistry( Computer.PORT ).rebind(Computer.SERVICE_NAME,(Computer) new ComputerImpl());
	}

}
