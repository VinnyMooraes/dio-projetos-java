package candidatos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Seletivo {
	public static void main(String[] args) {
		String candidatos[] = {"Marcos", "José", "Pedro","Fabio","Eduardo"};
		for (String candidato: candidatos) {
			entrandoEmContato(candidato);
		};
	}	
	
	//METODOS
	
	static void entrandoEmContato(String candidato){
		int tentativasDeContato = 0;
		boolean tentarContatoNovamente = true;
		boolean ligacaoAtendida = false;
		
		//TENTANDO CONTATO
			do {
				ligacaoAtendida = atenderLigação();
				tentarContatoNovamente = !ligacaoAtendida;
				
				if(tentarContatoNovamente) {
					tentativasDeContato++;
				}else {
					System.out.println("Efetuando tentativa de contato com os candidatos...");
				}
				
			}while(tentarContatoNovamente && tentativasDeContato < 3);
	
		//AVALIANDO SUCESSO NAS TENTATIVAS DE CONTATO
		if(ligacaoAtendida){
			System.out.println("Conseguimos contato com o candidato "+candidato+" com " +tentativasDeContato+" tentativas de contato.");
		}else {
			System.out.println("Não conseguimos contato com o candidato "+candidato+" ,foram efetuadas "+tentativasDeContato+" tentativas de contato");
		}
		
		
	}
	static boolean atenderLigação(){
		return new Random().nextInt(3)==1;
	}

	static void imprimindoCandidatosSelecionados(){
		String candidatos[] = {"Marcos", "José", "Pedro","Fabio","Eduardo","David","Antonio","Pedro","Davi","Junior"};
		System.out.println("Lista de candidatos APROVADOS:");
		for (int i = 0; i< candidatos.length;i++){
			System.out.println("Candidato["+i+"]:" +candidatos[i]);
		}
		
	}
	
	static void selecioneCandidatos(){
		String candidatos[] = {"Marcos", "José", "Pedro","Fabio","Eduardo","David","Antonio","Pedro","Davi","Junior"};
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];	//pega o resultado da execução e salva 'temporario' na variavel canditatoAtual
			double salarioPretendido = valorSalarioPretendido();
						
			System.out.println("O candidato "+candidato+" solicitou a pretensão salarial de R$ "+salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("Candidato APROVADO na seleção inicial.");
				candidatosSelecionados++;
			}else {
				System.out.println("Candidato REPROVADO na seleção inicial.");
			}
			candidatoAtual++;
		}
	}
	
	static double valorSalarioPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800,2200);
	}
	
	static void analisarCandidato(double salarioPretendido){
		double salarioBase = 2000.0;
		
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato: Informar ao candidato data da dos testes comportamentais");
		}else if(salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato: Negociar salário com o pretendido!");
		}else{
			System.out.println("Ligar para o candidato: Negociar salário com o pretendido!");
		}
	}
}
