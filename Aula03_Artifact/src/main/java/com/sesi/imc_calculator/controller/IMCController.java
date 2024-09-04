pessoa
package com.sesi.imc.calculator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private double altura;
	private double peso;
	private double imc;
	
	
	public Pessoa(Long id, String nome, double altura, double peso, double imc) {
		super();
		this.id = id;
		this.nome = nome;
		this.altura = altura;
		this.peso = peso;
		this.imc = imc;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public double getImc() {
		return imc;
	}


	public void setImc(double imc) {
		this.imc = imc;
	}
	
		
pessoa repositorio
package com.sesi.imc.calculator.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.imc.calculator.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}



imcc controller
package com.sesi.imc.calculator.controller;

import com.sesi.imc.calculator.repositoy.PessoaRepository;

public class IMCController {
	
	private PessoaRepository pessoaRepository;
	
}






package com.sesi.imc.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sesi.imc.calculator.model.Pessoa;
import com.sesi.imc.calculator.repositoy.PessoaRepository;

import ch.qos.logback.core.model.Model;

@Controller
public class IMCController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/")
	public String showForm() {
		return "form";	
	}
	
	@PostMapping
	public String calcularIMC(@RequestParam String nome,  @RequestParam double altura,@RequestParam double peso, Model model) {
		
		double imc = peso / (altura * altura);
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setAltura(altura);
		pessoa.setPeso(peso);
		pessoa.setImc(imc);
		
		pessoaRepository.save(pessoa);
		
		
		return "from";
	}
}






}

