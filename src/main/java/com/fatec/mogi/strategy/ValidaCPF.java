package com.fatec.mogi.strategy;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Administrador;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;

@Service
public class ValidaCPF implements IStrategy{
	

	@Override
	public String processar(BaseModel baseModel) {
		
		String CPFEntidade = "";
		if(baseModel instanceof Cliente) {
			Cliente cliente = (Cliente) baseModel;
			CPFEntidade = cliente.getCpf();
			
		}
		if(baseModel instanceof Administrador) {
			Administrador administrador = (Administrador) baseModel;
			CPFEntidade = administrador.getCpf();
		}
		
		
		String CPF = CPFEntidade;
		String retorno = "";
		
		//numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") ||
			CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") ||
			CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
		{
			retorno = "CPF INVÁLIDO";
		}
		else
		{
			char dig10, dig11;
			int soma = 0, peso = 10, resultado, num;

			//primeiro digito
			for (int i = 0; i < 9; i++)
			{
				// convertendo os numeros usando o -48, numero do 0 na asc         
				num = (int)(CPF.charAt(i) - 48); 
				soma = soma + (num * peso);
				peso = peso - 1;
			}
			
			resultado = 11 - (soma % 11);
			if ((resultado == 10) || (resultado == 11))
			{
				dig10 = '0';
			}
			else
			{
				dig10 = (char)(resultado + 48); // converte no respectivo caractere numerico
			}
	          
			//segundo digito
			soma = 0;
			peso = 11;
			for(int i = 0; i < 10; i++)
			{
				num = (int)(CPF.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}
			
			resultado = 11 - (soma % 11);
			if ((resultado == 10) || (resultado == 11))
			{
				dig11 = '0';
			}
			else
			{
				dig11 = (char)(resultado + 48);
			}
			
			//verificando os digitos
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
			{
				retorno = "";
			}
			else
			{
				retorno = "CPF INVÁLIDO";
			}
		}
		return retorno;
	}
}