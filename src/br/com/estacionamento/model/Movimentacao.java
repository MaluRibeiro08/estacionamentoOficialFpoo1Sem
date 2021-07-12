package br.com.estacionamento.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Movimentacao 
{
	private String codigo;
	private String placa;
	private String modelo;
	private LocalDate dataEntrada;
	private LocalTime horaEntrada;
	private LocalDate dataSaida;
	private LocalTime horaSaida;
	private LocalTime tempoTotal;
	private double valorPagar;
	private double valorPrimeiraHora;
	private double valorDemaisHoras;
	private int tempoTolerancia = 15;
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yy"); 
	private DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	

	public String getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
	
	public String getPlaca() 
	{
		return placa;
	}
	
	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}
	
	public String getModelo() 
	{
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public LocalDate getDataEntrada() 
	{
		return dataEntrada;
	}
	
	public void setDataEntrada(LocalDate dataEntrada) 
	{
		this.dataEntrada = dataEntrada;
	}
	
	public LocalTime getHoraEntrada()
	{
		return horaEntrada;
	}
	
	public void setHoraEntrada(LocalTime horaEntrada) 
	{
		this.horaEntrada = horaEntrada;
	}
	
	public LocalDate getDataSaida() 
	{
		return dataSaida;
	}
	
	public void setDataSaida(LocalDate dataSaida)
	{
		this.dataSaida = dataSaida;
	}
	
	public LocalTime getHoraSaida() 
	{
		return horaSaida;
	}
	
	public void setHoraSaida(LocalTime horaSaida) 
	{
		this.horaSaida = horaSaida;
	}
	
	public LocalTime getTempoTotal() 
	{
		return tempoTotal;
	}
	
	public void setTempoTotal(LocalTime tempoTotal) 
	{
		this.tempoTotal = horaSaida.minusHours(horaEntrada.getHour()).minusMinutes(horaEntrada.getMinute()).minusSeconds(horaEntrada.getSecond());
	}
	
	public double getValorPagar() 
	{
		return valorPagar;
	}
	
	public void setValorPagarArquivo (double valorPagar)
	{
		this.valorPagar = valorPagar;
	}
	
	public void setValorPagar() 
	{
		calcularValorPagar();
	}
	
	public double getValorPrimeiraHora() 
	{
		return valorPrimeiraHora;
	}

	public void setValorPrimeiraHora(double valorPrimeiraHora) 
	{
		this.valorPrimeiraHora = valorPrimeiraHora;
	}

	public double getValorDemaisHoras() 
	{
		return valorDemaisHoras;
	}

	public void setValorDemaisHoras(double valorDemaisHoras) 
	{
		this.valorDemaisHoras = valorDemaisHoras;
	}

	public int getTempoTolerancia()
//	public LocalTime getTempoTolerancia() 
	{
		return tempoTolerancia;
	}

//	public void setTempoTolerancia(LocalTime tempoTolerancia) 
	public void setTempoTolerancia(int tempoTolerancia) 
	{
		this.tempoTolerancia = tempoTolerancia;
	}

	public DateTimeFormatter getformatoData() 
	{
		return formatoData;
	}
	
	public DateTimeFormatter getFormatoHora() 
	{
		return formatoHora;
	}

	public void setFormatoHora(DateTimeFormatter formatoHora) 
	{
		this.formatoHora = formatoHora;
	}
	
	
	public double calcularValorPagar()
	{
		if (tempoTotal.getHour()>0 && tempoTotal.getMinute()<tempoTolerancia)
		{
			double totalValorPrimeiraHora = valorPrimeiraHora * 1;
			LocalTime totalTempoDemaisHoras = tempoTotal.minusHours(1);
			double totalValorDemaisHoras = valorDemaisHoras * totalTempoDemaisHoras.getHour();
					
			valorPagar = totalValorPrimeiraHora + totalValorDemaisHoras ;
		}
		
		else if (tempoTotal.getHour()>0 && tempoTotal.getMinute()>tempoTolerancia)
		{
			double totalValorPrimeiraHora = valorPrimeiraHora * 1;
			double totalValorDemaisHoras = valorDemaisHoras * tempoTotal.getHour();
			
			System.out.println(valorPrimeiraHora);
			System.out.println(valorDemaisHoras);
			System.out.println(totalValorPrimeiraHora);
			System.out.println(totalValorDemaisHoras);
					
			valorPagar = totalValorPrimeiraHora + totalValorDemaisHoras ;
		}
		
		else if (tempoTotal.getHour()<0 && tempoTotal.getMinute() >= tempoTolerancia)
		{
			valorPagar = valorPrimeiraHora * 1;
		}
		
		else if (tempoTotal.getHour()<0 && tempoTotal.getMinute()<tempoTolerancia)
		{
			valorPagar = 00.0;
		}
		
		return valorPagar;
	}
	
	
	
	@Override
	public String toString() 
	{
		return codigo + ";" + placa + ";" + modelo + ";" + dataEntrada + ";"
				+ horaEntrada + ";" + dataSaida + ";" + horaSaida + ";" + tempoTotal + ";" + valorPagar;
	}
	
	public String toStringEntrada() 
	{
		return codigo + ";" + placa + ";" + modelo + ";" + dataEntrada + ";"
				+ horaEntrada + ";1111-11-11;00:00:00;00:00;00.00";
	}
	

}
