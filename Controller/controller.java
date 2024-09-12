package Controller;

import java.util.concurrent.Semaphore;

public class controller extends Thread {
	private int cavaleiro;
	private static boolean tocha = true;
	private static boolean pedraBrilhante = true;
	private static int porta;
	private int corredor;
	int deslocamento = (int) ((Math.random() * 2) + 2);
	private Semaphore semaforo;

	public controller(int cavaleiro, Semaphore semaforo) {
		this.cavaleiro = cavaleiro;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		cavaleiroAndando();
		// -----------seção critica----------
		try {
			semaforo.acquire();
			cavaleiroTocha();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

		try {
			semaforo.acquire();
			cavaleiroPedra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		// -----------seção critica----------
		corredor = 2000;
	}

	public void cavaleiroAndando() {
		int distanciaTotal = 2000;
		int distanciaPercorrida = 0;
		int tempo = 0;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + cavaleiro + " já andou " + distanciaPercorrida + "m");
		}
		porta++;
		System.out.println("#" + cavaleiro + " foi o " + porta + " a chegar!");

	}

	public void cavaleiroTocha() {
//erro no semaforo
		if (tocha = true) {
			deslocamento = deslocamento + 2;
			int distanciaTotal = 2000;
			int distanciaPercorrida = 0;
			int tempo = 0;
			for (tempo = 0; tempo<50; tempo++) {
			}
			deslocamento = deslocamento - 2;
			while (distanciaPercorrida < distanciaTotal) {
				distanciaPercorrida += deslocamento;
			}
			if (distanciaPercorrida >= 500) {
				tocha = false;
			}
			if (tocha = false) {
				deslocamento = deslocamento;
			}
		}
		System.out.println("#" + cavaleiro + " pegou a tocha");
	}

	public void cavaleiroPedra() {
//erro no semaforo
		if (pedraBrilhante = true) {
			deslocamento = deslocamento + 2;
			int distanciaTotal = 2000;
			int distanciaPercorrida = 0;
			int tempo = 0;
			for (tempo = 0; tempo<50; tempo++) {
			}
			deslocamento = deslocamento - 2;
			while (distanciaPercorrida < distanciaTotal) {
				distanciaPercorrida += deslocamento;
			}
			if (distanciaPercorrida == 1500) {
				pedraBrilhante = false;
			}
			if (pedraBrilhante = false) {
				deslocamento = deslocamento;
			}
		}
		System.out.println("#" + cavaleiro + " pegou a pedra brilhante");
	}
}