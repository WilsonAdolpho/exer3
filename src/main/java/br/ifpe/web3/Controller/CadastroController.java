package br.ifpe.web3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web3.model.Cadastro;
import br.ifpe.web3.model.CadastroDAO;


@Controller
public class CadastroController {
	@Autowired
	private CadastroDAO dao;
	@GetMapping("/")
	public String exibirForm(Cadastro cadastro) {
		return "form";
	}
	
	@PostMapping("/salvarcadastro")
	public String salvarcadastroo(Cadastro cadastro, Model model) {
		dao.save(cadastro); //metodo salvar
		System.out.println(cadastro);
		model.addAttribute("nome", cadastro.getNome());
		model.addAttribute("rg", cadastro.getRg());
		model.addAttribute("data", cadastro.getDataInscricao());
		model.addAttribute("nuemero", cadastro.getNumeroInscricao());

		

		return "list";
	}
	 
	@GetMapping("/listarcadastro")
	public String listarcadastro(Model model) {
		model.addAttribute("lista", dao.findAll()); //metodo para listar

		return "list";
	}
}
