package Rel;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {
	int qtFun;
	String descricaoProblema;
	LocalDate dtProblema;
	Integer nivel;

	public static void main(String[] args) {
		String caminhoArquivo = "/home/wellintons/Desktop/exemplo.txt";
		Funcionario funcionario = new Funcionario();
		Funcionario funcionario2 = new Funcionario();
		Funcionario funcionario3 = new Funcionario();

		Relatorio relatorio = new Relatorio();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Quantos Funcionários estão envolvidos?");
		relatorio.qtFun = scan.nextInt();

		System.out.println("Digite o ID do Funcionáro:");
		funcionario.setIdFuncionario(scan.nextInt());

		System.out.println("Digite o nome do funcionário:");
		funcionario.setDsNome(scan.next());

		switch (relatorio.qtFun) {
		case 2:
			System.out.println("Digite o ID do 2 Funcionáro:");
			funcionario2.setIdFuncionario(scan.nextInt());

			System.out.println("Digite o nome do 2 funcionário:");
			funcionario2.setDsNome(scan.next());

			break;
		case 3:
			System.out.println("Digite o ID do 2 Funcionáro:");
			funcionario2.setIdFuncionario(scan.nextInt());

			System.out.println("Digite o nome do 2 funcionário:");
			funcionario2.setDsNome(scan.next());

			System.out.println("Digite o ID do 3 Funcionáro:");
			funcionario3.setIdFuncionario(scan.nextInt());

			System.out.println("Digite o nome do 3 funcionário:");
			funcionario3.setDsNome(scan.next());

			break;

		default:
		}

		System.out.println("Digte a data do ocorrido no formato (dd-MM-yyyy:)");
		String dataImput = scan.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		relatorio.dtProblema = LocalDate.parse(dataImput, formatter);

		System.out.println("Digite de 1 a 3 o nivel do problema");
		relatorio.nivel = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Descreva o problema:");
		relatorio.descricaoProblema = scan.nextLine();
		
		
		if (relatorio.qtFun > 1 && relatorio.qtFun <= 3) {
			System.out.println("Os funcionários" + funcionario.getDsNome() + "," + funcionario2.getDsNome() + ","
					+ funcionario3.getDsNome() + "," + " participaram do seguinte problema: "
					+ relatorio.descricaoProblema + " na data " + relatorio.dtProblema.format(formatter));
		} else {

			System.out.println("O funcionário " + funcionario.getIdFuncionario() + ", nome " + funcionario.getDsNome()
					+ " teve o seguinte problema: " + relatorio.descricaoProblema + " na data "
					+ relatorio.dtProblema.format(formatter));
		}
		try {

			FileWriter escritor = new FileWriter(caminhoArquivo);
			BufferedWriter bufferEscrita = new BufferedWriter(escritor);

			bufferEscrita.write("Nome dos Funcionários: "+ buscarNome(funcionario.getDsNome(), funcionario2.getDsNome(), funcionario3.getDsNome())) ;
			bufferEscrita.newLine();
			bufferEscrita.write("O problema: " + relatorio.descricaoProblema);
			bufferEscrita.newLine();
			bufferEscrita.write("Data ocorrido: " + relatorio.dtProblema);

			bufferEscrita.close();
			escritor.close();

			System.out.println("Conteúdo foi escrito com sucesso no arquivo: " + caminhoArquivo);

		} catch (IOException e) {
			System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	private static String buscarNome(String funcionario, String funcionario2, String funcionario3) {
		if (funcionario2 == null && funcionario3 == null) {
			return funcionario;
		} else if (funcionario2 != null && funcionario3 == null) {
			return funcionario + ", " + funcionario2;
		} else if (funcionario2 != null && funcionario3 != null) {
			return funcionario + ", " + funcionario2 + ", " + funcionario3;
		}
		return "Nenhum funcionário encontrado! ";
	}
}
