package computer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import api.Computer;
import api.Task;

public class ComputerImpl extends UnicastRemoteObject implements Computer {

	protected ComputerImpl() throws RemoteException {
		super();
	}

	@Override
	public Object execute(Task task) throws RemoteException {
		return null;
	}

}
