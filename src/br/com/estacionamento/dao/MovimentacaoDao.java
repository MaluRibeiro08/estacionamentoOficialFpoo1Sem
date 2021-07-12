package br.com.estacionamento.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import br.com.estacionamento.model.Movimentacao;

public class MovimentacaoDao
{
	private Movimentacao movimentacao = new Movimentacao();
	private static final String LOCAL_ARQUIVO_MOVIMENTACAO = "C:/Users/Maria Luiza RT/movimentacao.ds1";
	
	
	public MovimentacaoDao()//construtor vazio
	{
	}
	
	public MovimentacaoDao(Movimentacao movimentacao) //construtor com movimentacao
	{
		this.movimentacao = movimentacao;
	}
	
	public Movimentacao getMovimentacao()
	{
		return movimentacao;
	}
	
	public void salvarMovimentacaoEntrada()
	{
		// PASSO 1: obter o caminho do arquivo. 
		
			Path path = Paths.get(LOCAL_ARQUIVO_MOVIMENTACAO);
						
		//PASSO 2: criar o buffer para o arquivo, indicando o arquivo (path) e o conjunto de caracteres.
			try 
			{
				BufferedWriter writer = Files.newBufferedWriter
				  (path, Charset.forName("UTF-8"), StandardOpenOption.WRITE, 
				  StandardOpenOption.APPEND);
						
				writer.write(movimentacao.toStringEntrada()); 
				writer.newLine();
				writer.close();
						
			} 
					
					catch (Exception e) 
					{
						e.printStackTrace();
					}
		
	}
	
	public void salvarMovimentacaoSaida()
	{
			Path path = Paths.get(LOCAL_ARQUIVO_MOVIMENTACAO);
					
			try 
			{
				BufferedWriter writer = Files.newBufferedWriter
				  (path, Charset.forName("UTF-8"), StandardOpenOption.WRITE, 
				  StandardOpenOption.APPEND);
						
				writer.write(movimentacao.toString());
				writer.newLine();
				writer.close();	
			} 
					
					catch (Exception e) 
					{
						e.printStackTrace();
					}
		
	}
	
	public ArrayList<Movimentacao> listarMovimentacoes()
	{
		Path path = Paths.get(LOCAL_ARQUIVO_MOVIMENTACAO);
	
		try 
		 {
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			
			String linha = reader.readLine(); 
			
			ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
			
			while (linha != null)
			 {
				String[] vetorMovimentacao = linha.split(";");
				
				Movimentacao movimentacao = new Movimentacao();
				movimentacao.setCodigo(vetorMovimentacao[0]); 
				movimentacao.setPlaca(vetorMovimentacao[1]);
				movimentacao.setModelo(vetorMovimentacao[2]);
				
				LocalDate dataEntrada = null;
				LocalDate dataSaida = null;
				LocalTime horaEntrada = null;
				LocalTime horaSaida = null;
				LocalTime tempoTotal = null;
				double valorAPagar = 0.0;
				
				movimentacao.setDataEntrada(dataEntrada = dataEntrada.parse(vetorMovimentacao[3]));
				movimentacao.setHoraEntrada(horaEntrada = horaEntrada.parse(vetorMovimentacao[4]));
				movimentacao.setDataSaida(dataSaida = dataSaida.now());
				movimentacao.setHoraSaida(horaSaida = horaSaida.now());
				movimentacao.setTempoTotal(tempoTotal);
				movimentacao.setValorPagar();
				
				
				movimentacoes.add(movimentacao); 
				
				linha = reader.readLine();
			 }

			reader.close();
			
			return movimentacoes;
		 } 
		
		
		
		catch (Exception e) 
		 {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace(); 
			return null;
		 }
	}
	
	
	public Movimentacao buscarMovimentacao (String placaBusca)
	{
	
			Path path = Paths.get(LOCAL_ARQUIVO_MOVIMENTACAO);	
				
			try 
			{
				BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8")); 
					
				String linha = reader.readLine(); 
					
				while (linha != null)
				 {
					String[] vetorMovimentacao = linha.split(";");
						
						
					if (vetorMovimentacao[1].equals(placaBusca.toUpperCase())) 
					{
						movimentacao = new Movimentacao();
						movimentacao.setCodigo(vetorMovimentacao[0]); 
						movimentacao.setPlaca(vetorMovimentacao[1]);
						movimentacao.setModelo(vetorMovimentacao[2]);
						
						LocalDate dataEntrada = null;
						LocalDate dataSaida = null;
						LocalTime horaEntrada = null;
						LocalTime horaSaida = null;
						LocalTime tempoTotal = null;
						double valorAPagar = 0.0;
						
						movimentacao.setDataEntrada(dataEntrada = dataEntrada.parse(vetorMovimentacao[3]));
						movimentacao.setHoraEntrada(horaEntrada = horaEntrada.parse(vetorMovimentacao[4]));
						movimentacao.setDataSaida(dataSaida = dataSaida.now());
						movimentacao.setHoraSaida(horaSaida = horaSaida.now());
						movimentacao.setTempoTotal(tempoTotal);
						movimentacao.setValorPagar();

						break;
					}
						
						
					linha = reader.readLine();
				}
		
					
				reader.close();
					
				return movimentacao;
			} 
				
				
				
				
			catch (Exception e) 
			{
				System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
				e.printStackTrace();
				return null;
			}
	}



	public Movimentacao buscarMovimentacaoTabela (String codigoTabelaBusca)
	{

		Path path = Paths.get(LOCAL_ARQUIVO_MOVIMENTACAO);	
			
		try 
		{
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8")); 
				
			String linha = reader.readLine(); 
				
			while (linha != null)
			 {
				String[] vetorMovimentacao = linha.split(";");
					
					
				if (vetorMovimentacao[0].equals(codigoTabelaBusca.toUpperCase())) 
				{
					movimentacao = new Movimentacao();
					movimentacao.setCodigo(vetorMovimentacao[0]); 
					movimentacao.setPlaca(vetorMovimentacao[1]);
					movimentacao.setModelo(vetorMovimentacao[2]);
					
					LocalDate dataEntrada = null;
					LocalDate dataSaida = null;
					LocalTime horaEntrada = null;
					LocalTime horaSaida = null;
					LocalTime tempoTotal = null;
					double valorAPagar = 0.0;
					
					movimentacao.setDataEntrada(dataEntrada = dataEntrada.parse(vetorMovimentacao[3]));
					movimentacao.setHoraEntrada(horaEntrada = horaEntrada.parse(vetorMovimentacao[4]));
					movimentacao.setDataSaida(dataSaida = dataSaida.now());
					movimentacao.setHoraSaida(horaSaida = horaSaida.now());
					movimentacao.setTempoTotal(tempoTotal);
					movimentacao.setValorPagar();
					
					break;
				}
					
					
				linha = reader.readLine(); // lê mais uma e o cursor vai para a próxima....
			}
	
			reader.close();
				
			return movimentacao;
		} 
			
			
		catch (Exception e) 
		{
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace(); //pega a mensagem do erro p/ o programador || "e" é a variável do erro.
			return null;
		}
	}

}

