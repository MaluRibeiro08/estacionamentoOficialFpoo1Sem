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
		  frameRegistros.setTitle("Estacionamento - Registro de movimenta��es");
		  frameRegistros.setSize(900,800);
		  frameRegistros.setResizable(false);
		  frameRegistros.setLayout(null);
		  frameRegistros.getContentPane().setBackground(Color.LIGHT_GRAY);
		  
		//CRIANDO T�TULO
		  labelTitulo = new JLabel();
		  labelTitulo.setBounds(20, 10, 500, 50);
		  labelTitulo.setText("Estacionamento do Severino!");
		  labelTitulo.setFont(fontLabelTitulo);
		  
		//CRIANDO SUBT�TULO DE ENTRADA
		  labelSubtituloEntrada = new JLabel();
		  labelSubtituloEntrada.setBounds(20, 80, 100, 30); //20 padr�o | 10+50+20espa�o | normal | normal
		  labelSubtituloEntrada.setText("ENTRADA");
		  labelSubtituloEntrada.setFont(fontLabelSubtitulo);
		  
		//CRIANDO LABEL PLACA ENTRADA
		  labelPlacaEntrada = new JLabel();
		  labelPlacaEntrada.setBounds(20, 120, 50, 30); //20 padr�o | 80+30+10espa�o | normal | normal
		  labelPlacaEntrada.setText("Placa:");
		  labelPlacaEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD PLACA ENTRADA
		  textPlacaEntrada = new JTextField();
		  textPlacaEntrada.setBounds(20, 155, 200, 30); // 20 padr�o | 120+30+5espa�o | normal | normal
		  textPlacaEntrada.setFont(fontTextField);
		  
		//CRIANDO LABEL MODELO ENTRADA
		  labelModeloEntrada = new JLabel();
		  labelModeloEntrada.setBounds(270, 120, 90, 30); //20padr�o + 200(larguratxtfield) + 50 espa�o | 80+30+10espa�o | normal | normal
		  labelModeloEntrada.setText("Modelo:");
		  labelModeloEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD MODELO ENTRADA
		  textModeloEntrada = new JTextField();
		  textModeloEntrada.setBounds(270, 155, 200, 30); // 270 padr�o do seu label | 120+30+5espa�o | normal | normal
		  textModeloEntrada.setFont(fontTextField);
		  
		//CRIANDO BUTTON ENTRAR
		  buttonRegistrarEntrada = new JButton();
		  buttonRegistrarEntrada.setBounds(520, 150, 150, 40); //270 +200larguratxtrfield + 50espa�o | 120 +30+5espa�o | normal | normal
		  buttonRegistrarEntrada.setFont(fontLabelButton);
		  buttonRegistrarEntrada.setText("REG. ENTRADA");
		  
		//CRIANDO MODELO PARA TABELA
		   modelTableRegistros = new DefaultTableModel();
		  
		  //Colunas
		    modelTableRegistros.addColumn("C�DIGO");
		    modelTableRegistros.addColumn("PLACA");
		    modelTableRegistros.addColumn("MODELO");
		    modelTableRegistros.addColumn("DATA ENTRADA");
		    
		  //linhas
		    
//		    String[] infotabela = {"A1B2C3D4","ERO-1354","SPACEFOX","28/06/2021"};
//		    modelTableRegistros.addRow(infotabela);
		    
		    MovimentacaoDao movimentacaoDao = new MovimentacaoDao();
			ArrayList<Movimentacao> movimentacoes = movimentacaoDao.listarMovimentacoes(); //clientes recebe a lista de clientes vindo do m�t de Dao
			  
			  for (Movimentacao movimentacao : movimentacoes) //cria um cliente e guarda nele o conte�do de um item da lista clientes. A cada volta, um cliente diferente da lista � guardado no cliente. || os : � s� um separador
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
		  scrollTableRegistros.setBounds(20, 210, 450, 200);// 20padrao | 150+40+20espa�o | 450 | 200
		  
		//CRIANDO LABEL SUBTITULO SAIDA
		  labelSubtituloSaida = new JLabel();
		  labelSubtituloSaida.setBounds(20, 460, 100, 30); //20 padr�o | 210+200+50espa�o| normal | normal
		  labelSubtituloSaida.setText("SA�DA");
		  labelSubtituloSaida.setFont(fontLabelSubtitulo);
		  
		//CRIANDO LABEL PLACA SA�DA
		  labelPlacaSaida = new JLabel();
		  labelPlacaSaida.setBounds(20, 500, 50, 30); //20 padr�o | 460+30+10espa�o | normal | normal
		  labelPlacaSaida.setText("Placa:");
		  labelPlacaSaida.setFont(fontLabelsNormais);
		
		//CRIANDO TEXT FIELD PLACA SA�DA
		  textPlacaSaida = new JTextField();
		  textPlacaSaida.setBounds(20, 535, 200, 30); // 20 padr�o | 500+30+5espa�o | normal | normal
		  textPlacaSaida.setFont(fontTextField);
		  
		//CRIANDO BUTTON BUSCAR
		  buttonBuscar = new JButton();
		  buttonBuscar.setBounds(240, 530, 100, 40); // 20+200+20espa�o | 500+30 | normal | normal
		  buttonBuscar.setFont(fontLabelButton);
		  buttonBuscar.setText("BUSCAR"); 
		  
		//CRIANDO LABEL MODELO SA�DA
		  labelModeloSaida = new JLabel();
		  labelModeloSaida.setBounds(20, 580, 90, 30); //20padr�o | 535+30+15espa�o | normal | normal
		  labelModeloSaida.setText("Modelo:");
		  labelModeloSaida.setFont(fontLabelsNormais);
		  
		//CRIANDO TXT FIELD MODELO SAIDA
		  textModeloSaida = new JTextField();
		  textModeloSaida.setBounds(20, 610, 200, 30); // 20 padr�o | 580+30 | normal | normal
		  textModeloSaida.setFont(fontTextField);
		  
		//CRIANDO LABEL DATA ENTRADA
		  labelDataEntrada = new JLabel();
		  labelDataEntrada.setBounds(230, 580, 100, 30); //20+200(textfield anterior)+10espa�o | 535+30+15espa�o | normal | normal
		  labelDataEntrada.setText("Data entrada:");
		  labelDataEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TXT FIELD DATA ENTRADA
		  textDataEntrada = new JTextField();
		  textDataEntrada.setBounds(230, 610, 110, 30); // 230(padr�o da label) | 580+30 | normal | normal
		  textDataEntrada.setFont(fontTextField);
		  
		//CRIANDO LABEL HORA ENTRADA
		  labelHoraEntrada = new JLabel();
		  labelHoraEntrada.setBounds(350, 580, 110, 30); //340(textfield anterior)+10espa�o | 535+30+15espa�o | normal | normal
		  labelHoraEntrada.setText("Hora Entrada:");
		  labelHoraEntrada.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD HORA ENTRADA
		  textHoraEntrada = new JTextField();
		  textHoraEntrada.setBounds(350, 610, 110, 30); // 350(padr�o da label) | 580+30 | normal | normal
		  textHoraEntrada.setFont(fontTextField);
		  
		//CRIANDO LABEL DATA SA�DA
		  labelDataSaida = new JLabel();
		  labelDataSaida.setBounds(470, 580, 110, 30); //460(textfield anterior)+10espa�o | 535+30+15espa�o | normal | normal
		  labelDataSaida.setText("Data Sa�da:");
		  labelDataSaida.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD DATA SA�DA
		  textDataSaida = new JTextField();
		  textDataSaida.setBounds(470, 610, 110, 30); // 470(padr�o da label) | 580+30 | normal | normal
		  textDataSaida.setFont(fontTextField);
		  
		//CRIANDO LABEL HORA SA�DA
		  labelHoraSaida = new JLabel();
		  labelHoraSaida.setBounds(590, 580, 110, 30); //580(textfield anterior (470+110))+10espa�o | 535+30+15espa�o | normal | normal
		  labelHoraSaida.setText("Hora Sa�da:");
		  labelHoraSaida.setFont(fontLabelsNormais);
		  
		//CRIANDO TEXT FIELD HORA SA�DA
		  textHoraSaida = new JTextField();
		  textHoraSaida.setBounds(590, 610, 110, 30); // 580(padr�o da label)+10espa�o | 580+30 | normal | normal
		  textHoraSaida.setFont(fontTextField);

		//CRIANDO LABEL TEMPO TOTAL
		  labelTempoTotal = new JLabel();
		  labelTempoTotal.setBounds(710, 580, 110, 30); //700(textfield anterior (590+110))+10espa�o | 535+30+15espa�o | normal | normal
		  labelTempoTotal.setText("Tempo Total:");
		  labelTempoTotal.setFont(fontLabelsNormais);
		  
		//CRIANDO TXT FIELD TEMPO TOTAL
		  textTempoTotal = new JTextField();
		  textTempoTotal.setBounds(710, 610, 110, 30); // 580(padr�o da label)+10espa�o | 580+30 | normal | normal
		  textTempoTotal.setFont(fontTextField);
		  
		//CRIANDO LABEL TOTAL A PAGAR
		  labelValorPagar = new JLabel();
		  labelValorPagar.setBounds(20, 680, 110, 30); //20 padr�o | 610+30+40espa�o| normal | normal
		  labelValorPagar.setText("Valor Total:");
		  labelValorPagar.setFont(fontLabelSubtitulo);
		  
		//CRIANDO TXT FIELD TOTAL A PAGAR
		  textValorPagar = new JTextField();
		  textValorPagar.setBounds(150, 670, 170, 50); // 20 PADR�O + 110 LABEL + 20ESPA�O | padr�o label - 10 | normal | normal
		  textValorPagar.setFont(fontLabelTitulo);
		  textValorPagar.setBackground(Color.GREEN);
		
		//CRIANDO BUTTON EFETUAR SA�DA
		  buttonEfeturarSaida = new JButton();
		  buttonEfeturarSaida.setBounds(400, 670, 150, 60); //150 +170larguratxtrfield + 80espa�o | 610+30+40espa�o| normal | normal
		  buttonEfeturarSaida.setFont(fontLabelButton);
		  buttonEfeturarSaida.setText("Reg. Sa�da!");
		  
		//CRIANDO BUTTON FECHAR APP
		  buttonFecharSistema = new JButton();
		  buttonFecharSistema.setBounds(670, 680, 150, 50); //400 +150larguratxtrfield + 120espa�o | 610+30+40espa�o| normal | normal
		  buttonFecharSistema.setFont(fontLabelButton);
		  buttonFecharSistema.setText("Fechar Sistema");
		  buttonFecharSistema.setBackground(Color.RED);
		  
		
		  
		//CRIANDO TEXT OCULTO C�DIGO
		  textCodigo = new JTextField();
		  
		//ADICIONANDO � TELA
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
		  
		  
		  
		//CRIANDO LISTENER BOT�O REGISTAR ENTRADA
		  
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
					
					JOptionPane.showMessageDialog(null, "Opera��o com carro de placa " + movimentacao.getPlaca() + " realizada com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
					
					limparFormulario();
					
				}
				
				else 
				{
					JOptionPane.showMessageDialog 
					(
						null,
						"Voc� deve preencher todos os campos",
						"Aten��o", //titulo da tela
						JOptionPane.WARNING_MESSAGE //simbolo que aparecer� na tela
					);
				}
				
			}
			
		  });
		  
		  
		//CRIANDO LISTENER BOT�O BUSCAR
		  
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
		  
		  
		  
		//CRIANDO LISTENER BOT�O FECHAR APLICA��O
		  
		  buttonFecharSistema.addActionListener(new ActionListener() 
		  {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frameRegistros.dispose();
			}
			
		  });
		  
		  
		//CRIANDO LISTENER BOT�O REGISTRAR SA�DA
		  
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
					
					JOptionPane.showMessageDialog(null, "Opera��o com carro de placa " + movimentacao.getPlaca() + " realizada com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
					
					limparFormularioSaida();
					
				}
				
				else 
				{
					JOptionPane.showMessageDialog 
					(
						null,
						"Os campos n�o est�o recebendo valores adequados. Vefirique os dados!",
						"Aten��o", //titulo da tela
						JOptionPane.WARNING_MESSAGE //simbolo que aparecer� na tela
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
	
	
	
	// outros m�todos
	
	
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
