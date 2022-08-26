package com.ti2cc;
import java.util.*;
public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		String nome, senha;
		char sexo;
		int id;
		Scanner ler = new Scanner(System.in);
		for(int i = 2 ; i < 12 ; i++) {
			System.out.println("Informe o nome do usuário:");
			nome = ler.nextLine();
			System.out.println("Informe a senha:");
			senha = ler.nextLine();
			System.out.println("Informe o sexo:");
			sexo = ler.next().charAt(0);
			Usuario usuario = new Usuario(i, nome, senha,sexo);
			dao.inserirUsuario(usuario);
			System.out.println("Usuário adicionado com sucesso.");
			
			
			
		}
		
		//Inserir um elemento na tabela
		Usuario usuario = new Usuario(13, "pablo", "pablo",'M');
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
		
		//Mostrar usuários do sexo masculino		
		System.out.println("==== Mostrar usuários do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usuário
		usuario.setSenha("nova senha");
		dao.atualizarUsuario(usuario);

		//Mostrar usuários do sexo masculino
		System.out.println("==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		//Excluir usuário
		dao.excluirUsuario(usuario.getCodigo());
		
		//Mostrar usuários
		usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuários === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		dao.close();
	}
}