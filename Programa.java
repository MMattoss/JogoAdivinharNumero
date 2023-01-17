package programa;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Programa {
	public static void main(String[] args) {
		//Criando objetos das classes Random e Scanner
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		//Variáveis para gerar número aleatório, armazenar entrada do usuário, contar tentativas, jogar novamente e rodar o loop principal
		int randNum = rand.nextInt(11);
		int resp = 0;
		int tentativa = 1;
		int again = 0;
		boolean erro = false;
		
		//Início do jogo
		System.out.println("Bem vinde!");
		System.out.println("Adivinhe um número (0-10): ");
		
		//Loop principal
		do {		
			//Começo tratamento de erro
			try {				
				//Recebendo primeiro input
				resp = scan.nextInt();
				
				//Loop secundário que irá rodar as comparações da resposta
				while(true) {
					
					//Evitando que o usuário coloque números além do limite do jogo
					if(resp < 0 || resp > 10) {
						System.out.println("Por favor, apenas números de 0 a 10: ");
						resp = scan.nextInt();
					}
					
					
					else {
						//Usuário acertou a resposta
						if(resp == randNum) {
							System.out.println("Você acertou!");
							System.out.println("Número de tentativas: " + tentativa);
							System.out.println("Deseja jogar novamente? \n1. Sim  2.Não");
							again = scan.nextInt();
								//Condicional caso o usuário desejar jogar novamente
								if(again == 1) {
									randNum = rand.nextInt(10)+1;
									System.out.println("Adivinhe um número (1-10): ");
									resp = scan.nextInt();
									tentativa = 1;									
								}
								//Finalização do jogo
								else {
									System.out.println("Obrigado por jogar!");
									break;
								}
						}
						//Dica para se a resposta for maior que o número gerado
						else if(resp > randNum){
							System.out.println("Tente um número menor: ");
							resp = scan.nextInt();
							tentativa++;
						}
						//Dica para se a resposta for menor que o número gerado
						else {
							System.out.println("Tente um número maior: ");
							resp = scan.nextInt();
							tentativa++;
						}
					}					 
				}
			}
			//Tratamento de erro
			catch(InputMismatchException a){
				System.out.println("Apenas números por favor: ");
				erro = true;
				scan.nextLine();
				tentativa++;
			}
		}while(erro);
		scan.close();
	}
}