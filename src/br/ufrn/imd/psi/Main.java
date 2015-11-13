package br.ufrn.imd.psi;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/*
 * Bing Search via classe URL
 * http://www.bing.com/search?
 * q=query+aqui
 * count=xx (quanXdade de resultados retornados)
 * Concatene queries com &
 * Faça um programa que busque no Bing algo informado pelo usuário  e retorne os links para todos os 100 primeiros resultados
 * Utilizar a classe URL, buscando no HTML!
 * Não utilizar a API do Bing!
 * Encontre uma solução para filtrar somente os links
 */
public class Main {

	public static void main(String[] args) throws IOException {

		Scanner inKboard = new Scanner(System.in);
		String read, readNew;

		System.out.println("Digite sua pesquisa: ");
		read = inKboard.nextLine();
		readNew = read.replaceAll(" ", "+");

		String link = "https://www.bing.com/search?q=" + readNew + "&count=50";
		//String link = "http://www.imd.ufrn.br";
		//String link = "https://www.google.com.br/search?q=links+interessantes&sourceid=ie7&rls=com.microsoft:en-US:IE-Address&ie=&oe=&gfe_rd=cr&ei=AnE_Vue4O8SU8QfU8KbYBw";
		URL u = new URL(link);

		HttpURLConnection http = (HttpURLConnection) u.openConnection();
		System.out.println(http.getResponseCode());
		System.out.println(http.getResponseMessage());
		System.out.println(http.getRequestMethod());
		System.out.println(link);
		try {
			
			InputStream in = u.openStream();
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			in.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}
}
