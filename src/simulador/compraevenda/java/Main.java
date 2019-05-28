package simulador.compraevenda.java;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	private static final ArrayList<Categoria> ListCategorias = null;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Produto> ListProdutos = new ArrayList<>();
		ArrayList<Categoria> ListCategorias = new ArrayList<>();
		ArrayList<PessoaFisica> ListPessoaFisica = new ArrayList<>();
		ArrayList<PessoaJuridica> ListPessoaJuridica = new ArrayList<>();
		int opcao;
		do {
			System.out.println("Digite: 1 - Cadastrar produtos.\n " 
					+ "2 - Cadastrar categorias.\n "
					+ "3 - Cadastrar clientes.\n " + "4 - Cadastrar fornecedores.\n " 
					+ "5 - Efetuar compras.\n "
					+ "6 - Efetuar venda.\n " + "7 - Gerar relatórios de vendas por intervalos de datas.\n "
					+ "8 - Visualizar compras anteriores de um dado cliente.\n "
					+ "9 - Calcular o consumo médio mensal de cada produto.\n 10 - ");
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				ListProdutos.add(cadastrarProduto());

			case 2:
				ListCategorias.add(cadastrarCategoria());

			case 3:
				int opcao2 =0;
				System.out.println("1 - Cadastrar pessoa física.\n" + "2 - Cadastrar pessoa jurídica");
				if (opcao2 == 1) {
					ListPessoaFisica.add(cadastrarPessoaFisica());
				} else if (opcao2 == 2) {
					ListPessoaJuridica.add(cadastrarPessoaJuridica());
				} else {
					System.err.println("Digite a informação correta.");
				}
	
			}
		} while (opcao != 0);

	}

	static public Produto cadastrarProduto() {
		String codCategoria;
		int codCategoriaInt;

		// printar lista de categorias
		do {
			exibirListaCategorias(ListCategorias);
			System.out.println("Informe o código da categoria do produto: ");
			codCategoria = input.nextLine();
			codCategoriaInt = Integer.parseInt(codCategoria);
		} while (!confirmarCategoria(ListCategorias, codCategoriaInt));
		System.out.println("Informe o nome do produto: ");
		String nome = input.nextLine();
		System.out.println("Informe o preço do produto: ");
		double preco = input.nextDouble();
		System.out.println("Informe a quantidade de estoque do produto: ");
		double qtde_estoque = input.nextDouble();
		Produto produto = new Produto(codCategoria, nome, preco, qtde_estoque);
		return produto;
	}

	static public Categoria cadastrarCategoria() {
		System.out.println("Informe a descrição: ");
		try {
			String descricao = input.nextLine();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro" + e);
		}
		return cadastrarCategoria();
	}

	static public PessoaFisica cadastrarPessoaFisica() {
		int intnum = 0;
		boolean tudoOk;
		String nome, rua, strnum, cep, bairro, complemento, cidade, estado, email, telefone, celular, cpf; 
		do {
			tudoOk = true;
			System.out.println("Informe o seu nome: ");
			nome = input.nextLine();
			System.out.println("Informe o nome da sua rua: ");
			rua = input.nextLine();
			System.out.println("Informe o número da residência: ");
			strnum = input.nextLine();
			System.out.println("Informe o cep: ");
			cep = input.nextLine();
			System.out.println("Informe o Bairro: ");
			bairro = input.nextLine();
			System.out.println("Informe o complemento: ");
			complemento = input.nextLine();
			System.out.println("Informe a cidade: ");
			cidade = input.nextLine();
			System.out.println("Informe o estado: ");
			estado = input.nextLine();
			System.out.println("Informe o seu e-mail");
			email = input.nextLine();
			System.out.println("Informe o número do seu telefone fixo: ");
			telefone = input.nextLine();
			System.out.println("Informe o número do seu celular: ");
			celular = input.nextLine();
			System.out.println("Informe o seu CPF: ");
			cpf = input.nextLine();
			try {
				intnum = Integer.parseInt(strnum);
			}catch(Exception e) {
				System.err.println("Numero da residencia invalido");
				tudoOk = false;
			}
		}while(!tudoOk);
		Endereco endereco = new Endereco(rua, cep, bairro, intnum, complemento, cidade, estado);
		PessoaFisica pessoaFisica = new PessoaFisica(endereco, nome, email, telefone, celular, cpf);
		return pessoaFisica;

	}
	static public PessoaJuridica cadastrarPessoaJuridica() {
		int intnum = 0;
		boolean tudoOk;
		String nome, rua, strnum, cep, bairro, complemento, cidade, estado, email, telefone, celular, cnpj; 
		do {
			tudoOk = true;
			System.out.println("Informe o seu nome: ");
			nome = input.nextLine();
			System.out.println("Informe o nome da sua rua: ");
			rua = input.nextLine();
			System.out.println("Informe o número da residência: ");
			strnum = input.nextLine();
			System.out.println("Informe o cep: ");
			cep = input.nextLine();
			System.out.println("Informe o Bairro: ");
			bairro = input.nextLine();
			System.out.println("Informe o complemento: ");
			complemento = input.nextLine();
			System.out.println("Informe a cidade: ");
			cidade = input.nextLine();
			System.out.println("Informe o estado: ");
			estado = input.nextLine();
			System.out.println("Informe o seu e-mail");
			email = input.nextLine();
			System.out.println("Informe o número do seu telefone fixo: ");
			telefone = input.nextLine();
			System.out.println("Informe o número do seu celular: ");
			celular = input.nextLine();
			System.out.println("Informe o seu CNPJ: ");
			cnpj = input.nextLine();
			try {
				intnum = Integer.parseInt(strnum);
			}catch(Exception e) {
				System.err.println("Numero da residencia invalido");
				tudoOk = false;
			}
		}while(!tudoOk);
		Endereco endereco = new Endereco(rua, cep, bairro, intnum, complemento, cidade, estado);
		PessoaJuridica pessoaJuridica = new PessoaJuridica(endereco, nome, email, telefone, celular, cnpj);
		return pessoaJuridica;

	}

	static private void exibirListaCategorias(ArrayList<Categoria> ListCategorias) {
		for (Categoria c : ListCategorias) {
			System.out.println("Categoria: ");
			System.out.println(c.dadosCategoria());
		}
	}

	static private boolean confirmarCategoria(ArrayList<Categoria> ListCategorias, int codCategoria) {

		for (Categoria c : ListCategorias) {
			if (c.getId() == codCategoria)
				return true;
		}
		System.err
				.println("Você digitou o código errado, digite o código certo. Se não existir, você poderá criá - lo.");
		return false;

	}

}
