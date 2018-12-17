package br.com.allianz.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import br.com.allianz.viewmodel.ConvidadoVM;

public class AppRest {

	public static void main(String[] args) {
		try {
			//getServico();
			postServico();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void getServico() throws Exception{
		//url do servi�o a ser consumido
		String url = "http://localhost:8080/Projeto04_SpringMVC_Classes/api/convidados";
		
		//objeto usado para alcan�ar o servi�o
		URL obj = new URL(url);
		
		//objeto respons�vel por buscar o fluxo de bytes
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		
		//especifica��o do verbo HTTP
		con.setRequestMethod("GET");
		
		//objeto usado para referenciar o fluxo de bytes obtidos do servi�o
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		//recebera o fluxo de bytes desserializado
		StringBuilder response = new StringBuilder();
		
		String linha;
		while ((linha = in.readLine()) != null) {
			response.append(linha);			
		}
		in.close();
		
		String json = response.toString();
		
		//O objeto Gson converter� o conte�do json
		//para a estrutura adequada da nossa classe
		Gson gson = new Gson();
		
		ConvidadoVM[]  convidados = gson.fromJson(json, ConvidadoVM[].class);
		
		//Apresenta��o dos resultados
		for (ConvidadoVM vm : convidados) {
			System.out.println("Cpf: " + vm.getCpf());
			System.out.println("Nome: " + vm.getNome());
			System.out.println("Email: " + vm.getEmail());
			System.out.println("Telefone: " + vm.getTelefone());
			System.out.println("---------------------");
			
		}			
	}
	
	public static void postServico() throws Exception {

		String url = "http://localhost:8080/Projeto04_SpringMVC_Classes/api/convidados";
		URL obj = new URL(url);		
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		
		con.setRequestMethod("POST");
		//configura a permiss�o de sa�da do objeto
		con.setDoOutput(true);
		con.addRequestProperty("Content-Type", "application/json");
		
		Gson gson = new Gson();
		
		//Obten��o dos dados de entrada
		int idEvento = 1;
		String cpf = JOptionPane.showInputDialog("Cpf:");
		String nome = JOptionPane.showInputDialog("Nome:");
		String email = JOptionPane.showInputDialog("Email:");
		String telefone = JOptionPane.showInputDialog("Telefone:");
		
		ConvidadoVM vm = new ConvidadoVM(idEvento, cpf, nome, telefone, email);
		//Cria um json a apartir do objeto
		String json = gson.toJson(vm);
		
		//Serializa o json enviando-o para o servi�o
		OutputStream os = con.getOutputStream();
		os.write(json.getBytes());
		os.flush();
		
		System.out.println(con.getResponseCode());
	}
		
}
