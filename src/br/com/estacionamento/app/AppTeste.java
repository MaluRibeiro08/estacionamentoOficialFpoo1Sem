package br.com.estacionamento.app;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import  br.com.estacionamento.ui.FrameMovimentacao;

public class AppTeste 
{
	public static void main(String[] args) 
	{
		// LOOK AND FEEL
				try 
				{
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
					{
						if ("Nimbus".equals(info.getName())) 
						{
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} 
				
				catch (UnsupportedLookAndFeelException e) 
				{
					
				} 
				catch (ClassNotFoundException e) 
				{
					
				} 
				catch (InstantiationException e) 
				{
					
				} 
				catch (IllegalAccessException e) 
				{
					
				}
				
		FrameMovimentacao frameMovimentacao = new FrameMovimentacao();
		frameMovimentacao.criarTela();
		
	}
}
