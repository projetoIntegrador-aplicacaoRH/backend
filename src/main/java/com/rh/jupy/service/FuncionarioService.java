package com.rh.jupy.service;

import com.rh.jupy.model.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	       public BigDecimal calcularSalarioFinal(Funcionario funcionario) {
	        // Calcula o valor total do salário com base nas horas trabalhadas, valor hora, bônus e descontos
	        BigDecimal horasTrabalhadas = new BigDecimal(funcionario.getHorasTrabalhadas());
	        BigDecimal valorHora = funcionario.getValorHora();
	        BigDecimal bonus = funcionario.getBonus();
	        BigDecimal desconto = funcionario.getDesconto();
	        
	        // Salário Final = (Horas trabalhadas * Valor hora) + Bônus - Desconto
	        BigDecimal salarioFinal = (valorHora.multiply(horasTrabalhadas))
	                                   .add(bonus)
	                                   .subtract(desconto);
	        
	        return salarioFinal.setScale(2, RoundingMode.HALF_UP); // Garantindo duas casas decimais
	    }
	
}
