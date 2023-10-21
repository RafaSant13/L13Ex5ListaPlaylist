package controller;

import model.Lista;
import model.Musica;

public class PlaylistControle {

	public PlaylistControle() {
		super();
	}
	
	public void adicionaMusica(Lista<Musica>l, String musica) {
		Musica mus = new Musica();
		String [] split = musica.split(";");
		mus.nome = split[0];
		mus.nomeArtista = split[1];
		mus.duracao = Long.parseLong(split[2]);
		if (l.isEmpty()) {
			l.addFirst(mus);
		}
		else {
			try {
				l.addLast(mus);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeMusica(Lista<Musica> l, int pos) throws Exception {
		if (l.isEmpty()) {
			throw new Exception("Lista vazia");
		}
		else {
			l.remove(pos);
		}
		
	}

	public void executaPlaylist (Lista<Musica> l) throws Exception {
		int tamanho = l.size();
		if (l.isEmpty()) {
			throw new Exception("Lista vazia");
		}
		else {
			for (int i = 0;i<tamanho;i++) {
				Musica mus;
				mus = l.get(i);
				System.out.println("[Música: "+mus.nome+" - Artista: "+mus.nomeArtista+" - Duração: "+mus.duracao+"s]");
				Thread.sleep((mus.duracao*1000));
			}
		}
		
	}
}
