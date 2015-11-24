package br.ufrn.imd.psi;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
		int readNumber;

		System.out.println("Digite sua pesquisa: ");
		read = inKboard.nextLine();
		readNew = read.replaceAll(" ", "+");

		System.out.println("Digite a quantidade de resultados que você deseja: ");
		readNumber = inKboard.nextInt();
		
		inKboard.close();
		int i = 1;
		int count = 1;
		int f = 1;

		while (readNumber >= 1) {
			
			if(readNumber > 50){
				count = 50;
			} else{
				count = readNumber;
			}
			
			String link = "http://www.bing.com/search?q=" + readNew + "&count=" + count + "&first=" + i + "&FORM=PERE";

//			URL u = new URL(link);
//			HttpURLConnection http = (HttpURLConnection) u.openConnection();
//			System.out.println(http.getResponseCode());
//			System.out.println(http.getResponseMessage());
//			System.out.println(http.getRequestMethod());
//			System.out.println(link);

			Document document = Jsoup.connect(link).get();

			System.out.println(link);
			
			Elements elements = document.getElementsByClass("b_algo");

			for (Element element : elements) {
				String h4 = element.getElementsByTag("a").attr("href");
				System.out.println(h4);
			}
			
			readNumber -= 50;
			i +=50;
			
			System.out.println("loop " + f);
			f++;
		}
	}
}
