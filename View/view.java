package View;

import java.util.concurrent.Semaphore;
import Controller.controller;

public class view {
	public static void main(String[] args) {
		int permissao1 = 1;
		Semaphore semaforo = new Semaphore(permissao1);

		for (int cavaleiro = 0; cavaleiro < 4; cavaleiro++) {
			Thread Tcavaleiro = new controller(cavaleiro, semaforo);
			Tcavaleiro.start();
		}
	}

}
