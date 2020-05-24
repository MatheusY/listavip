package br.com.alura.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.enviadorEmail.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository convidadoRepository;
	
	public Iterable<Convidado> listarTodosConvidados(){
		return convidadoRepository.findAll();
	}
	
	public void salvar(Convidado convidado) {
		convidadoRepository.save(convidado);
		
		new EmailService().enviar(convidado.getNome(), convidado.getEmail());
	}
	
}
