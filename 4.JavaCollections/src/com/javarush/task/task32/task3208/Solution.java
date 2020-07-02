package com.javarush.task.task32.task3208;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
//            Cat cat = new Cat("Molli");
//            Dog dog = new Dog("Spike");
            try {
                registry = LocateRegistry.createRegistry(2099);
                Cat cat = new Cat("Molli");
                Dog dog = new Dog("Spike");
                Remote catStub = UnicastRemoteObject.exportObject(cat, 0);
                Remote dogStub = UnicastRemoteObject.exportObject(dog, 1);
                registry.bind("catBindingName", catStub);
                registry.bind("DogBindingName", dogStub);
            } catch (RemoteException | AlreadyBoundException e) {
                System.err.println(e);
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.err.println(e);
//            }
//            try {
//                UnicastRemoteObject.unexportObject(cat, true);
//                UnicastRemoteObject.unexportObject(dog, true);
//            } catch (NoSuchObjectException e) {
//                System.err.println(e);
//            }

            //напишите тут ваш код
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1500);
        // Start the client
        CLIENT_THREAD.start();
    }
}