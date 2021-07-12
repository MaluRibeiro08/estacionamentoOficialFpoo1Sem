package br.com.estacionamento.util;

import java.util.UUID;

public class Util 
{
	public static String gerarCodigo()
	{
		return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
		//cria um código em HEXA, transforma em String, pega os 8 primeiros caracteres e os apresenta em letras maisusculas
	}
}
