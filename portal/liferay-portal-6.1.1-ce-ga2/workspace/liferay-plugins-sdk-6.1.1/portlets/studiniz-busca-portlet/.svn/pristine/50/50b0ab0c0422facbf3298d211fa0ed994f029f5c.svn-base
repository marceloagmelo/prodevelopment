package br.com.studiniz.busca.util;

import java.util.LinkedList;
import java.util.List;

import com.liferay.portal.kernel.util.StringUtil;

public class BuscaUtil {

	public static LinkedList<String> proibidas;
	
	public static synchronized void adicionarNaLista(List<String> newPalavras) {
				
			proibidas.addAll(newPalavras);		
	}
	

	public static String filtrar(String paramBusca) {
		
		if(paramBusca == null || paramBusca.isEmpty())
			return null;
		
		String[] palavras = StringUtil.split(paramBusca," ");
		StringBuilder sb = new StringBuilder(); 
	
		for(int i = 0;i<palavras.length;i++) {
			if(!proibidas.contains(palavras[i])) {
				sb.append(palavras[i]);
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}

	public synchronized void carregaPalavrasProibidas() {

		proibidas = new LinkedList<String>();
		
		proibidas.add("\372ltimo");
		proibidas.add("\351");
		proibidas.add("acerca");
		proibidas.add("agora");
		proibidas.add("algumas");
		proibidas.add("alguns");
		proibidas.add("ali");
		proibidas.add("ambos");
		proibidas.add("antes");
		proibidas.add("apontar");
		proibidas.add("aquela");
		proibidas.add("aquelas");
		proibidas.add("aquele");
		proibidas.add("aqueles");
		proibidas.add("aqui");
		proibidas.add("atr\341s");
		proibidas.add("j\341");
		proibidas.add("bem");
		proibidas.add("bom");
		proibidas.add("cada");
		proibidas.add("caminho");
		proibidas.add("cima");
		proibidas.add("com");
		proibidas.add("como");
		proibidas.add("ah");
		proibidas.add("conhecido");
		proibidas.add("corrente");
		proibidas.add("das");
		proibidas.add("debaixo");
		proibidas.add("dentro");
		proibidas.add("desde");
		proibidas.add("desligado");
		proibidas.add("deve");
		proibidas.add("devem");
		proibidas.add("dever\341");
		proibidas.add("direita");
		proibidas.add("diz");
		proibidas.add("dizer");
		proibidas.add("dois");
		proibidas.add("dos");
		proibidas.add("e");
		proibidas.add("ela");
		proibidas.add("ele");
		proibidas.add("eles");
		proibidas.add("em");
		proibidas.add("enquanto");
		proibidas.add("ent\343o");
		proibidas.add("est\341");
		proibidas.add("est\343o");
		proibidas.add("estado");
		proibidas.add("estar");
		proibidas.add("estar\341");
		proibidas.add("este");
		proibidas.add("estes");
		proibidas.add("esteve");
		proibidas.add("estive");
		proibidas.add("estivemos");
		proibidas.add("estiveram");
		proibidas.add("eu");
		proibidas.add("far\341");
		proibidas.add("faz");
		proibidas.add("fazer");
		proibidas.add("fazia");
		proibidas.add("fez");
		proibidas.add("fim");
		proibidas.add("foi");
		proibidas.add("fora");
		proibidas.add("horas");
		proibidas.add("iniciar");
		proibidas.add("inicio");
		proibidas.add("ir");
		proibidas.add("ir\341");
		proibidas.add("ista");
		proibidas.add("iste");
		proibidas.add("isto");
		proibidas.add("ligado");
		proibidas.add("maioria");
		proibidas.add("maiorias");
		proibidas.add("mais");
		proibidas.add("mas");
		proibidas.add("mesmo");
		proibidas.add("meu");
		proibidas.add("muito");
		proibidas.add("muitos");
		proibidas.add("n\363s");
		proibidas.add("n\343o");
		proibidas.add("nome");
		proibidas.add("nosso");
		proibidas.add("novo");
		proibidas.add("o");
		proibidas.add("onde");
		proibidas.add("os");
		proibidas.add("ou");
		proibidas.add("outro");
		proibidas.add("para");
		proibidas.add("parte");
		proibidas.add("pegar");
		proibidas.add("pelo");
		proibidas.add("pessoas");
		proibidas.add("pode");
		proibidas.add("poder\341");
		proibidas.add("podia");
		proibidas.add("por");
		proibidas.add("porque");
		proibidas.add("povo");
		proibidas.add("promeiro");
		proibidas.add("qu\352");
		proibidas.add("qual");
		proibidas.add("qualquer");
		proibidas.add("quando");
		proibidas.add("quem");
		proibidas.add("quieto");
		proibidas.add("s\343o");
		proibidas.add("saber");
		proibidas.add("sem");
		proibidas.add("ser");
		proibidas.add("seu");
		proibidas.add("somente");
		proibidas.add("t\352m");
		proibidas.add("tal");
		proibidas.add("tamb\351m");
		proibidas.add("tem");
		proibidas.add("tempo");
		proibidas.add("tenho");
		proibidas.add("tentar");
		proibidas.add("tentaram");
		proibidas.add("tente");
		proibidas.add("tentei");
		proibidas.add("teu");
		proibidas.add("teve");
		proibidas.add("tipo");
		proibidas.add("tive");
		proibidas.add("todos");
		proibidas.add("trabalhar");
		proibidas.add("trabalho");
		proibidas.add("tu");
		proibidas.add("um");
		proibidas.add("uma");
		proibidas.add("umas");
		proibidas.add("uns");
		proibidas.add("usa");
		proibidas.add("usar");
		proibidas.add("valor");
		proibidas.add("veja");
		proibidas.add("ver");
		proibidas.add("verdade");
		proibidas.add("verdadeiro");
		proibidas.add("voc\352");
		proibidas.add("de");
		proibidas.add("a");
		proibidas.add("que");
		proibidas.add("da");
		proibidas.add("do");
		proibidas.add("so");
		proibidas.add("la");
		proibidas.add("num");
		proibidas.add("na");
		proibidas.add("no");
		proibidas.add("nas");
		proibidas.add("nos");
		proibidas.add("outros");
		proibidas.add("outro");
		proibidas.add("ao");
		proibidas.add("este");
		proibidas.add("pela");
		proibidas.add("pelo");
		proibidas.add("a");
		proibidas.add("voce");
		proibidas.add("se");
		proibidas.add("sua");
	}

	public static List<String> getProibidas() {
		return proibidas;
	}
}
