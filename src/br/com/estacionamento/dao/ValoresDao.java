package br.com.estacionamento.dao;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;

import br.com.estacionamento.model.Movimentacao;

public class ValoresDao 
{
	private static final String LOCAL_ARQUIVO_VALORES = "C:/Users/Maria Luiza RT/valores.ds1";
	
	Movimentacao movimentacao = new Movimentacao();

	
	public static String getLocalArquivoValores() 
	{
		return LOCAL_ARQUIVO_VALORES;
	}


	public int registrarValorHoras(Movimentacao movimentacao)
	{
		Path path = Paths.get(LOCAL_ARQUIVO_VALORES);
		
		
		try 
		{
			BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
			String linha = reader.readLine();
		
			while (linha != null) 
			 {
				String[] vetorValores = linha.split(";");
			
			
				if (vetorValores[0].equals("PRIMEIRA_HORA")) 
				{
					movimentacao.setValorPrimeiraHora(Double.parseDouble(vetorValores[1])); 
				}
				
				else if (vetorValores[0].equals("DEMAIS_HORAS"))
				{
					movimentacao.setValorDemaisHoras(Double.parseDouble(vetorValores[1]));
				}
				
				else 
				{
					LocalTime tempoTolerancia = null;
					movimentacao.setTempoTolerancia(Integer.parseInt((vetorValores[1]).toString())); 
				}
			
			
				linha = reader.readLine(); // lê mais uma e o cursor vai para a próxima....
			 }

			reader.close();
		
			return movimentacao.getTempoTolerancia();
		} 
	
	
	
	
		catch (Exception e) 
		 {
			System.out.println("Ocorreu um erro na tentativa de ler o arquivo!");
			e.printStackTrace();
			return 0;
		 }

	}
		
		
		
}
	

