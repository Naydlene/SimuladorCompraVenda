package simulador.compraevenda.java;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;




public class Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Categoria> ListCategorias; //ok
		ArrayList<Unidade> ListUnidade; //ok
		ArrayList<Fornecedores> ListFornecedores; //ok
		ArrayList<Produto> ListProdutos; //ok
		ArrayList<PessoaFisica> ListPessoaFisica;
		ArrayList<PessoaJuridica> ListPessoaJuridica;
		
		
		ArrayList<Venda> ListVendas = new ArrayList<>();
		
		
		try {
			ListCategorias = InicializaListCategorias();
		}catch(Exception e) {
			ListCategorias = new ArrayList<>();
		}
		try {
			ListUnidade = InicializaUnidades();
		}catch(Exception e) {
			ListUnidade = new ArrayList<>();
		}
		try {
			ListFornecedores = InicializaFornecedores();
		}catch(Exception e) {
			ListFornecedores = new ArrayList<>();
		}
		try {
			ListProdutos = InicializaProdutos(ListCategorias, ListUnidade, ListFornecedores);
		}catch(Exception e) {
			ListProdutos = new ArrayList<>();
		}
		try {
			ListPessoaFisica = InicializaPessoaFisica();
		}catch(Exception e) {
			ListPessoaFisica = new ArrayList<>();
		}
		try {
			ListPessoaJuridica = InicializaPessoaJuridica();
		}catch(Exception e) {
			ListPessoaJuridica = new ArrayList<>();
		}
			
		
		Usuario usuario = new Usuario();
		String novoUsuario = "a";
		usuario.setLogin(novoUsuario);
		String senha = "a";
		usuario.setSenha(senha);
		

		String stropcao;
		int opcao = 999;
		do {
			try {
				do {
					novoUsuario = receberStrNaoNula("Digite o usuário: ", "Informação inválida.");
					senha = receberStrNaoNula("Digite a senha: ", "Informação inválida.");
					if (!novoUsuario.equals(usuario.getLogin()) || !senha.equals(usuario.getSenha())) {
						System.err.println("Usuário ou senha incorretos.");
					}

				} while (!novoUsuario.equals(usuario.getLogin()) || !senha.equals(usuario.getSenha()));
				do {
					System.out.println("\nDigite: \n 1 - Cadastrar produtos.\n " + "2 - Cadastrar categorias.\n "
							+ "3 - Cadastrar clientes.\n " + "4 - Cadastrar fornecedores.\n "
							+ "5 - Efetuar compras(abastecimento de estoque).\n " + "6 - Efetuar venda.\n ");

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
						System.out.println(
								"É necessário ter pelo menos uma categoria e um fornecedor cadastrado para usufruir de cadastro de produtos.");
						stropcao2 = receberStrNaoNula(
								"1 - Listagem de produtos.\n2 - Inserção de produtos. \n3 - Alteração de produtos.",
								"Informação inválida.");
						try {
							opcao2 = Integer.parseInt(stropcao2);
						} catch (Exception e) {
							System.err.println("Opção inválida.");
						}
						if (opcao2 == 1) {
							// exibir lista de produtos.
							exibirListaProdutos(ListProdutos, 1);
						} else if (opcao2 == 2) {
							ListProdutos
									.add(cadastrarProduto(ListCategorias, ListFornecedores, ListProdutos, ListUnidade));
						} else if (opcao2 == 3) {
							alterarProduto(ListProdutos, ListCategorias, ListFornecedores);
						} else {
							System.err.println("Opção inválida.");
						}

						break;

					case 2:
						// (listagem, inserção e alteração);
						int opcao3 = 0;
						String strOpcao3;
						strOpcao3 = receberStrNaoNula(
								"1 - Listagem de categorias.\n2 - Inserção de categorias. \n3 - Alteração de categorias.",
								"Informação inválida.");
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
							System.err.println("Opção inválida.");
						}

						break;
					case 3:
						// (listagem, inserção e alteração);
						int opcao4 = 0;
						String stropcao4;
						stropcao4 = receberStrNaoNula(
								"1 - Cadastrar pessoa física." + "\n2 - Cadastrar pessoa jurídica",
								"Informação inválida.");
						try {
							opcao4 = Integer.parseInt(stropcao4);
						} catch (Exception e) {
							System.err.println("Opção inválida.");
						}

						if (opcao4 == 1) {
							int opcao5 = 0;
							String strOpcao5;
							strOpcao5 = receberStrNaoNula(
									"1 - Listagem de pessoas físicas.\n2 - Inserção de pessoas físicas. \n3 - Alteração de pessoas físicas.",
									"Informação inválida.");
							try {
								opcao5 = Integer.parseInt(strOpcao5);
							} catch (Exception e) {
								System.err.println("Opção inválida.");
							}
							if (opcao5 == 1) {
								exibirListaPessoaFisica(ListPessoaFisica, 1);
							} else if (opcao5 == 2) {
								ListPessoaFisica.add(cadastrarPessoaFisica(ListPessoaFisica, ListPessoaJuridica));
							} else if (opcao5 == 3) {
								alterarPessoaFisica(ListPessoaFisica);
							} else {
								System.err.println("Opção inválida.");
							}
						}
						if (opcao4 == 2) {
							int opcao6 = 0;
							String strOpcao6;
							System.out.println(
									"1 - Listagem de pessoas jurídicas.\n2 - Inserção de pessoas jurídicas. \n3 - Alteração de pessoas jurídicas.");
							strOpcao6 = input.nextLine();
							try {
								opcao6 = Integer.parseInt(strOpcao6);
							} catch (Exception e) {
								System.err.println("Opção inválida.");
							}
							if (opcao6 == 1) {
								exibirListaPessoaJuridica(ListPessoaJuridica, 1);
							} else if (opcao6 == 2) {
								ListPessoaJuridica.add(cadastrarPessoaJuridica(ListPessoaJuridica, ListPessoaFisica));
							} else if (opcao6 == 3) {
								alterarPessoaJuridica(ListPessoaJuridica);
							} else {
								System.err.println("Digite a informação correta.");
							}
						}
						break;
					case 4:
						// (listagem, inserção e alteração);
						int opcao7 = 0;
						String strOpcao7;
						strOpcao7 = receberStrNaoNula(
								"1 - Listagem de fornecedores.\n2 - Inserção de fornecedores. \n3 - Alteração de fornecedores.",
								"Informação inválida.");
						try {
							opcao7 = Integer.parseInt(strOpcao7);
						} catch (Exception e) {
							System.err.println("Opção inexistente.");
						}
						if (opcao7 == 1) {
							exibirListaFornecedores(ListFornecedores, 1);
						} else if (opcao7 == 2) {
							ListFornecedores.add(cadastrarFornecedores(ListFornecedores));
						} else if (opcao7 == 3) {

							alterarFornecedores(ListFornecedores);
						} else {
							System.err.println("Opção inválida.");
						}

						break;
					case 5:

						efetuarCompras(ListProdutos);
						break;

					case 6:
						ListVendas.add(efetuarVendas(ListProdutos, ListCategorias, ListPessoaFisica, ListPessoaJuridica,
								ListVendas));
					}

				} while (opcao != 0);
			} catch (Exception e) {
				System.out.println("Algo de errado não está certo\n" + e);
			}
		} while (opcao != 0);
	}

	static public ArrayList<PessoaJuridica> InicializaPessoaJuridica() throws SQLException {
		ArrayList<PessoaJuridica> ListPessoaJuridica = new ArrayList<>();
	    try {
	        Connection connection = ConectaBanco.criarConexao();
	        PreparedStatement statement = connection.prepareStatement
	        ("select p.*, pj.cnpj from pessoa p join pessoajuridica pj ON (p.id_pessoa = pj.id_pessoa)");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	PessoaJuridica pessoajuridica = new PessoaJuridica();
	        	pessoajuridica.setId(resultSet.getInt("id_pessoa"));
	        	pessoajuridica.setNome(resultSet.getString("nome"));
	        	pessoajuridica.setEmail(resultSet.getString("email"));
	        	pessoajuridica.setTelefone(resultSet.getString("telefone"));
	        	pessoajuridica.setCelular(resultSet.getString("celular"));
	        	pessoajuridica.setCnpj(resultSet.getString("cnpj"));
	        	pessoajuridica.setEndereco(new Endereco(resultSet.getString("rua"), 
	        			resultSet.getString("cep"), 
	        			resultSet.getString("bairro"),
	        			resultSet.getInt("num"),
	        			resultSet.getString("complemento"),
	        			resultSet.getString("cidade"),
	        			resultSet.getString("estado")
	        			));
	        	ListPessoaJuridica.add(pessoajuridica);
	        }
	        connection.close();
	    }catch(Exception e) {
	    	System.out.println("Não há Fornecedores salvas.");
	    }
	

	    return ListPessoaJuridica;
	}

	static public ArrayList<PessoaFisica> InicializaPessoaFisica() throws SQLException {
		ArrayList<PessoaFisica> ListPessoaFisica = new ArrayList<>();
	    try {
	        Connection connection = ConectaBanco.criarConexao();
	        PreparedStatement statement = connection.prepareStatement
	        ("select p.*, pf.cpf from pessoa p join pessoafisica pf ON (p.id_pessoa = pf.id_pessoa)");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	PessoaFisica pessoafisica = new PessoaFisica();
	        	pessoafisica.setId(resultSet.getInt("id_pessoa"));
	        	pessoafisica.setNome(resultSet.getString("nome"));
	        	pessoafisica.setEmail(resultSet.getString("email"));
	        	pessoafisica.setTelefone(resultSet.getString("telefone"));
	        	pessoafisica.setCelular(resultSet.getString("celular"));
	        	pessoafisica.setCpf(resultSet.getString("cpf"));
	        	pessoafisica.setEndereco(new Endereco(resultSet.getString("rua"), 
	        			resultSet.getString("cep"), 
	        			resultSet.getString("bairro"),
	        			resultSet.getInt("num"),
	        			resultSet.getString("complemento"),
	        			resultSet.getString("cidade"),
	        			resultSet.getString("estado")
	        			));
	        	ListPessoaFisica.add(pessoafisica);
	        }
	        connection.close();
	    }catch(Exception e) {
	    	System.out.println("Não há PessoasFisicas salvas.");
	    }
	

	    return ListPessoaFisica;
	}

	
	static public ArrayList<Produto> InicializaProdutos(ArrayList<Categoria> ListCategorias, ArrayList<Unidade> ListUnidade, ArrayList<Fornecedores> ListFornecedores) throws SQLException {
		ArrayList<Produto> ListProdutos = new ArrayList<Produto>();

	    try {
	        Connection connection = ConectaBanco.criarConexao();
	        PreparedStatement statement = connection.prepareStatement
	        ("SELECT * FROM produto");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	Produto produto = new Produto();
	        	produto.setId (resultSet.getInt("id_produto"));
	        	produto.setNome (resultSet.getString("nome"));
	        	produto.setPrecoVenda(resultSet.getDouble("precovenda"));
	        	produto.setQtde_estoque(resultSet.getInt("qtd_estoque"));
	        	produto.setQtd_produtos(resultSet.getInt("qtd_produtos"));
	        	produto.setCategoria(retornarCategoria(ListCategorias, resultSet.getInt("id_categoria")));
	        	produto.setFornecedores(retornarFornecedores(ListFornecedores, resultSet.getInt("id_fornecedores")));
	        	produto.setUnidade(retornarUnidades(ListUnidade, resultSet.getInt("id_unidade")));
	        	ListProdutos.add(produto);
	        }
	        connection.close();
	    }catch(Exception e) {
	    	System.out.println("Não há produtos salvas.");
	    }
	

	    return ListProdutos;
	}
	
	
	static public ArrayList<Unidade> InicializaUnidades() throws SQLException {
		ArrayList<Unidade> listaUnidade = new ArrayList<Unidade>();

	    try {
	        Connection connection = ConectaBanco.criarConexao();
	        PreparedStatement statement = connection.prepareStatement("SELECT id_unidade, nome FROM unidade");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	Unidade unidade = new Unidade();
	        	unidade.setId(resultSet.getInt("id_unidade"));
	        	unidade.setNome(resultSet.getString("nome"));
	        	listaUnidade.add(unidade);
	        }
	        connection.close();
	    }catch(Exception e) {
	    	System.out.println("Não há Unidades salvas.");
	    }
	

	    return listaUnidade;
	}
	
	static public ArrayList<Categoria> InicializaListCategorias() throws SQLException {
		ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();

	    try {
	        Connection connection = ConectaBanco.criarConexao();
	        PreparedStatement statement = connection.prepareStatement("SELECT id_categoria, descricao FROM categoria");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	Categoria categoria = new Categoria();
	        	categoria.setId(resultSet.getInt("id_categoria"));
	        	categoria.setDescricao(resultSet.getString("descricao"));
	        	listaCategoria.add(categoria);
	        }
	        connection.close();
	    }catch(Exception e) {
	    	System.out.println("Não há categorias salvas.");
	    }
	

	    return listaCategoria;
	}

	static public ArrayList<Fornecedores> InicializaFornecedores() throws SQLException {
		ArrayList<Fornecedores> ListFornecedores = new ArrayList<>();
	    try {
	        Connection connection = ConectaBanco.criarConexao();
	        PreparedStatement statement = connection.prepareStatement
	        ("SELECT id_fornecedores, nome, email, telefone, celular, cpfcnpj,"
	        + "rua, cep, bairro, num, complemento, cidade, estado FROM fornecedores");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	        	Fornecedores fornecedor = new Fornecedores();
	        	fornecedor.setId(resultSet.getInt("id_fornecedores"));
	        	fornecedor.setNome(resultSet.getString("nome"));
	        	fornecedor.setEmail(resultSet.getString("email"));
	        	fornecedor.setTelefone(resultSet.getString("telefone"));
	        	fornecedor.setCelular(resultSet.getString("celular"));
	        	fornecedor.setCpfCnpj(resultSet.getString("cpfcnpj"));
	        	fornecedor.setEndereco(new Endereco(resultSet.getString("rua"), 
	        			resultSet.getString("cep"), 
	        			resultSet.getString("bairro"),
	        			resultSet.getInt("num"),
	        			resultSet.getString("complemento"),
	        			resultSet.getString("cidade"),
	        			resultSet.getString("estado")
	        			));
	        	ListFornecedores.add(fornecedor);
	        }
	        connection.close();
	    }catch(Exception e) {
	    	System.out.println("Não há Fornecedores salvas.");
	    }
	

	    return ListFornecedores;
	}

	static private Venda efetuarVendas(ArrayList<Produto> ListProdutos, ArrayList<Categoria> ListCategorias,
			ArrayList<PessoaFisica> ListPessoaFisica, ArrayList<PessoaJuridica> ListPessoaJuridica,
			ArrayList<Venda> ListVendas) {
		Venda venda;
		ArrayList<ProdutoVendido> ListProdutosVendidos = new ArrayList<>();
		Produto produto;
		Categoria categoria;
		PessoaFisica pessoaFisica;
		PessoaJuridica pessoaJuridica;
		String resultado;
		String strPrecoTotal;
		int codProd;
		int codPessoaFisica;
		int codPessoaJuridica;
		int codPessoaselecionada=-1;
		double preco;
		double precoDesc=0;
		double desconto;
		double total = 0;
		double precoTotalDesc;
		int quantidade;
		int qtdItens;
		int idVenda;
		int tipoCliente;
		do {
			tipoCliente = digitarNumero("Informe o tipo de cliente: \n1 - Físico \n2 - Jurídico: \n", "Informação inválida");
		}while(tipoCliente != 1 && tipoCliente != 2);
			
		if (tipoCliente == 1) {
			do {
				if (!exibirListaPessoaFisica(ListPessoaFisica, 2))
					return null;
				codPessoaFisica = digitarNumero("Informe o código do cliente: ", "Informação inválida");
			} while (!confirmarPessoaFisica(ListPessoaFisica, codPessoaFisica));
			pessoaFisica = retornarPessoaFisica(ListPessoaFisica, codPessoaFisica);
			codPessoaselecionada = codPessoaFisica;
		} else if (tipoCliente == 2) {
			do {
				if (!exibirListaPessoaJuridica(ListPessoaJuridica, 2))
					return null;
				codPessoaJuridica = digitarNumero("Informe o código do cliente: ", "Informação inválida");
			} while (!confirmarPessoaJuridica(ListPessoaJuridica, codPessoaJuridica));
			pessoaJuridica = retornarPessoaJuridica(ListPessoaJuridica, codPessoaJuridica);
			codPessoaselecionada = codPessoaJuridica;
		}
		do {
			do {
				if (!exibirListaProdutos(ListProdutos, 2))
					return null;

				codProd = digitarNumero("Digite o código da mercadoria: ", "\nNúmero inválido.");
			} while (!confirmarProduto(ListProdutos, codProd));
			produto = retornarProduto(ListProdutos, codProd);
			System.out.println("O preço do produto é: " + produto.getPrecoVenda());
			do {
				qtdItens = digitarNumero("Informe a quantidade de itens: ", "\nQuantidade inválida.");
				
				if (qtdItens == 1) {
					System.out.println("Preço: " + produto.getPrecoVenda());
				} else if (qtdItens > 1) {
					System.out.println("Preço total: " + (produto.getPrecoVenda() * qtdItens));
				} else {
					System.err.println("Quantidade negativa.");
				}
			}while(qtdItens <= 0);
			preco = qtdItens * produto.getPrecoVenda();
			total = total + preco;
			
			quantidade = produto.getQtde_estoque() - qtdItens;
			if (quantidade >= 0) {
				produto.setQtde_estoque(quantidade);
				ListProdutosVendidos.add(new ProdutoVendido(ListVendas.size() + 1, codProd, codPessoaselecionada, qtdItens));
			} else {
				System.err.println("Não existe essa quantidade no estoque, abasteça o seu estoque.");
			}
			
		} while (perguntaSimNao("Deseja acrescentar mais algum produto? \n1 - sim. \n2 - não.", "Informação inválida"));
		
		do {
			desconto = numeroDouble("Informe o Desconto em porcentagem: ", "Informação incorreta");
			System.out.println("O desconto foi de: " +  desconto + "%" );
		
			if (desconto == 0) {
				precoDesc = 0;
				System.out.println("Não houve desconto.");
			} 
			else if(desconto < 0) {
				System.err.println("Desconto negativo invalido");
			}
			else {
				precoDesc = (desconto / 100);
				precoTotalDesc = (1 - precoDesc) * total;
				strPrecoTotal = converterDoubleStr(precoTotalDesc);
				System.out.println("Total com desconto: " + strPrecoTotal);
			}
			
		}while(desconto < 0);
	
		venda = new Venda((total - precoDesc), precoDesc, tipoCliente, ListVendas.size() + 1, "", ListProdutosVendidos);
		return venda;
	}

	static public void efetuarCompras(ArrayList<Produto> ListProdutos) {

		Produto produtoSelect;

		int quantidadeEstoque;
		int codigoProduto = 0;

		do {
			if (!exibirListaProdutos(ListProdutos, 1))
				return;
			codigoProduto = digitarNumero("Digite o código do produto que deseja abastecer: ", "Código incorreto.");
		} while (!confirmarProduto(ListProdutos, codigoProduto));
		produtoSelect = retornarProduto(ListProdutos, codigoProduto);
		System.out.println("Você selecionou o produto:");
		System.out.println(produtoSelect.dadosProdutos2());
		quantidadeEstoque = digitarNumero("Quantidade de produtos comprados: ", "Informação incorreta.");
		produtoSelect.setQtde_estoque(quantidadeEstoque + produtoSelect.getQtde_estoque());

	}

	static public Produto cadastrarProduto(ArrayList<Categoria> ListCategorias,
			ArrayList<Fornecedores> ListFornecedores, ArrayList<Produto> ListProdutos, ArrayList<Unidade> ListUnidade) {
		int id;
		int codFornecedor;
		int idUnidade = 0;
		int numUnidade;

		Categoria categoriaSelecionada;
		Fornecedores fornecedorSelec;
		Unidade unidadeSelecionada;

		if (ListCategorias.size() == 0 && ListFornecedores.size() == 0) {
			System.err.println("Listas de categoria e fornecedores vazias");
			return null;
		} else {
			if (ListCategorias.size() == 0) {
				System.err.println("Lista de categoria vazia");
				return null;
			} else if (ListFornecedores.size() == 0) {
				System.err.println("Lista de fornecedores vazia");
				return null;
			}
		}

		do {
			if (!exibirListaCategorias(ListCategorias))
				return null;
			id = digitarNumero("Informe o  código da categoria: ", "Informe o código correto.");
		} while (!confirmarCategoria(ListCategorias, id));
		categoriaSelecionada = retornarCategoria(ListCategorias, id);

		String nome = receberStrNaoNula("Informe o nome do produto: ", "Informação inválida.");
		do {
			if (!exibirListaFornecedores(ListFornecedores, 2))
				return null;
			codFornecedor = digitarNumero("Informe o código do fornecedor: ", "Informe o código correto");
		} while (!confirmarFornecedores(ListFornecedores, codFornecedor));
		fornecedorSelec = retornarFornecedores(ListFornecedores, codFornecedor);
		double preco = numeroDouble("Informe o preço do produto: ", "Preço do produto inválido.");
		int qtd_estoque = digitarNumero("Informe a quantidade de produtos: ", "Informação inválida");
		exibirListaUnidade(ListUnidade);
		do {
			numUnidade = digitarNumero("Informe o tipo de unidade:   ", "Inormação inválida.");

		} while (numUnidade < 1 || numUnidade > 4);
		unidadeSelecionada = retornarUnidades(ListUnidade, numUnidade);
		Produto produto = new Produto(categoriaSelecionada, ListProdutos.size() + 1, fornecedorSelec, nome, preco,
				qtd_estoque, unidadeSelecionada);

		return produto;
	}
	public static String converterDoubleStr(double precoDouble) {
	    /*Transformando um double em 2 casas decimais*/
	    DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais    
	    String string = fmt.format(precoDouble);
	    String[] part = string.split("[,]");
	    String preco = part[0]+"."+part[1];
	    return preco;
	}

	static public Categoria cadastrarCategoria(ArrayList<Categoria> ListCategorias) {

		String descricao = receberStrNaoNula("Informe a descrição: ", "Informação inválida.");
		Categoria categoria = new Categoria(ListCategorias.size() + 1, descricao);
		return categoria;

	}

	static public PessoaFisica cadastrarPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica, ArrayList<PessoaJuridica> ListPessoaJuridica) {
		String nome, rua, cep, bairro, complemento, cidade, estado, email, telefone, celular, cpf;

		nome = receberStrNaoNula("Informe o nome: ", "Informação inválida.");
		rua = receberStrNaoNula("Informe o nome da rua: ", "Informação inválida.");
		int intnum = digitarNumero("Digite o numero da residência: ", "Numero da residencia inválido");
		cep = digitarStrApenasNumero("Informe o CEP: ", "Número do CEP incorreto.");
		bairro = receberStrNaoNula("Informe o Bairro: ", "Informação inválida.");
		complemento = receberStrNaoNula("Informe o complemento: ", "Informação inválida.");
		cidade = receberStrNaoNula("Informe a cidade: ", "Informação inválida.");
		estado = receberStrNaoNula("Informe o estado: ", "Informação inválida.");
		email = receberStrNaoNula("Informe o e-mail", "Informação inválida.");
		telefone = digitarStrApenasNumero("Informe o número do seu telefone fixo: ", "Número do telefone inválido");
		celular = digitarStrApenasNumero("Informe o número do seu celular: ", "Número do celular inválido");
		cpf = digitarStrApenasNumero("Informe o seu CPF: ", "Número do celular inválido");

		Endereco endereco = new Endereco(rua, cep, bairro, intnum, complemento, cidade, estado);
		PessoaFisica pessoaFisica = new PessoaFisica(ListPessoaFisica.size()  + ListPessoaJuridica.size() +1, endereco, nome, email, telefone,
				celular, cpf);
		return pessoaFisica;

	}

	static public String receberStrNaoNula(String frase, String fraseErro) {
		String strDigitado;
		do {
			System.out.println(frase);
			strDigitado = input.nextLine();
			if (strDigitado.length() == 0) {
				System.out.println(fraseErro);
			}
		} while (strDigitado.length() == 0);
		return strDigitado;
	}

	static private boolean ehApenasNumero(String digitado, String fraseErro) {

		try {
			long n = Long.parseLong(digitado);
		} catch (Exception e) {
			System.err.println(fraseErro);
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
				System.err.println(fraseErro);
				tudoOk = false;
			}
		} while (!tudoOk);
		return dbdigitado;
	}

	static public PessoaJuridica cadastrarPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica, ArrayList<PessoaFisica> ListPessoaFisica) {

		boolean tudoOk;
		String nome, rua, strnum, cep, bairro, complemento, cidade, estado, email, telefone, celular, cnpj;

		nome = receberStrNaoNula("Informe o nome da pessoa ou o nome da empresa: ", "Informação inválida.");
		System.out.println("Informe o nome da rua: ");
		rua = input.nextLine();
		int intnum = digitarNumero("Informe o número da residência: ", "Número inválido.");
		cep = digitarStrApenasNumero("Informe o cep: ", "Número do CEP incorreto.");
		bairro = receberStrNaoNula("Informe o Bairro: ", "Informação inválida.");
		complemento = receberStrNaoNula("Informe o complemento: ", "Informação inválida.");
		cidade = receberStrNaoNula("Informe a cidade: ", "Informação inválida.");
		estado = receberStrNaoNula("Informe o estado: ", "Informação inválida.");
		email = receberStrNaoNula("Informe o e-mail", "Informação inválida.");
		telefone = digitarStrApenasNumero("Informe o número do telefone fixo: ", "Número do telefone inválido.");
		celular = digitarStrApenasNumero("Informe o número do celular: ", "Número do celular inválido.");
		cnpj = digitarStrApenasNumero("Informe o CNPJ: ", "Número do CNPJ inválido.");

		Endereco endereco = new Endereco(rua, cep, bairro, intnum, complemento, cidade, estado);
		PessoaJuridica pessoaJuridica = new PessoaJuridica(ListPessoaJuridica.size() + ListPessoaFisica.size()+ 1, endereco, nome, email,
				telefone, celular, cnpj);
		return pessoaJuridica;

	}

	static public Fornecedores cadastrarFornecedores(ArrayList<Fornecedores> ListFornecedores) {

		String nomeFornecedor, ruaFornecedor, cepFornecedor, bairroFornecedor, complementoFornecedor, cidadeFornecedor,
				estadoFornecedor, emailFornecedor, telefoneFornecedor, celularFornecedor, cpfCnpjFornecedor;

		nomeFornecedor = receberStrNaoNula("Informe o nome: ", "Informação inválida.");
		ruaFornecedor = receberStrNaoNula("Informe o nome da rua: ", "Informação inválida.");
		int intnumFornecedor = digitarNumero("Digite o numero da residência: ", "Numero inválido");
		cepFornecedor = digitarStrApenasNumero("Informe o CEP: ", "Número do CEP incorreto.");
		bairroFornecedor = receberStrNaoNula("Informe o Bairro: ", "Informação inválida.");
		complementoFornecedor = receberStrNaoNula("Informe o complemento: ", "Informação inválida.");
		cidadeFornecedor = receberStrNaoNula("Informe a cidade: ", "Informação inválida.");
		estadoFornecedor = receberStrNaoNula("Informe o estado: ", "Informação inválida.");
		emailFornecedor = receberStrNaoNula("Informe o e-mail", "Informação inválida.");
		telefoneFornecedor = digitarStrApenasNumero("Informe o número do telefone fixo: ",
				"Número do telefone inválido");
		celularFornecedor = digitarStrApenasNumero("Informe o número do celular: ", "Número inválido");
		cpfCnpjFornecedor = digitarStrApenasNumero("Informe o CPF ou CNPJ: ", "Número inválido");
		Endereco endereco = new Endereco(ruaFornecedor, cepFornecedor, bairroFornecedor, intnumFornecedor,
				complementoFornecedor, cidadeFornecedor, estadoFornecedor);
		Fornecedores fornecedores = new Fornecedores(ListFornecedores.size() + 1, endereco, cpfCnpjFornecedor,
				nomeFornecedor, emailFornecedor, telefoneFornecedor, celularFornecedor);
		return fornecedores;
	}

	static private boolean exibirListaPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica, int opcao) {

		if (ListPessoaJuridica.size() == 0) {
			System.err.println("Lista de pessoa juridica vazia.");
			return false;
		}
		for (PessoaJuridica j : ListPessoaJuridica) {
			System.out.println("\nPessoa Juridica: ");
			if (opcao == 1) {
				System.out.println(j.dadosPessoaJuridica());
			} else if (opcao == 2) {
				System.out.println(j.dadosPessoaJuridica2());
			}

		}
		return true;
	}

	static private boolean exibirListaPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica, int opcao) {

		if (ListPessoaFisica.size() == 0) {
			System.err.println("Lista de pessoa fisica vazia.");
			return false;
		}
		for (PessoaFisica f : ListPessoaFisica) {
			System.out.println("\nPessoa Física: ");
			if (opcao == 1) {
				System.out.println(f.dadosPessoaFisica());
			} else if (opcao == 2) {
				System.out.println(f.dadosPessoaFisica2());
			}

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

	static private boolean exibirListaProdutos(ArrayList<Produto> ListProdutos, int opcao) {

		if (ListProdutos.size() == 0) {
			System.err.println("Lista de Produtos vazia.");
			return false;
		}
		for (Produto p : ListProdutos) {
			System.out.println("\nProduto: ");
			if (opcao == 1) {
				System.out.println(p.dadosProdutos());
			} else if (opcao == 2) {
				System.out.println(p.dadosProdutos2());
			}

		}
		return true;
	}

	static private boolean exibirListaFornecedores(ArrayList<Fornecedores> ListFornecedores, int opcao) {

		if (ListFornecedores.size() == 0) {
			System.err.println("Lista de fornecedores vazia.");
			return false;
		}
		for (Fornecedores fo : ListFornecedores) {
			System.out.println("\nFornecedor: ");
			if (opcao == 1) {
				System.out.println(fo.dadosFornecedores());
			} else if (opcao == 2) {
				System.out.println(fo.dadosFornecedores2());
			}

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

	static private boolean exibirListaUnidade(ArrayList<Unidade> ListUnidade) {

		if (ListUnidade.size() == 0) {
			System.err.println("Lista unidades vazia.");
			return false;
		}
		for (Unidade u : ListUnidade) {
			System.out.println("Unidade: ");
			System.out.println(u.dadosUnidade());
		}
		return true;
	}

	static private Unidade retornarUnidades(ArrayList<Unidade> ListUnidade, int idUnidade) {
		for (Unidade u : ListUnidade) {
			if (u.getId() == idUnidade)
				return u;
		}
		return null;
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

	static private void alterarProduto(ArrayList<Produto> ListProdutos, ArrayList<Categoria> ListCategorias,
			ArrayList<Fornecedores> ListFornecedores) {
		int cod;
		Produto produtoSelecionado;
		Categoria categoriaSelecionada;
		Fornecedores fornecedorSelecionado;
		String novoNome;
		double newprecoVenda;
		int newqtde_estoque;

		do {
			if (!exibirListaProdutos(ListProdutos, 1))
				return;
			cod = digitarNumero("Informe o código do produto que vc deseja alterar: ", "Informe o código correto.");
		} while (!confirmarProduto(ListProdutos, cod));
		produtoSelecionado = retornarProduto(ListProdutos, cod);
		System.out.println("Você selecionou o produto:");
		System.out.println(produtoSelecionado.dadosProdutos());
		System.out.println("O que deseja alterar nesse produto?");
		do {
			int info = digitarNumero(
					"Digite:\n 1 - Categoria.\n 2 - Fornecedor \n 3 - nome\n 4 - precoVenda\n 5 - qtde_estoque",
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
				int novoFornecedor;
				do {
					if (!exibirListaFornecedores(ListFornecedores, 2))
						return;
					novoFornecedor = digitarNumero("Informe o novo código do Fornecedor", "Informe o código correto.");
				} while (!confirmarFornecedores(ListFornecedores, novoFornecedor));
				fornecedorSelecionado = retornarFornecedores(ListFornecedores, novoFornecedor);
				System.out.println("Você selecionou o fornecedor: ");
				System.out.println(fornecedorSelecionado.dadosFornecedores2());
				produtoSelecionado.setFornecedores(fornecedorSelecionado);
			} else if (info == 3) {

				novoNome = receberStrNaoNula("Informe o novo nome para o produto: ", "Informação inválida.");
				produtoSelecionado.setNome(novoNome);
			} else if (info == 4) {
				newprecoVenda = numeroDouble("Informe o novo preço do produto: ", "Informação inválida");
				produtoSelecionado.setPrecoVenda(newprecoVenda);
			} else if (info == 5) {
				newqtde_estoque = digitarNumero("Informe a quantidade de estoque do produto: ", "Informação inválida");
				produtoSelecionado.setQtde_estoque(newqtde_estoque);
			}

		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));

	}

	static private boolean perguntaSimNao(String frase, String fraseErro) {
		int simNao;
		do {
			simNao = digitarNumero(frase, fraseErro);
			if (simNao != 1 && simNao != 2) {
				System.err.println("Opção inválida.");
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
		novaDescricao = receberStrNaoNula("Informe a nova descrição: ", "Informação inválida.");
		categoriaSelecionada.setDescricao(novaDescricao);

		return;
	}

	static private void alterarPessoaFisica(ArrayList<PessoaFisica> ListPessoaFisica) {
		int idFisica;
		PessoaFisica pessoaFisicaSelecionada;
		Endereco enderecoAux;
		do {
			if (!exibirListaPessoaFisica(ListPessoaFisica, 1))
				return;

			idFisica = digitarNumero("Informe o código da pessoa que você deseja alterar: ",
					"Informe o código correto.");
		} while (!confirmarPessoaFisica(ListPessoaFisica, idFisica));
		pessoaFisicaSelecionada = retornarPessoaFisica(ListPessoaFisica, idFisica);
		System.out.println("Você selecionou a pessoa: ");
		System.out.println(pessoaFisicaSelecionada.dadosPessoaFisica());
		System.out.println("O que deseja alterar nesta pessoa?");

		do {
			int numFis = digitarNumero(
					"Digite:\n 1 - Nome. \n 2 - Endereço.\n 3 - E-mail.\n 4 - Telefone.\n 5 - Celular.\n 6 - CPF.",
					"Informação incorreta.");
			if (numFis == 1) {

				String nome;
				nome = receberStrNaoNula("Informe o nome: ", "Informação inválida.");
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
						rua = receberStrNaoNula("Informe o nome da rua: ", "Informação inválida.");
						enderecoAux.setRua(rua);
					} else if (escolha == 2) {
						numEnde = digitarNumero("Informe o número: ", "Informação inválida");
						enderecoAux.setNum(numEnde);
					} else if (escolha == 3) {
						cepEnde = digitarStrApenasNumero("Informe o CEP: ", "Informação inválida");
						enderecoAux.setCep(cepEnde);
					} else if (escolha == 4) {
						bairroEnde = receberStrNaoNula("Informe o bairro: ", "Informação inválida.");
						enderecoAux.setBairro(bairroEnde);
					} else if (escolha == 5) {
						cidadeEnde = receberStrNaoNula("Informe a cidade: ", "Informação inválida.");
						enderecoAux.setCidade(cidadeEnde);
					} else if (escolha == 6) {
						estadoEnde = receberStrNaoNula("Informe o estado: ", "Informação inválida.");
						enderecoAux.setEstado(estadoEnde);
					} else if (escolha == 7) {
						complementoEnde = receberStrNaoNula("Informe o complemento: ", "Informação inválida.");
						enderecoAux.setComplemento(complementoEnde);
					}
				} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida."));
			} else if (numFis == 3) {
				String novoEmail;
				novoEmail = receberStrNaoNula("Informe o e-mail: ", "Informação inválida");
				pessoaFisicaSelecionada.setEmail(novoEmail);
			} else if (numFis == 4) {
				String novoTelefone;
				novoTelefone = digitarStrApenasNumero("Informe o número do telefone: ", "Informação inválida.");
				pessoaFisicaSelecionada.setTelefone(novoTelefone);
			} else if (numFis == 5) {
				String novoCelular;
				novoCelular = digitarStrApenasNumero("Informe o número do celular: ", "Informação inválida.");
				pessoaFisicaSelecionada.setCelular(novoCelular);
			} else if (numFis == 6) {
				String novoCpf;
				novoCpf = digitarStrApenasNumero("Informe o número do CPF: ", "Informação inválida.");
				pessoaFisicaSelecionada.setCpf(novoCpf);
			} else {
				System.err.println("Opção inválida.");
			}
		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
	}

	static private void alterarPessoaJuridica(ArrayList<PessoaJuridica> ListPessoaJuridica) {
		int idJuridica;
		PessoaJuridica pessoaJuridicaSelecionada;
		Endereco enderecoAuxiliar;
		do {
			if (!exibirListaPessoaJuridica(ListPessoaJuridica, 1))
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
				nomeJuridica = receberStrNaoNula("Informe o nome que deseja: ", "Informação inválida");
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
						ruaJuridica = receberStrNaoNula("Informe o nome da rua: ", "Informação inválida");
						enderecoAuxiliar.setRua(ruaJuridica);
					} else if (escolha2 == 2) {
						numJuridica = digitarNumero("Informe o número da residência: ", "Informação inválida");
						enderecoAuxiliar.setNum(numJuridica);
					} else if (escolha2 == 3) {
						cepJuridica = digitarStrApenasNumero("Informe o CEP: ", "Informação inválida");
						enderecoAuxiliar.setCep(cepJuridica);
					} else if (escolha2 == 4) {
						bairroJuridica = receberStrNaoNula("Informe o bairro: ", "Informação inválida");
						enderecoAuxiliar.setBairro(bairroJuridica);
					} else if (escolha2 == 5) {
						cidadeJuridica = receberStrNaoNula("Informe a cidade: ", "Informação inválida");
						enderecoAuxiliar.setCidade(cidadeJuridica);
					} else if (escolha2 == 6) {
						estadoJuridica = receberStrNaoNula("Informe o estado: ", "Informação inválida");
						enderecoAuxiliar.setEstado(estadoJuridica);
					} else if (escolha2 == 7) {
						complementoJuridica = receberStrNaoNula("Informe o complemento: ", "Informação inválida");
						enderecoAuxiliar.setComplemento(complementoJuridica);
					}
				} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
			} else if (numJuri == 3) {
				String novoEmail;
				novoEmail = receberStrNaoNula("Informe o e-mail: ", "Informação inválida");
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
				System.err.println("Opção inválida.");
			}
		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
	}

	static private void alterarFornecedores(ArrayList<Fornecedores> ListFornecedores) {
		int idFornecedores;
		Fornecedores fornecedorSelecionado;
		Endereco enderecoAuxrFornecedor;
		do {
			if (!exibirListaFornecedores(ListFornecedores, 1))
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
						ruaFornecedor = receberStrNaoNula("Informe o nome da rua: ", "Informação inválida");
						enderecoAuxrFornecedor.setRua(ruaFornecedor);
					} else if (escolhaFornecedor == 2) {
						numeroFornecedor = digitarNumero("Informe o número da empresa: ", "Informação inválida");
						enderecoAuxrFornecedor.setNum(numeroFornecedor);
					} else if (escolhaFornecedor == 3) {
						cepFornecedor = digitarStrApenasNumero("Informe o CEP: ", "Informação inválida");
						enderecoAuxrFornecedor.setCep(cepFornecedor);
					} else if (escolhaFornecedor == 4) {
						bairroFornecedor = receberStrNaoNula("Informe o bairro: ", "Informação inválida");
						enderecoAuxrFornecedor.setBairro(bairroFornecedor);
					} else if (escolhaFornecedor == 5) {
						cidadeFornecedor = receberStrNaoNula("Informe a cidade: ", "Informação inválida");
						enderecoAuxrFornecedor.setCidade(cidadeFornecedor);
					} else if (escolhaFornecedor == 6) {
						estadoFornecedor = receberStrNaoNula("Informe o estado: ", "Informação inválida");
						enderecoAuxrFornecedor.setEstado(estadoFornecedor);
					} else if (escolhaFornecedor == 7) {
						complementoFornecedor = receberStrNaoNula("Informe o complemento: ", "Informação inválida");
						enderecoAuxrFornecedor.setComplemento(complementoFornecedor);
					}
				} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
			} else if (numFornecedor == 3) {
				String emailFornecedor;
				emailFornecedor = receberStrNaoNula("Informe o e-mail: ", "Informação inválida");
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
				System.err.println("Opção inválida.");
			}
		} while (perguntaSimNao("Deseja alterar mais coisas? \n1 - sim. \n2 - não.", "Informação inválida"));
	}

}
