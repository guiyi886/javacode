package javaLow.实验六.second;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HttpDownloadService extends Remote {
    String downloadHtml(String url) throws RemoteException;
}
