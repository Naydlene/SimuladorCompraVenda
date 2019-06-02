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
		String stropcao;
		int opcao = 0;
		do {
			System.out.println("\nDigite: 1 - Cadastrar produtos.\n " + "2 - Cadastrar categorias.\n "
					+ "3 - Cadastrar clientes.\n " + "4 - Cadastrar fornecedores.\n " + "5 - Efetuar compras.\n "
					+ "6 - Efetuar venda.\n " + "7 - Gerar relatórios de vendas por intervalos de datas.\n "
					+ "8 - Visualizar compras anteriores de um dado cliente.\n "
					+ "9 - Calcular o consumo médio mensal de cada produto.\n 10 - ");

			stropcao = input.nextLine();
			try {
				opcao = Integer.parseInt(stropcao);
			} catch (Exception e) {
				System.err.println("Opção inválida.");
			}

			switch (opcao) {
			case 1:
				// (listagem, inserção e alteração);
			
				int opcao2 = 0;
				String stropcao2;
				System.out.println("1 - Listagem de produtos.\n 2 - Inserção de produtos. \n 3 - Alteração de produtos.");
				stropcao2 = input.nextLine();
				try {
					opcao2 = Integer.parseInt(stropcao2);
				} catch (Exception e) {
					System.err.println("Opção inválida.");
				}
				if (opcao2 == 1) {
					// exibir lista de produtos.
					exibirListaProdutos(ListProdutos);
				} else if (opcao2 == 2) {
					ListProdutos.add(cadastrarProduto(ListCategorias, ListProdutos));
				} else if (opcao2 == 3) {
					alterarProduto(ListProdutos, ListCategorias);
				}break;
				
			case 2:
				ListCategorias.add(cadastrarCategoria(ListCategorias));
				break;
			case 3:
				int opcao3 = 0;
				String stropcao3;
				System.out.println("1 - Cadastrar pessoa física.\n" + "2 - Cadastrar pessoa jurídica");
				stropcao3 = input.nextLine();
				try {
					opcao3 = Integer.parseInt(stropcao3);
				} catch (Exception e) {
					System.err.println("Opção inválida.");
				}

				if (opcao3 == 1) {
					ListPessoaFisica.add(cadastrarPessoaFisica());
				} else if (opcao3 == 2) {
					ListPessoaJuridica.add(cadastrarPessoaJuridica());
				} else {
					System.err.println("Digite a informação correta.");
				}
				break;
			}

		} while (opcao != 0);

	}

	static public Produto cadastrarProduto(ArrayList<Categoria> ListCategorias, ArrayList<Produto> ListProdutos) {
		int id;
		Categoria categoriaSelecionada;
		//Categoria categoria;
		// (listagem, inserção e alteração);
		// printar lista de categorias
		/*do {

			if (!exibirListaCategorias(ListCategorias))
				return null;

			System.out.println("Informe o código da categoria do produto: ");
			codCategoria = input.nextLine();
			codCategoriaInt = Integer.parseInt(codCategoria);
		} while (!confirmarCategoria(ListCategorias, codCategoriaInt));*/
		do {
			if(!exibirListaCategorias(ListCategorias))
				return null;
			id = digitarNumero("Informe o  código da categoria: ", "Informe o código correto.");
		}while(!confirmarCategoria(ListCategorias, id));
		categoriaSelecionada = retornarCategoria(ListCategorias, id);

		System.out.println("Informe o nome do produto: ");
		String nome = input.nextLine();
		double preco = numeroDouble("Informe o preço do produto: ", "Preço do produto inválido.");
		double qtde_estoque = numeroDouble("Informe a quantidade de estoque do produto: ","Quantidade de estoque inválida.");
		Produto produto = new Produto(categoriaSelecionada, ListProdutos.size() + 1, nome, preco, qtde_estoque);
		return produto;
	}

	static public Categoria cadastrarCategoria(ArrayList<Categoria> ListCategorias) {

		System.out.println("Informe a descrição:");
		String descricao = input.nextLine();
		Categoria categoria = new Categoria(ListCategorias.size() + 1, descricao);
		return categoria;

	}

	static public PessoaFisica cadastrarPessoaFisica() {
		String nome, rua, cep, bairro, complemento, cidade, estado, email, telefone, celular, cpf;

		System.out.println("Informe o seu nome: ");
		nome = input.nextLine();
		System.out.println("Informe o nome da sua rua: ");
		rua = input.nextLine();
		int intnum = digitarNumero("Digite o numero da sua residência: ", "Numero da residencia inválido");
		cep = digitarStrApenasNumero("Informe o CEP: ", "Número do CEP incorreto.");
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
		telefone = digitarStrApenasNumero("Informe o número do seu telefone fixo: ", "Número do telefone inválido");
		celular = digitarStrApenasNumero("Informe o número do seu celular: ", "Número do celular inválido");
		cpf = digitarStrApenasNumero("Informe o seu CPF: ", "Número do celular inválido");

		Endereco endereco = new Endereco(rua, cep, bairro, intnum, complemento, cidade, estado);
		PessoaFisica pessoaFisica = new PessoaFisica(endereco, nome, email, telefone, celular, cpf);
		return pessoaFisica;

	}
	static private boolean ehApenasNumero(String digitado, String fraseErro) {
		
		try {
			int n = Integer.parseInt(digitado);
		}catch(Exception e) {
			System.out.println(fraseErro);
			return false;
		}
		
		return true;	
	}
	static public String digitarStrApenasNumero(String frase, String fraseErro) {
		String strDigitado;
		do {
			System.out.println(frase);
			strDigitado = input.nextLine();
		} while (!ehApenasNumero(strDigitado,fraseErro));
		return strDigitado;
	}


	// METODO PUBLICO ESTATICO INTEIRO CHAMADO DE: DIGITARNUMERO, E RECEBE FRASE E
	// FRASEERRO COMO PARAMETRO.
	static public int digitarNumero(String frase, String fraseErro) {
		// VARIAVEL intdigitado DO TIPO INT INICIALIZANDO COM 0.
		int intdigitado = 0;
		// VARIAVEL DO TIPO STR.
		String strdigitado;
		// BOOLEAN P/ FAZER A ESTRUTURA DE REPETICAO DO WHILE.
		boolean tudoOk;
		do {
			// BOLLEAN COMECA EM TRUE.
			tudoOk = true;
			// PRINT COM A VARIAVEL FRASE PASSADA POR PARAMETRO.
			System.out.println(frase);
			// TENTANDO FAZER O TRATAMENTO.
			try {
				// LENDO O INPUT DO USUARIO DO TIPO STR.
				strdigitado = input.nextLine();
				// CONVERTENDO O STR P INT.
				intdigitado = Integer.parseInt(strdigitado);
				// SE O TRY NAO CONSEGUIR FAZER O TRATAMENTO,
			} catch (Exception e) {
				System.err.println(fraseErro);
				tudoOk = false;
			}

		} while (!tudoOk);
		return intdigitado;
	}

	static public double numeroDouble(String frase, String fraseErro) {
		double dbdigitado = 0;
		String strdbdigitado;
		boolean tudoOk;
		do {
			tudoOk = true;
			System.out.println(frase);
			try {
				strdbdigitado = input.nextLine();
				dbdigitado = Double.parseDouble(strdbdigitado);
			} catch (Exception e) {
				System.out.println(fraseErro);
				tudoOk = false;
			}
		} while (!tudoOk);
		return dbdigitado;
	}

	static public PessoaJuridica cadastrarPessoaJuridica() {
		
		boolean tudoOk;
		String nome, rua, strnum, cep, bairro, complemento, cidade, estado, email, telefone, celular, cnpj;
			System.out.println("Informe o seu nome ou o nome da sua empresa: ");
			nome = input.nextLine();
			System.out.println("Informe o nome da sua rua: ");
			rua = input.nextLine();
			int intnum = digitarNumero("Informe o número da residência: ", "Número inválido.");
			cep = digitarStrApenasNumero("Informe o cep: ", "Número do CEP incorreto.");
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
			telefone = digitarStrApenasNumero("Informe o número do seu telefone fixo: ", "Número do telefone inválido.");
			celular = digitarStrApenasNumero("Informe o número do seu celular: ", "Número do celular inválido.");
			cnpj = digitarStrApenasNumero("Informe o seu CNPJ: ", "Número do CNPJ inválido.");
	
		Endereco endereco = new Endereco(rua, cep, bairro, intnum, complemento, cidade, estado);
		PessoaJuridica pessoaJuridica = new PessoaJuridica(endereco, nome, email, telefone, celular, cnpj);
		return pessoaJuridica;

	}

	static private boolean exibirListaCategorias(ArrayList<Categoria> ListCategorias) {

		// se o tamanho da lista for 0, retorna falso.
		if (ListCategorias.size() == 0) {
			System.err.println("Lista de categorias vazia.");
			return false;
		}
		for (Categoria c : ListCategorias) {
			System.out.println("Categoria: ");
			// o c vai referenciar cada elemento na lista, um de cada vez.
			System.out.println(c.dadosCategoria());
		}
		return true;
	}

	static private boolean exibirListaProdutos(ArrayList<Produto> ListProdutos) {

		// se o tamanho da lista for 0, retorna falso.
		if (ListProdutos.size() == 0) {
			System.out.println("Lista de Produtos vazia.");
			return false;
		}
		for (Produto p : ListProdutos) {
			System.out.println("Produto: ");
			System.out.println(p.dadosProdutos());
		}
		return true;
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

	static private boolean confirmarProduto(ArrayList<Produto> ListProdutos, int cod) {

		for (Produto p : ListProdutos) {
			if (p.getId() == cod)
				return true;
		}
		System.err
				.println("Você digitou o código errado, digite o código certo. Se não existir, você poderá criá - lo.");
		return false;

	}

	static private Produto retornarProduto(ArrayList<Produto> ListProdutos, int cod) {
		for (Produto p : ListProdutos) {
			if (p.getId() == cod)
				return p;
		}
		return null;
	}
	static private Categoria retornarCategoria(ArrayList<Categoria> ListCategorias, int codCategoria) {
		for (Categoria c : ListCategorias) {
			if (c.getId() == codCategoria)
				return c;
		}
		return null;
	}

	static private void alterarProduto(ArrayList<Produto> ListProdutos, ArrayList<Categoria> ListCategorias) {
		int cod;
		Produto produtoSelecionado;
		Categoria categoriaSelecionada;
		exibirListaProdutos(ListProdutos);
		
		do {
			cod = digitarNumero("Informe o código do produto que vc deseja alterar: ", "Informe o código correto.");
		}while(!confirmarProduto(ListProdutos, cod));
		produtoSelecionado = retornarProduto(ListProdutos, cod);
		System.out.println("Você selecionou o produto:");
		System.out.println(produtoSelecionado.dadosProdutos());
		System.out.println("O que deseja alterar nesse produto?");
		do {
			int info = digitarNumero("Digite:\n 1 - Categoria. \n 2 - nome\n 3 - precoVenda\n 4 - qtde_estoque", "Informação incorreta.");
			if (info == 1) {
				int novoCod; 
				do {
					if(!exibirListaCategorias(ListCategorias))
						return;
					novoCod = digitarNumero("Informe o novo código da categoria", "Informe o código correto.");
				}while(!confirmarCategoria(ListCategorias, novoCod));
				categoriaSelecionada = retornarCategoria(ListCategorias, novoCod);
				System.out.println("Você selecionou a categoria: ");
				System.out.println(categoriaSelecionada.dadosCategoria());
				produtoSelecionado.setCategoria(categoriaSelecionada);
				
			}else if (info == 2) {
				String novoNome;
				System.out.println("Informe o novo nome para o produto: ");
				novoNome = input.nextLine();
				produtoSelecionado.setNome(novoNome);
			}else if (info == 3) {
				double newprecoVenda = numeroDouble("Informe o novo preço do produto: ", "Informação inválida");
				produtoSelecionado.setPrecoVenda(newprecoVenda);
			}else if(info == 4) {
				double newqtde_estoque = numeroDouble("Informe a quantidade de estoque do produto: ", "Informação inválida");
				produtoSelecionado.setQtde_estoque(newqtde_estoque);
			}
		
		}while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
			
	}
	static private boolean perguntaSimNao(String frase, String fraseErro) {
		int simNao;
		do{
			simNao = digitarNumero(frase, fraseErro);
			if(simNao != 1 && simNao != 2) {
				System.out.println("Opção inválida.");
			}
		}while(simNao != 1 && simNao != 2);
		
		if(simNao==1)
			return true;
		else
			return false;
		
	}
}
