import java.util.Scanner;
import java.util.Random;

public class controlemest {

	/*static void resultados(int menor) {
		System.out.println("Menor valor gerado:"+menor);
	}*/

	
	
	public static void main (String[]args) {
		boolean menu = true, menu2 = true;
		int x=0,i=0,k=0,opc=0; //variaveis de controle e uso

		Scanner ent = new Scanner(System.in);
		Random numA = new Random();
		
		System.out.println("==== BEM VINDO ====");
		while (menu==true) {
			System.out.println("Sistema de geração e analise de numeros.");
			
			System.out.print("\n1-Iniciar sistema");
			System.out.print("\n2-Encerrar sistema");
			System.out.print("\n\nDigite a opção: ");
			opc = ent.nextInt();
			
			switch(opc) {
			case 1:
				while (menu2==true) {
					k=0;
					System.out.print("\n\nDigite uma quantidade de numeros a ser gerado: ");
					x = ent.nextInt();
					if(x<=0) {
						System.out.print("\nValor digitado Invalido! aperte <enter>");
						k=1;
						clearbuffer(ent);
						String b = ent.nextLine();
						System.out.println("\n\n\n\n\n\n\n\n\n\n");
					}
									
					if (k==0) {
						int[] y = new int[x];
						
						if (x>=1) {
							for (i=0; i<x; i++) {
								y[i] = numA.nextInt(5001);
								System.out.println(y[i]);
							}
						}

						//MAIOR E MENOR
						int menor=0,maior=0;
						int c=0;
						for(i=0;i<x;i++) {
							if (c==0) {
								maior = y[i];
								menor = y[i];
								c = 1;
								}
							if (c==1) {
								if (y[i]>maior) {
									maior = y[i];
								}
								if (y[i]<menor) {
									menor = y[i];
								}
							}	
						}	
						
						//PAR E IMPAR
						int par[] = new int[x];
						int impar[] = new int[x];
						for(i=0;i<x;i++){
							if(y[i]%2 == 0) {
								par[i] = y[i];
							}
							if(y[i]%2!=0) {
								impar[i] = y[i];
							}
						}
						
						//SOMA E MEDIA
						int soma=0;
						float media=0.0f;
						for (i=0;i<x;i++) {
							soma = y[i]+soma;
						}
						for (i=0;i<x;i++) {
							media =y[i]+media;
						}
						media = media/y.length;
						
						//EH PRIMO
						boolean o = true;
						int primo[] = new int[x];
						for (i=2;i<x;i++) {
							if(y[i]%i==0) {
								o=false;
							}
							if (o==true) {
								primo[i] = y[i];
							}
						}
						
						//MODA
						int moda=0,comp=0,vezes=0;
				        
						for(i=0;i<y.length;i++) {
				    	   vezes = 1;
				    	   for(int j = i+1;j<y.length;j++) {
				    		   if(y[i]==y[j]) {
				    			   ++vezes;
				    		   }
				    	   }
				    	   if(vezes>comp) {
				        	   moda = y[i];
				        	   comp = vezes;
				           }
				       }
						
						//MEDIANA
						int meio = y.length/2;
						int mediana;
						if (y.length%2 == 1) { 
							mediana = y[meio]; 
							} 
						else { 
							mediana= (int) ((int) (y[meio-1] + y[meio]) / 2.0); 
							} 
					
						//VARIANCIA
						float variancia;
						float fx1= 0.0f;
						
						for(i=0;i<y.length;i++) {
							fx1 += Math.pow(media-y[i],2)*2;
						}
						variancia = fx1/y.length;
						
						//DESVIO PADRAO
						double desvp = Math.sqrt(variancia);
						
						//RELATORIOS
						System.out.print("\n\n\nNumeros gerados: ");
						for(i=0;i<x;i++) {
							System.out.print(y[i]+", ");
						}
						
						System.out.print("\nMenor numero gerado: "+menor);
						System.out.print("\nMaior numero gerado: "+maior);
						System.out.print("Numeros pares gerados: ");
						for (i=0;i<x;i++) {
							if(par[i]!=0) {
								System.out.print(par[i]+", ");
							}
						}	
						System.out.print("\nNumeros impares gerados: ");
						for(i=0;i<x;i++) {
							if(impar[i]!=0) {
								System.out.print(impar[i]+", ");
							}
						}
						System.out.print("\nSoma dos numeros gerados: "+soma);
						System.out.print("\nMedia dos numeros gerados: "+media);
						System.out.print("\nNumeros primos gerados: ");
						for (i=0;i<x;i++) {
							if(primo[i]!=0) {
								System.out.print(primo[i]+", ");
							}
						}
						System.out.print("\nModa dos numeros gerados:"+moda);
						System.out.print("\nMediana: "+mediana);
						System.out.print("\nA variancia dos numeros gerados é: "+variancia);
						System.out.print("\nO desvio padrão dos numeros gerados é: "+desvp);
						
						//MENU2
						System.out.print("\n\nFim do processo! Deseja iniciar novamente?");
						System.out.print("\n1-SIM\n2-NÃO");
						System.out.print("\nEscolha: ");
						clearbuffer(ent);
						int opc2 = ent.nextInt();
						if(opc2==2) {
							menu = false;
							menu2 = false;
							System.exit(0);
						}
					}
				
				}
				break;
			case 2:
				menu = false;
				ent.close();
				break;
			default:
				System.out.println("\nopção invalida!!! aperte <enter>");
				clearbuffer(ent);
				String a = ent.nextLine();
				System.out.println("\n\n\n\n\n\n\n");
				break;
			}
		}
	}
	private static void clearbuffer(Scanner scanner) {
		if(scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}
}