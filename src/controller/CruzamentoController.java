package controller;

import java.util.concurrent.Semaphore;

public class CruzamentoController extends Thread {

	private int sentido;
	private Semaphore semaforo;

	public CruzamentoController(int sentido, Semaphore semaforo) {
		this.sentido = sentido;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			Andar();
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			semaforo.release();
		}
	}

	private void Andar() {
		switch (sentido) {
		case 0:
			System.out.println("O carro verde #" + sentido + " fez o cruzamento andando para direita. \n");
			break;
		case 1:
			System.out.println("O carro vermelho #" + sentido + " fez o cruzamento descendo a rua. \n");
			break;
		case 2:
			System.out.println("O carro azul #" + sentido + " fez o cruzamento seguinte pela esquerda. \n");
			break;
		case 3:
			System.out.println("O carro amarelo #" + sentido + " fez o cruzamento subindo a rua. \n");
			break;
		default:
			break;
		}
	}

}
