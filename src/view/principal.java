package view;

import java.util.concurrent.Semaphore;

import controller.CruzamentoController;

public class principal {
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for (int id = 0; id < 5; id++) {
			Thread t = new CruzamentoController(id, semaforo);
			t.start();
		}
		
	}
}

