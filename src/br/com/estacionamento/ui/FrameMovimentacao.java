package br.com.estacionamento.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.estacionamento.dao.MovimentacaoDao;
import br.com.estacionamento.dao.ValoresDao;
import br.com.estacionamento.model.Movimentacao;
import br.com.estacionamento.util.Util;



public class FrameMovimentacao 
{

	//ATRIBUTOS EM ESCOPO DE CLASSE 
	private JLabel labelTitulo;
	private JLabel labelSubtituloEntrada;
	private JLabel labelPlacaEntrada;
	private JTextField textPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JTextField textModeloEntrada;
	private JButton buttonRegistrarEntrada;
	private JTable tableRegistros; 
	private DefaultTableModel modelTableRegistros;
	private JScrollPane scrollTableRegistros;
	private JLabel labelSubtituloSaida;
	private JLabel labelPlacaSaida;
	private JTextField textPlacaSaida;
	private JTextField textCodigo;
	private JButton buttonBuscar;
	private JLabel labelModeloSaida;
	private JTextField textModeloSaida;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempoTotal;
	private JTextField textTempoTotal;
	private JLabel labelValorPagar;
	private JTextField textValorPagar;
	private JButton buttonEfeturarSaida;
	private JButton buttonFecharSistema;

	
	
	public void criarTela()
	{
		// FONTES E CORES UTILIZADAS
		  Font fontLabelTitulo = new Font("Ebrima", Font.BOLD, 30);
		  Font fontLabelSubtitulo = new Font("Ebrima", Font.BOLD, 20);
		  Font fontLabelButton = new Font("Ebrima", Font.PLAIN, 15);
		  Font fontLabelsNormais = new Font("Ebrima", Font.PLAIN, 15);
		  Font fontTextField = new Font("Ebrima", Font.PLAIN, 15);
		  Font fontTable = new Font("Ebrima", Font.PLAIN, 13);
		  //Font fontTabletitle = new Font("Ebrima", Font.BOLD, 15);
		
		//CRIANDO FRAME
		  JFrame frameRegistros = new JFrame();
		  frameRegistros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frameRegistros.setTitle("Estacionamento - Registro de movimentações");
		  frameRegistros.setSize(900,800);
		  frameRegistros.setResizable(false);
		  frameRegistros.setLayout(null);
		  frameRegistros.getContentPane().setBackground(Color.LIGHT_GRAY);
		  
		//CRIANDO TÍTULO
		  labelTitulo = new JLabel();
		  labelTitulo.setBounds(20, 10, 500, 50);
		  labelTitulo.setText("Estacionamento do Severino!");
		  labelTitulo.setFont(fontLabelTitulo);
		  
		//CRIANDO SUBTÍTULO DE ENTRADA
		  labelSubtituloEntrada = new JLabel();
		  labelSubtituloEntrada.setBounds(20, 80, 100, 30); //20 padrão | 10+50+20espaço | normal | normal
		  labelSubtituloEntrada.setText("ENTRADA");
		  labelSubtituloEntrada.setFont(fontLabelSubtitulo);
		  
		//CRIANDO LABEL PLACA ENTRADA
		  labelPlacaEntrada = new JLabel();
		  labelPlacaEntrada.setBounds(20, 120, 50, 30); //20 padrão | 80+30+10espaço | normal | normal
		  labelPlacaEntrada.setText("Placa:");
		  labelPlacaEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD PLACA ENTRADA
		  textPlacaEntrada = new JTextField();
		  textPlacaEntrada.setBounds(20, 155, 200, 30); // 20 padrão | 120+30+5espaço | normal | normal
		  textPlacaEntrada.setFont(fontTextField);
		  
		//CRIANDO LABEL MODELO ENTRADA
		  labelModeloEntrada = new JLabel();
		  labelModeloEntrada.setBounds(270, 120, 90, 30); //20padrão + 200(larguratxtfield) + 50 espaço | 80+30+10espaço | normal | normal
		  labelModeloEntrada.setText("Modelo:");
		  labelModeloEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD MODELO ENTRADA
		  textModeloEntrada = new JTextField();
		  textModeloEntrada.setBounds(270, 155, 200, 30); // 270 padrão do seu label | 120+30+5espaço | normal | normal
		  textModeloEntrada.setFont(fontTextField);
		  
		//CRIANDO BUTTON ENTRAR
		  buttonRegistrarEntrada = new JButton();
		  buttonRegistrarEntrada.setBounds(520, 150, 150, 40); //270 +200larguratxtrfield + 50espaço | 120 +30+5espaço | normal | normal
		  buttonRegistrarEntrada.setFont(fontLabelButton);
		  buttonRegistrarEntrada.setText("REG. ENTRADA");
		  
		//CRIANDO MODELO PARA TABELA
		   modelTableRegistros = new DefaultTableModel();
		  
		  //Colunas
		    modelTableRegistros.addColumn("CÓDIGO");
		    modelTableRegistros.addColumn("PLACA");
		    modelTableRegistros.addColumn("MODELO");
		    modelTableRegistros.addColumn("DATA ENTRADA");
		    
		  //linhas
		    
//		    String[] infotabela = {"A1B2C3D4","ERO-1354","SPACEFOX","28/06/2021"};
//		    modelTableRegistros.addRow(infotabela);
		    
		    MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
			ArrayList<Movimentacao> movimentacoes = movimentacaoDao.listarMovimentacoes(); //clientes recebe a lista de clientes vindo do mét de Dao
			  
			  for (Movimentacao movimentacao : movimentacoes) //cria um cliente e guarda nele o conteúdo de um item da lista clientes. A cada volta, um cliente diferente da lista é guardado no cliente. || os : é só um separador
			  {
				  String[] vetorMovimentacao= 
					  {
						   movimentacao.getCodigo(),
						   movimentacao.getPlaca(),
						   movimentacao.getModelo(),
						   movimentacao.getDataEntrada().format(movimentacao.getformatoData())
					  }; //vetor que representa uma linha da tabela
				
				  modelTableRegistros.addRow(vetorMovimentacao);
			  }
		    
		//CRIANDO TABELA
		  //Instanciando
		    tableRegistros = new JTable(modelTableRegistros);
		    tableRegistros.setFont(fontTable);
		    tableRegistros.getTableHeader().setFont(fontTable);
		    tableRegistros.setRowHeight(20);
		    
		    
		  //Organizando as colunas
		    tableRegistros.getTableHeader().setReorderingAllowed(false);
		    tableRegistros.getColumnModel().getColumn(0).setPreferredWidth(100);
		    tableRegistros.getColumnModel().getColumn(1).setPreferredWidth(100);
		    tableRegistros.getColumnModel().getColumn(2).setPreferredWidth(130);
		    tableRegistros.getColumnModel().getColumn(3).setPreferredWidth(120);
		  
		//CRIANDO SCROLL
		  scrollTableRegistros = new JScrollPane(tableRegistros);
		  scrollTableRegistros.setBounds(20, 210, 450, 200);// 20padrao | 150+40+20espaço | 450 | 200
		  
		//CRIANDO LABEL SUBTITULO SAIDA
		  labelSubtituloSaida = new JLabel();
		  labelSubtituloSaida.setBounds(20, 460, 100, 30); //20 padrão | 210+200+50espaço| normal | normal
		  labelSubtituloSaida.setText("SAÍDA");
		  labelSubtituloSaida.setFont(fontLabelSubtitulo);
		  
		//CRIANDO LABEL PLACA SAÍDA
		  labelPlacaSaida = new JLabel();
		  labelPlacaSaida.setBounds(20, 500, 50, 30); //20 padrão | 460+30+10espaço | normal | normal
		  labelPlacaSaida.setText("Placa:");
		  labelPlacaSaida.setFont(fontLabelsNormais);
		
		//CRIANDO TEXT FIELD PLACA SAÍDA
		  textPlacaSaida = new JTextField();
		  textPlacaSaida.setBounds(20, 535, 200, 30); // 20 padrão | 500+30+5espaço | normal | normal
		  textPlacaSaida.setFont(fontTextField);
		  
		//CRIANDO BUTTON BUSCAR
		  buttonBuscar = new JButton();
		  buttonBuscar.setBounds(240, 530, 100, 40); // 20+200+20espaço | 500+30 | normal | normal
		  buttonBuscar.setFont(fontLabelButton);
		  buttonBuscar.setText("BUSCAR"); 
		  
		//CRIANDO LABEL MODELO SAÍDA
		  labelModeloSaida = new JLabel();
		  labelModeloSaida.setBounds(20, 580, 90, 30); //20padrão | 535+30+15espaço | normal | normal
		  labelModeloSaida.setText("Modelo:");
		  labelModeloSaida.setFont(fontLabelsNormais);
		  
		//CRIANDO TXT FIELD MODELO SAIDA
		  textModeloSaida = new JTextField();
		  textModeloSaida.setBounds(20, 610, 200, 30); // 20 padrão | 580+30 | normal | normal
		  textModeloSaida.setFont(fontTextField);
		  
		//CRIANDO LABEL DATA ENTRADA
		  labelDataEntrada = new JLabel();
		  labelDataEntrada.setBounds(230, 580, 100, 30); //20+200(textfield anterior)+10espaço | 535+30+15espaço | normal | normal
		  labelDataEntrada.setText("Data entrada:");
		  labelDataEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TXT FIELD DATA ENTRADA
		  textDataEntrada = new JTextField();
		  textDataEntrada.setBounds(230, 610, 110, 30); // 230(padrão da label) | 580+30 | normal | normal
		  textDataEntrada.setFont(fontTextField);
		  
		//CRIANDO LABEL HORA ENTRADA
		  labelHoraEntrada = new JLabel();
		  labelHoraEntrada.setBounds(350, 580, 110, 30); //340(textfield anterior)+10espaço | 535+30+15espaço | normal | normal
		  labelHoraEntrada.setText("Hora Entrada:");
		  labelHoraEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD HORA ENTRADA
		  textHoraEntrada = new JTextField();
		  textHoraEntrada.setBounds(350, 610, 110, 30); // 350(padrão da label) | 580+30 | normal | normal
		  textHoraEntrada.setFont(fontTextField);
		  
		//CRIANDO LABEL DATA SAÍDA
		  labelDataSaida = new JLabel();
		  labelDataSaida.setBounds(470, 580, 110, 30); //460(textfield anterior)+10espaço | 535+30+15espaço | normal | normal
		  labelDataSaida.setText("Data Saída:");
		  labelDataSaida.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD DATA SAÍDA
		  textDataSaida = new JTextField();
		  textDataSaida.setBounds(470, 610, 110, 30); // 470(padrão da label) | 580+30 | normal | normal
		  textDataSaida.setFont(fontTextField);
		  
		//CRIANDO LABEL HORA SAÍDA
		  labelHoraSaida = new JLabel();
		  labelHoraSaida.setBounds(590, 580, 110, 30); //580(textfield anterior (470+110))+10espaço | 535+30+15espaço | normal | normal
		  labelHoraSaida.setText("Hora Saída:");
		  labelHoraSaida.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD HORA SAÍDA
		  textHoraSaida = new JTextField();
		  textHoraSaida.setBounds(590, 610, 110, 30); // 580(padrão da label)+10espaço | 580+30 | normal | normal
		  textHoraSaida.setFont(fontTextField);

		//CRIANDO LABEL TEMPO TOTAL
		  labelTempoTotal = new JLabel();
		  labelTempoTotal.setBounds(710, 580, 110, 30); //700(textfield anterior (590+110))+10espaço | 535+30+15espaço | normal | normal
		  labelTempoTotal.setText("Tempo Total:");
		  labelTempoTotal.setFont(fontLabelsNormais);
		  
		//CRIANDO TXT FIELD TEMPO TOTAL
		  textTempoTotal = new JTextField();
		  textTempoTotal.setBounds(710, 610, 110, 30); // 580(padrão da label)+10espaço | 580+30 | normal | normal
		  textTempoTotal.setFont(fontTextField);
		  
		//CRIANDO LABEL TOTAL A PAGAR
		  labelValorPagar = new JLabel();
		  labelValorPagar.setBounds(20, 680, 110, 30); //20 padrão | 610+30+40espaço| normal | normal
		  labelValorPagar.setText("Valor Total:");
		  labelValorPagar.setFont(fontLabelSubtitulo);
		  
		//CRIANDO TXT FIELD TOTAL A PAGAR
		  textValorPagar = new JTextField();
		  textValorPagar.setBounds(150, 670, 170, 50); // 20 PADRÃO + 110 LABEL + 20ESPAÇO | padrão label - 10 | normal | normal
		  textValorPagar.setFont(fontLabelTitulo);
		  textValorPagar.setBackground(Color.GREEN);
		
		//CRIANDO BUTTON EFETUAR SAÍDA
		  buttonEfeturarSaida = new JButton();
		  buttonEfeturarSaida.setBounds(400, 670, 150, 60); //150 +170larguratxtrfield + 80espaço | 610+30+40espaço| normal | normal
		  buttonEfeturarSaida.setFont(fontLabelButton);
		  buttonEfeturarSaida.setText("Reg. Saída!");
		  
		//CRIANDO BUTTON FECHAR APP
		  buttonFecharSistema = new JButton();
		  buttonFecharSistema.setBounds(670, 680, 150, 50); //400 +150larguratxtrfield + 120espaço | 610+30+40espaço| normal | normal
		  buttonFecharSistema.setFont(fontLabelButton);
		  buttonFecharSistema.setText("Fechar Sistema");
		  buttonFecharSistema.setBackground(Color.RED);
		  
		
		  
		//CRIANDO TEXT OCULTO CÓDIGO
		  textCodigo = new JTextField();
		  
		//ADICIONANDO À TELA
		  frameRegistros.getContentPane().add(labelTitulo);
		  frameRegistros.getContentPane().add(labelSubtituloEntrada);
		  frameRegistros.getContentPane().add(labelPlacaEntrada);
		  frameRegistros.getContentPane().add(textPlacaEntrada);
		  frameRegistros.getContentPane().add(labelModeloEntrada);
		  frameRegistros.getContentPane().add(textModeloEntrada);
		  frameRegistros.getContentPane().add(buttonRegistrarEntrada);
		  frameRegistros.getContentPane().add(scrollTableRegistros);
		  frameRegistros.getContentPane().add(labelSubtituloSaida);
		  frameRegistros.getContentPane().add(labelPlacaSaida);
		  frameRegistros.getContentPane().add(textPlacaSaida);
		  frameRegistros.getContentPane().add(buttonBuscar);
		  frameRegistros.getContentPane().add(labelModeloSaida);
		  frameRegistros.getContentPane().add(textModeloSaida);
		  frameRegistros.getContentPane().add(labelDataEntrada);
		  frameRegistros.getContentPane().add(textDataEntrada);
		  frameRegistros.getContentPane().add(labelHoraEntrada);
		  frameRegistros.getContentPane().add(textHoraEntrada);
		  frameRegistros.getContentPane().add(labelDataSaida);
		  frameRegistros.getContentPane().add(textDataSaida);
		  frameRegistros.getContentPane().add(labelHoraSaida);
		  frameRegistros.getContentPane().add(textHoraSaida);
		  frameRegistros.getContentPane().add(labelTempoTotal);
		  frameRegistros.getContentPane().add(textTempoTotal);
		  frameRegistros.getContentPane().add(labelValorPagar);
		  frameRegistros.getContentPane().add(textValorPagar);
		  frameRegistros.getContentPane().add(buttonEfeturarSaida);
		  frameRegistros.getContentPane().add(buttonFecharSistema);
		  frameRegistros.getContentPane().add(textCodigo);
		  //frameRegistros.getContentPane().add();
		  frameRegistros.setVisible(true);		  
		  
		  
		  
		//CRIANDO LISTENER BOTÃO REGISTAR ENTRADA
		  
		  buttonRegistrarEntrada.addActionListener(new ActionListener() 
		  {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (validarFormularioEntrada())
				{
					Movimentacao movimentacao = new Movimentacao();
					movimentacao.setCodigo(Util.gerarCodigo());
					movimentacao.setPlaca(textPlacaEntrada.getText().toUpperCase());
					movimentacao.setModelo(textModeloEntrada.getText().toUpperCase());
					movimentacao.setDataEntrada(LocalDate.now());
					movimentacao.setHoraEntrada(LocalTime.now());

					MovimentacaoDao dao = new MovimentacaoDao(movimentacao);
					dao.salvarMovimentacaoEntrada();
					
					JOptionPane.showMessageDialog(null, "Operação com carro de placa " + movimentacao.getPlaca() + " realizada com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
					
					limparFormulario();
					
				}
				
				else 
				{
					JOptionPane.showMessageDialog 
					(
						null,
						"Você deve preencher todos os campos",
						"Atenção", //titulo da tela
						JOptionPane.WARNING_MESSAGE //simbolo que aparecerá na tela
					);
				}
				
			}
			
		  });
		  
		  
		//CRIANDO LISTENER BOTÃO BUSCAR
		  
		  buttonBuscar.addActionListener(new ActionListener() 
		  {
			
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					String placaBusca = textPlacaSaida.getText();
					
					
					MovimentacaoDao dao = new MovimentacaoDao();
					Movimentacao movimentacaoBuscaDao = dao.buscarMovimentacao(placaBusca);
					ValoresDao valoresDao = new ValoresDao();
					valoresDao.registrarValorHoras(movimentacaoBuscaDao);
					
					movimentacaoBuscaDao.setValorPagar();
					System.out.println(movimentacaoBuscaDao.getCodigo());
					textCodigo.setText(movimentacaoBuscaDao.getCodigo());
					textModeloSaida.setText(movimentacaoBuscaDao.getModelo());
					textDataEntrada.setText(movimentacaoBuscaDao.getDataEntrada().format(movimentacaoBuscaDao.getformatoData()));
					textHoraEntrada.setText(movimentacaoBuscaDao.getHoraEntrada().format(movimentacaoBuscaDao.getFormatoHora()));
					textDataSaida.setText(movimentacaoBuscaDao.getDataSaida().format(movimentacaoBuscaDao.getformatoData()));
					textHoraSaida.setText(movimentacaoBuscaDao.getHoraSaida().format(movimentacaoBuscaDao.getFormatoHora()));
					textTempoTotal.setText(movimentacaoBuscaDao.getTempoTotal().format(movimentacaoBuscaDao.getFormatoHora()));
					textValorPagar.setText(String.valueOf(movimentacaoBuscaDao.getValorPagar()));
					
				}
		  });
		  
		  
		  
		//CRIANDO LISTENER BOTÃO FECHAR APLICAÇÃO
		  
		  buttonFecharSistema.addActionListener(new ActionListener() 
		  {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frameRegistros.dispose();
			}
			
		  });
		  
		  
		//CRIANDO LISTENER BOTÃO REGISTRAR SAÍDA
		  
		  buttonEfeturarSaida.addActionListener(new ActionListener() 
		  {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (validarFormularioSaida())
				{
					Movimentacao movimentacao = new Movimentacao();
					
					
					movimentacao.setCodigo(textCodigo.getText().toUpperCase());
					movimentacao.setPlaca(textPlacaSaida.getText().toUpperCase());
					movimentacao.setModelo(textModeloSaida.getText().toUpperCase());
					
					LocalDate dataEntrada = null;
					LocalDate dataSaida = null;
					LocalTime horaEntrada = null;
					LocalTime horaSaida = null;
					LocalTime tempoTotal = null;
					
					movimentacao.setDataEntrada(dataEntrada = dataEntrada.parse(textDataEntrada.getText(), movimentacao.getformatoData()));
					movimentacao.setHoraEntrada(horaEntrada = horaEntrada.parse(textHoraEntrada.getText()));
					movimentacao.setDataSaida(dataSaida = dataSaida.parse(textDataSaida.getText(), movimentacao.getformatoData()));
					movimentacao.setHoraSaida(horaSaida = horaSaida.parse(textHoraSaida.getText()));
					movimentacao.setTempoTotal(tempoTotal = tempoTotal.parse(textTempoTotal.getText()));
					movimentacao.setValorPagarArquivo(Double.parseDouble(textValorPagar.getText()));


					MovimentacaoDao dao = new MovimentacaoDao(movimentacao);
					dao.salvarMovimentacaoSaida();
					
					JOptionPane.showMessageDialog(null, "Operação com carro de placa " + movimentacao.getPlaca() + " realizada com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
					
					limparFormularioSaida();
					
				}
				
				else 
				{
					JOptionPane.showMessageDialog 
					(
						null,
						"Os campos não estão recebendo valores adequados. Vefirique os dados!",
						"Atenção", //titulo da tela
						JOptionPane.WARNING_MESSAGE //simbolo que aparecerá na tela
					);
				}
				
			}
			
		  });
		  
		  
		  
		  
		//CRIANDO LISTENER CLIQUE NA TABELA
		  
		  tableRegistros.addMouseListener(new MouseListener() 
		  {
			
				@Override
				public void mouseReleased(MouseEvent e) 
				{	
				}
				
				@Override
				public void mousePressed(MouseEvent e) 
				{
				}
				
				@Override
				public void mouseExited(MouseEvent e) 
				{
				}
				
				@Override
				public void mouseEntered(MouseEvent e) 
				{
				}
				
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					int linhaTabelaSelecionada = tableRegistros.getSelectedRow();
					
					String codigo = tableRegistros.getValueAt(linhaTabelaSelecionada, 0).toString(); 
					
					MovimentacaoDao dao = new MovimentacaoDao();
					Movimentacao movimentacaoCliqueTabelaDao = dao.buscarMovimentacaoTabela(codigo);
					
					ValoresDao valoresDao = new ValoresDao();
					valoresDao.registrarValorHoras(movimentacaoCliqueTabelaDao);
					
					movimentacaoCliqueTabelaDao.setValorPagar();
					textCodigo.setText(movimentacaoCliqueTabelaDao.getCodigo());
					textPlacaSaida.setText(movimentacaoCliqueTabelaDao.getPlaca());
					textModeloSaida.setText(movimentacaoCliqueTabelaDao.getModelo());
					textDataEntrada.setText(movimentacaoCliqueTabelaDao.getDataEntrada().format(movimentacaoCliqueTabelaDao.getformatoData()));
					textHoraEntrada.setText(movimentacaoCliqueTabelaDao.getHoraEntrada().format(movimentacaoCliqueTabelaDao.getFormatoHora()));
					textDataSaida.setText(movimentacaoCliqueTabelaDao.getDataSaida().format(movimentacaoCliqueTabelaDao.getformatoData()));
					textHoraSaida.setText(movimentacaoCliqueTabelaDao.getHoraSaida().format(movimentacaoCliqueTabelaDao.getFormatoHora()));
					textTempoTotal.setText(movimentacaoCliqueTabelaDao.getTempoTotal().format(movimentacaoCliqueTabelaDao.getFormatoHora()));
					textValorPagar.setText(String.valueOf(movimentacaoCliqueTabelaDao.getValorPagar()));
					
				}
		});
		
	
	}
	
	
	
	// outros métodos
	
	
	private boolean validarFormularioEntrada()
	{
		boolean valido = true;

		
		if(textPlacaEntrada.getText().trim().length()==0)  
		{
			labelPlacaEntrada.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textModeloEntrada.getText().trim().length()==0)
		{
			labelModeloEntrada.setForeground(Color.RED);
			valido = false;
		}

		
		return valido;
	}
	
	private boolean validarFormularioSaida()
	{
		boolean valido = true;

		
		if(textPlacaSaida.getText().trim().length()==0)  
		{
			labelPlacaSaida.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textModeloSaida.getText().trim().length()==0)
		{
			labelModeloSaida.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textDataEntrada.getText().trim().length()!=8)
		{
			labelDataEntrada.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textHoraEntrada.getText().trim().length()!=8)
		{
			labelHoraEntrada.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textDataSaida.getText().trim().length()!=8)
		{
			labelDataSaida.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textHoraSaida.getText().trim().length()!=8)
		{
			labelHoraSaida.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textTempoTotal.getText().trim().length()!=8)
		{
			labelTempoTotal.setForeground(Color.RED);
			valido = false;
		}
		
		else if (textValorPagar.getText().trim().length()==0)
		{
			labelValorPagar.setForeground(Color.RED);
			valido = false;
		}

		else 
		{
			valido = true;
		}
		
		return valido;
	}
	

	private void limparFormulario()
	{
		textPlacaEntrada.setText("");
		textPlacaEntrada.requestFocus();
		textModeloEntrada.setText("");
		textPlacaSaida.setText("");
		textModeloSaida.setText("");
		textDataEntrada.setText("");
		textDataSaida.setText("");
		textHoraEntrada.setText("");
		textHoraSaida.setText("");
		textTempoTotal.setText("");
		textValorPagar.setText("");
	}
	
	
	private void limparFormularioSaida()
	{
		textPlacaEntrada.setText("");
		textPlacaEntrada.requestFocus();
		textModeloEntrada.setText("");
		textPlacaSaida.setText("");
		textModeloSaida.setText("");
		textDataEntrada.setText("");
		textDataSaida.setText("");
		textHoraEntrada.setText("");
		textHoraSaida.setText("");
		textTempoTotal.setText("");
		textValorPagar.setText("");
	}
	
		
}
