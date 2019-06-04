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
		ArrayList<Fornecedores> ListFornecedores = new ArrayList<>();
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
				System.out
						.println("1 - Listagem de produtos.\n 2 - Inserção de produtos. \n 3 - Alteração de produtos.");
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
				} else {
					System.out.println("Informe uma opção válida.");
				}
				break;

			case 2:
				// (listagem, inserção e alteração);
				int opcao3 = 0;
				String strOpcao3;
				System.out.println(
						"1 - Listagem de categorias.\n 2 - Inserção de categorias. \n 3 - Alteração de categorias.");
				strOpcao3 = input.nextLine();
				try {
					opcao3 = Integer.parseInt(strOpcao3);
				} catch (Exception e) {
					System.err.println("Opção inexistente.");
				}
				if (opcao3 == 1) {
					exibirListaCategorias(ListCategorias);
				} else if (opcao3 == 2) {
					ListCategorias.add(cadastrarCategoria(ListCategorias));
				} else if (opcao3 == 3) {
					alterarCategoria(ListCategorias);
				} else {
					System.out.println("Opção inexistente.");
				}

				break;
			case 3:
				// (listagem, inserção e alteração);
				int opcao4 = 0;
				String stropcao4;
				System.out.println("1 - Cadastrar pessoa física.\n" + "2 - Cadastrar pessoa jurídica");
				stropcao4 = input.nextLine();
				try {
					opcao4 = Integer.parseInt(stropcao4);
				} catch (Exception e) {
					System.err.println("Opção inválida.");
				}

				if (opcao4 == 1) {
					int opcao5 = 0;
					String strOpcao5;
					System.out.println(
							"1 - Listagem de pessoas físicas.\n 2 - Inserção de pessoas físicas. \n 3 - Alteração de pessoas físicas.");
					strOpcao5 = input.nextLine();
					try {
						opcao5 = Integer.parseInt(strOpcao5);
					} catch (Exception e) {
						System.err.println("Opção inexistente.");
					}
					if (opcao5 == 1) {
						exibirListaPessoaFisica(ListPessoaFisica);
					} else if (opcao5 == 2) {
						ListPessoaFisica.add(cadastrarPessoaFisica(ListPessoaFisica));
					} else if (opcao5 == 3) {
						alterarPessoaFisica(ListPessoaFisica);
					} else {
						System.err.println("Digite a informação correta.");
					}
				}
				if (opcao4 == 2) {
					int opcao6 = 0;
					String strOpcao6;
					System.out.println(
							"1 - Listagem de pessoas jurídicas.\n 2 - Inserção de pessoas jurídicas. \n 3 - Alteração de pessoas jurídicas.");
					strOpcao6 = input.nextLine();
					try {
						opcao6 = Integer.parseInt(strOpcao6);
					} catch (Exception e) {
						System.err.println("Opção inexistente.");
					}
					if (opcao6 == 1) {
						exibirListaPessoaJuridica(ListPessoaJuridica);
					} else if (opcao6 == 2) {
						ListPessoaJuridica.add(cadastrarPessoaJuridica(ListPessoaJuridica));
					} else if (opcao6 == 3) {
						alterarPessoaJuridica(ListPessoaJuridica);
					} else {
						System.err.println("Digite a informação correta.");
					}
					break;
				}
			case 4:
				// (listagem, inserção e alteração);
				int opcao7 = 0;
				String strOpcao7;
				System.out.println(
						"1 - Listagem de fornecedores.\n 2 - Inserção de fornecedores. \n 3 - Alteração de fornecedores.");
				strOpcao7 = input.nextLine();
				try {
					opcao7 = Integer.parseInt(strOpcao7);
				} catch (Exception e) {
					System.err.println("Opção inexistente.");
				}
				if (opcao7 == 1) {
					exibirListaFornecedores(ListFornecedores);
				} else if (opcao7 == 2) {
					ListFornecedores.add(cadastrarFornecedores(ListFornecedores));
				} else if (opcao7 == 3) {

					alterarFornecedores(ListFornecedores);
				} else {
					System.out.println("Opção inexistente.");
				}

				break;

			}

		} while (opcao != 0);
	}

	static public Produto cadastrarProduto(ArrayList<Categoria> ListCategorias, ArrayList<Produto> ListProdutos) {
		int id;
		Categoria categoriaSelecionada;

		do {
			if (!exibirListaCategorias(ListCategorias))
				return null;
			id = digitarNumero("Informe o  código da categoria: ", "Informe o código correto.");
		} while (!confirmarCategoria(ListCategorias, id));
		categoriaSelecionada = retornarCategoria(ListCategorias, id);

		System.out.println("Informe o nome do produto: ");
		String nome = input.nextLine();
		double preco = numeroDouble("Informe o preço do produto: ", "Preço do produto inválido.");
		double qtde_estoque = numeroDouble("Informe a quantidade de estoque do produto: ",
				"Quantidade de estoque inválida.");
		Produto produto = new Produto(categoriaSelecionada, ListProdutos.size() + 1, nome, preco, qtde_estoque);
		return produto;
	}

	static public Categoria cadastrarCategoria(ArrayList<Categoria> ListCategorias) {

		System.out.println("Informe a descrição:");
		String descricao = input.nextLine();
		Categoria categoria = new Categoria(ListCategorias.size() + 1, descricao);
		return categoria;

	}

	static public PessoaFisica cadastrarPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica) {
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
		PessoaFisica pessoaFisica = new PessoaFisica(ListPessoaFisica.size() + 1, endereco, nome, email, telefone,
				celular, cpf);
		return pessoaFisica;

	}

	static private boolean ehApenasNumero(String digitado, String fraseErro) {

		try {
			int n = Integer.parseInt(digitado);
		} catch (Exception e) {
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
		} while (!ehApenasNumero(strDigitado, fraseErro));
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

	static public PessoaJuridica cadastrarPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica) {

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
		PessoaJuridica pessoaJuridica = new PessoaJuridica(ListPessoaJuridica.size() + 1, endereco, nome, email,
				telefone, celular, cnpj);
		return pessoaJuridica;

	}

	static public Fornecedores cadastrarFornecedores(ArrayList<Fornecedores> ListFornecedores) {
	
		String nomeFornecedor, ruaFornecedor, cepFornecedor, bairroFornecedor, complementoFornecedor, cidadeFornecedor,
				estadoFornecedor, emailFornecedor, telefoneFornecedor, celularFornecedor, cpfCnpjFornecedor;

		System.out.println("Informe o nome: ");
		nomeFornecedor = input.nextLine();
		System.out.println("Informe o nome da rua: ");
		ruaFornecedor = input.nextLine();
		int intnumFornecedor = digitarNumero("Digite o numero da residência: ", "Numero inválido");
		cepFornecedor = digitarStrApenasNumero("Informe o CEP: ", "Número do CEP incorreto.");
		System.out.println("Informe o Bairro: ");
		bairroFornecedor = input.nextLine();
		System.out.println("Informe o complemento: ");
		complementoFornecedor = input.nextLine();
		System.out.println("Informe a cidade: ");
		cidadeFornecedor = input.nextLine();
		System.out.println("Informe o estado: ");
		estadoFornecedor = input.nextLine();
		System.out.println("Informe o e-mail");
		emailFornecedor = input.nextLine();
		telefoneFornecedor = digitarStrApenasNumero("Informe o número do telefone fixo: ",
				"Número do telefone inválido");
		celularFornecedor = digitarStrApenasNumero("Informe o número do seu celular: ", "Número inválido");
		cpfCnpjFornecedor = digitarStrApenasNumero("Informe o seu CPF: ", "Número inválido");

		Endereco endereco = new Endereco(ruaFornecedor, cepFornecedor, bairroFornecedor, intnumFornecedor,
				complementoFornecedor, cidadeFornecedor, estadoFornecedor);
		Fornecedores fornecedores = new Fornecedores(ListFornecedores.size() + 1, endereco, nomeFornecedor,
				emailFornecedor, telefoneFornecedor, celularFornecedor, cpfCnpjFornecedor);
		return fornecedores;
	}

	static private boolean exibirListaPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica) {

		// se o tamanho da lista for 0, retorna falso.
		if (ListPessoaJuridica.size() == 0) {
			System.err.println("Lista de pessoa juridica vazia.");
			return false;
		}
		for (PessoaJuridica j : ListPessoaJuridica) {
			System.out.println("Pessoa Juridica: ");
			// o c vai referenciar cada elemento na lista, um de cada vez.
			System.out.println(j.dadosPessoaJuridica());
		}
		return true;
	}

	static private boolean exibirListaPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica) {

		// se o tamanho da lista for 0, retorna falso.
		if (ListPessoaFisica.size() == 0) {
			System.err.println("Lista de pessoa fisica vazia.");
			return false;
		}
		for (PessoaFisica f : ListPessoaFisica) {
			System.out.println("Pessoa Física: ");
			// o c vai referenciar cada elemento na lista, um de cada vez.
			System.out.println(f.dadosPessoaFisica());
		}
		return true;
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

	static private boolean exibirListaFornecedores(ArrayList<Fornecedores> ListFornecedores) {

		// se o tamanho da lista for 0, retorna falso.
		if (ListFornecedores.size() == 0) {
			System.out.println("Lista de fornecedores vazia.");
			return false;
		}
		for (Fornecedores fo : ListFornecedores) {
			System.out.println("Fornecedor: ");
			System.out.println(fo.dadosFornecedores());
		}
		return true;
	}

	static private boolean confirmarFornecedores(ArrayList<Fornecedores> ListFornecedores, int idFornecedores) {

		for (Fornecedores fo : ListFornecedores) {
			if (fo.getId() == idFornecedores)
				return true;
		}
		System.err
				.println("Você digitou o código errado, digite o código certo. Se não existir, você poderá criá - lo.");
		return false;

	}

	static private boolean confirmarPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica, int idJuridica) {

		for (PessoaJuridica j : ListPessoaJuridica) {
			if (j.getId() == idJuridica)
				return true;
		}
		System.err
				.println("Você digitou o código errado, digite o código certo. Se não existir, você poderá criá - lo.");
		return false;

	}

	static private boolean confirmarPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica, int idFisica) {

		for (PessoaFisica f : ListPessoaFisica) {
			if (f.getId() == idFisica)
				return true;
		}
		System.err
				.println("Você digitou o código errado, digite o código certo. Se não existir, você poderá criá - lo.");
		return false;

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

	static private Fornecedores retornarFornecedores(ArrayList<Fornecedores> ListFornecedores, int idFornecedores) {
		for (Fornecedores fo : ListFornecedores) {
			if (fo.getId() == idFornecedores)
				return fo;
		}
		return null;
	}

	static private PessoaJuridica retornarPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica, int idJuridica) {
		for (PessoaJuridica j : ListPessoaJuridica) {
			if (j.getId() == idJuridica)
				return j;
		}
		return null;
	}

	static private PessoaFisica retornarPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica, int idFisica) {
		for (PessoaFisica f : ListPessoaFisica) {
			if (f.getId() == idFisica)
				return f;
		}
		return null;
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
		} while (!confirmarProduto(ListProdutos, cod));
		produtoSelecionado = retornarProduto(ListProdutos, cod);
		System.out.println("Você selecionou o produto:");
		System.out.println(produtoSelecionado.dadosProdutos());
		System.out.println("O que deseja alterar nesse produto?");
		do {
			int info = digitarNumero("Digite:\n 1 - Categoria. \n 2 - nome\n 3 - precoVenda\n 4 - qtde_estoque",
					"Informação incorreta.");
			if (info == 1) {
				int novoCod;
				do {
					if (!exibirListaCategorias(ListCategorias))
						return;
					novoCod = digitarNumero("Informe o novo código da categoria", "Informe o código correto.");
				} while (!confirmarCategoria(ListCategorias, novoCod));
				categoriaSelecionada = retornarCategoria(ListCategorias, novoCod);
				System.out.println("Você selecionou a categoria: ");
				System.out.println(categoriaSelecionada.dadosCategoria());
				produtoSelecionado.setCategoria(categoriaSelecionada);

			} else if (info == 2) {
				String novoNome;
				System.out.println("Informe o novo nome para o produto: ");
				novoNome = input.nextLine();
				produtoSelecionado.setNome(novoNome);
			} else if (info == 3) {
				double newprecoVenda = numeroDouble("Informe o novo preço do produto: ", "Informação inválida");
				produtoSelecionado.setPrecoVenda(newprecoVenda);
			} else if (info == 4) {
				double newqtde_estoque = numeroDouble("Informe a quantidade de estoque do produto: ",
						"Informação inválida");
				produtoSelecionado.setQtde_estoque(newqtde_estoque);
			}

		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));

	}

	static private boolean perguntaSimNao(String frase, String fraseErro) {
		int simNao;
		do {
			simNao = digitarNumero(frase, fraseErro);
			if (simNao != 1 && simNao != 2) {
				System.out.println("Opção inválida.");
			}
		} while (simNao != 1 && simNao != 2);

		if (simNao == 1)
			return true;
		else
			return false;

	}

	static private void alterarCategoria(ArrayList<Categoria> ListCategorias) {
		int cod;
		String novaDescricao;
		Categoria categoriaSelecionada;
		do {
			if (!exibirListaCategorias(ListCategorias))
				return;

			cod = digitarNumero("Informe o código da categoria que vc deseja alterar: ", "Informe o código correto.");
		} while (!confirmarCategoria(ListCategorias, cod));
		System.out.println("Você selecionou a categoria: ");
		categoriaSelecionada = retornarCategoria(ListCategorias, cod);
		System.out.println(categoriaSelecionada.dadosCategoria());
		System.out.println("Informe a nova descrição: ");
		novaDescricao = input.nextLine();
		categoriaSelecionada.setDescricao(novaDescricao);

		return;
	}

	static private void alterarPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica) {
		int idFisica;
		PessoaFisica pessoaFisicaSelecionada;
		Endereco enderecoAux;
		do {
			if (!exibirListaPessoaFisica(ListPessoaFisica))
				return;

			idFisica = digitarNumero("Informe o código da pessoa que você deseja alterar: ",
					"Informe o código correto.");
		} while (!confirmarPessoaFisica(ListPessoaFisica, idFisica));
		pessoaFisicaSelecionada = retornarPessoaFisica(ListPessoaFisica, idFisica);
		System.out.println("Você selecionou a pessoa: ");
		System.out.println(pessoaFisicaSelecionada.dadosPessoaFisica());
		System.out.println("O que deseja alterar nesta pessoa?");
		/*
		 * super(endereco, nome, email, telefone, celular); this.cpf = cpf;
		 */
		do {
			int numFis = digitarNumero(
					"Digite:\n 1 - Nome. \n 2 - Endereço.\n 3 - E-mail.\n 4 - Telefone.\n 5 - Celular.\n 6 - CPF.",
					"Informação incorreta.");
			if (numFis == 1) {

				String nome;
				System.out.println("Informe o nome que deseja: ");
				nome = input.nextLine();
				pessoaFisicaSelecionada.setNome(nome);

			} else if (numFis == 2) {
				int escolha;
				String rua;
				int numEnde;
				String cepEnde;
				String bairroEnde;
				String cidadeEnde;
				String estadoEnde;
				String complementoEnde;
				do {
					escolha = digitarNumero(
							"Informe o que você deseja alterar:\n1 - Rua. \n2 -Número. \n3 - CEP. \n4 - Bairro. \n 5 - Cidade. \n6 - Estado. \n7 - Complemento.",
							"Informação inválida");
					enderecoAux = pessoaFisicaSelecionada.getEndereco();
					if (escolha == 1) {
						System.out.println("Informe o nome da rua: ");
						rua = input.nextLine();
						enderecoAux.setRua(rua);
					} else if (escolha == 2) {
						numEnde = digitarNumero("Informe o número: ", "Informação inválida");
						enderecoAux.setNum(numEnde);
					} else if (escolha == 3) {
						cepEnde = digitarStrApenasNumero("Informe o CEP: ", "Informação inválida");
						enderecoAux.setCep(cepEnde);
					} else if (escolha == 4) {
						System.out.println("Informe o bairro: ");
						bairroEnde = input.nextLine();
						enderecoAux.setBairro(bairroEnde);
					} else if (escolha == 5) {
						System.out.println("Informe a cidade: ");
						cidadeEnde = input.nextLine();
						enderecoAux.setCidade(cidadeEnde);
					} else if (escolha == 6) {
						System.out.println("Informe o estado: ");
						estadoEnde = input.nextLine();
						enderecoAux.setEstado(estadoEnde);
					} else if (escolha == 7) {
						System.out.println("Informe o complemento: ");
						complementoEnde = input.nextLine();
						enderecoAux.setComplemento(complementoEnde);
					}
				} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
			} else if (numFis == 3) {
				String novoEmail;
				novoEmail = digitarStrApenasNumero("Informe o e-mail: ", "Informação inválida");
				pessoaFisicaSelecionada.setEmail(novoEmail);
			} else if (numFis == 4) {
				String novoTelefone;
				novoTelefone = digitarStrApenasNumero("Informe o número do telefone: ", "Informação inválida");
				pessoaFisicaSelecionada.setTelefone(novoTelefone);
			} else if (numFis == 5) {
				String novoCelular;
				novoCelular = digitarStrApenasNumero("Informe o número do celular: ", "Informação inválida");
				pessoaFisicaSelecionada.setCelular(novoCelular);
			} else if (numFis == 6) {
				String novoCpf;
				novoCpf = digitarStrApenasNumero("Informe o número do CPF: ", "Informação inválida");
				pessoaFisicaSelecionada.setCpf(novoCpf);
			} else {
				System.out.println("Opção inválida.");
			}
		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
	}

	static private void alterarPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica) {
		int idJuridica;
		PessoaJuridica pessoaJuridicaSelecionada;
		Endereco enderecoAuxiliar;
		do {
			if (!exibirListaPessoaJuridica(ListPessoaJuridica))
				return;

			idJuridica = digitarNumero("Informe o código da pessoa que você deseja alterar: ",
					"Informe o código correto.");
		} while (!confirmarPessoaJuridica(ListPessoaJuridica, idJuridica));
		pessoaJuridicaSelecionada = retornarPessoaJuridica(ListPessoaJuridica, idJuridica);
		System.out.println("Você selecionou a pessoa: ");
		System.out.println(pessoaJuridicaSelecionada.dadosPessoaJuridica());
		System.out.println("O que deseja alterar nesta pessoa?");
		do {
			int numJuri = digitarNumero(
					"Digite:\n 1 - Nome. \n 2 - Endereço.\n 3 - E-mail.\n 4 - Telefone.\n 5 - Celular.\n 6 - CNPJ.",
					"Informação incorreta.");
			if (numJuri == 1) {

				String nomeJuridica;
				System.out.println("Informe o nome que deseja: ");
				nomeJuridica = input.nextLine();
				pessoaJuridicaSelecionada.setNome(nomeJuridica);

			} else if (numJuri == 2) {
				int escolha2;
				String ruaJuridica;
				int numJuridica;
				String cepJuridica;
				String bairroJuridica;
				String cidadeJuridica;
				String estadoJuridica;
				String complementoJuridica;
				do {
					escolha2 = digitarNumero(
							"Informe o que você deseja alterar:\n1 - Rua. \n2 -Número. \n3 - CEP. \n4 - Bairro. \n 5 - Cidade. \n6 - Estado. \n7 - Complemento.",
							"Informação inválida");
					enderecoAuxiliar = pessoaJuridicaSelecionada.getEndereco();
					if (escolha2 == 1) {
						System.out.println("Informe o nome da rua: ");
						ruaJuridica = input.nextLine();
						enderecoAuxiliar.setRua(ruaJuridica);
					} else if (escolha2 == 2) {
						numJuridica = digitarNumero("Informe o número da residência: ", "Informação inválida");
						enderecoAuxiliar.setNum(numJuridica);
					} else if (escolha2 == 3) {
						cepJuridica = digitarStrApenasNumero("Informe o CEP: ", "Informação inválida");
						enderecoAuxiliar.setCep(cepJuridica);
					} else if (escolha2 == 4) {
						System.out.println("Informe o bairro: ");
						bairroJuridica = input.nextLine();
						enderecoAuxiliar.setBairro(bairroJuridica);
					} else if (escolha2 == 5) {
						System.out.println("Informe a cidade: ");
						cidadeJuridica = input.nextLine();
						enderecoAuxiliar.setCidade(cidadeJuridica);
					} else if (escolha2 == 6) {
						System.out.println("Informe o estado: ");
						estadoJuridica = input.nextLine();
						enderecoAuxiliar.setEstado(estadoJuridica);
					} else if (escolha2 == 7) {
						System.out.println("Informe o complemento: ");
						complementoJuridica = input.nextLine();
						enderecoAuxiliar.setComplemento(complementoJuridica);
					}
				} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
			} else if (numJuri == 3) {
				String novoEmail;
				novoEmail = digitarStrApenasNumero("Informe o e-mail: ", "Informação inválida");
				pessoaJuridicaSelecionada.setEmail(novoEmail);
			} else if (numJuri == 4) {
				String novoTelefone;
				novoTelefone = digitarStrApenasNumero("Informe o número do telefone: ", "Informação inválida");
				pessoaJuridicaSelecionada.setTelefone(novoTelefone);
			} else if (numJuri == 5) {
				String novoCelular;
				novoCelular = digitarStrApenasNumero("Informe o número do celular: ", "Informação inválida");
				pessoaJuridicaSelecionada.setCelular(novoCelular);
			} else if (numJuri == 6) {
				String novoCnpj;
				novoCnpj = digitarStrApenasNumero("Informe o número do CPF: ", "Informação inválida");
				pessoaJuridicaSelecionada.setCnpj(novoCnpj);
			} else {
				System.out.println("Opção inválida.");
			}
		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
	}

	static private void alterarFornecedores(ArrayList<Fornecedores> ListFornecedores) {
		int idFornecedores;
		Fornecedores fornecedorSelecionado;
		Endereco enderecoAuxrFornecedor;
		do {
			if (!exibirListaFornecedores(ListFornecedores))
				return;

			idFornecedores = digitarNumero("Informe o código do fornecedor que você deseja alterar: ",
					"Informe o código correto.");
		} while (!confirmarFornecedores(ListFornecedores, idFornecedores));
		fornecedorSelecionado = retornarFornecedores(ListFornecedores, idFornecedores);
		System.out.println("Você selecionou o fornecedor: ");
		System.out.println(fornecedorSelecionado.dadosFornecedores());
		System.out.println("O que deseja alterar neste fornecedor?");
		do {

			int numFornecedor = digitarNumero(
					"Digite:\n 1 - Nome. \n 2 - Endereço.\n 3 - E-mail.\n 4 - Telefone.\n 5 - Celular.\n 6 - CPF ou CNPJ.",
					"Informação incorreta.");
			if (numFornecedor == 1) {

				String nomeFornecedor;
				System.out.println("Informe o nome que deseja: ");
				nomeFornecedor = input.nextLine();
				fornecedorSelecionado.setNome(nomeFornecedor);

			} else if (numFornecedor == 2) {
				int escolhaFornecedor;
				String ruaFornecedor;
				int numeroFornecedor;
				String cepFornecedor;
				String bairroFornecedor;
				String cidadeFornecedor;
				String estadoFornecedor;
				String complementoFornecedor;
				do {
					escolhaFornecedor = digitarNumero(
							"Informe o que você deseja alterar:\n1 - Rua. \n2 -Número. \n3 - CEP. \n4 - Bairro. \n 5 - Cidade. \n6 - Estado. \n7 - Complemento.",
							"Informação inválida");
					enderecoAuxrFornecedor = fornecedorSelecionado.getEndereco();
					if (escolhaFornecedor == 1) {
						System.out.println("Informe o nome da rua: ");
						ruaFornecedor = input.nextLine();
						enderecoAuxrFornecedor.setRua(ruaFornecedor);
					} else if (escolhaFornecedor == 2) {
						numeroFornecedor = digitarNumero("Informe o número da empresa: ", "Informação inválida");
						enderecoAuxrFornecedor.setNum(numeroFornecedor);
					} else if (escolhaFornecedor == 3) {
						cepFornecedor = digitarStrApenasNumero("Informe o CEP: ", "Informação inválida");
						enderecoAuxrFornecedor.setCep(cepFornecedor);
					} else if (escolhaFornecedor == 4) {
						System.out.println("Informe o bairro: ");
						bairroFornecedor = input.nextLine();
						enderecoAuxrFornecedor.setBairro(bairroFornecedor);
					} else if (escolhaFornecedor == 5) {
						System.out.println("Informe a cidade: ");
						cidadeFornecedor = input.nextLine();
						enderecoAuxrFornecedor.setCidade(cidadeFornecedor);
					} else if (escolhaFornecedor == 6) {
						System.out.println("Informe o estado: ");
						estadoFornecedor = input.nextLine();
						enderecoAuxrFornecedor.setEstado(estadoFornecedor);
					} else if (escolhaFornecedor == 7) {
						System.out.println("Informe o complemento: ");
						complementoFornecedor = input.nextLine();
						enderecoAuxrFornecedor.setComplemento(complementoFornecedor);
					}
				} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
			} else if (numFornecedor == 3) {
				String emailFornecedor;
				emailFornecedor = digitarStrApenasNumero("Informe o e-mail: ", "Informação inválida");
				fornecedorSelecionado.setEmail(emailFornecedor);
			} else if (numFornecedor == 4) {
				String telefoneFornecedor;
				telefoneFornecedor = digitarStrApenasNumero("Informe o número do telefone: ", "Informação inválida");
				fornecedorSelecionado.setTelefone(telefoneFornecedor);
			} else if (numFornecedor == 5) {
				String celularFornecedor;
				celularFornecedor = digitarStrApenasNumero("Informe o número do celular: ", "Informação inválida");
				fornecedorSelecionado.setCelular(celularFornecedor);
			} else if (numFornecedor == 6) {
				String cpfCnpjFornecedor;
				cpfCnpjFornecedor = digitarStrApenasNumero("Informe o número do CPF ou CNPJ: ", "Informação inválida");
				fornecedorSelecionado.setCpfCnpj(cpfCnpjFornecedor);
			} else {
				System.out.println("Opção inválida.");
			}
		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
	}
	
}
