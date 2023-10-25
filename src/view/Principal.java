package view;


import javax.swing.JOptionPane;

import controller.playlistControle;
import model.Lista;
import model.Musica;

public class Principal {

	public static void main(String[] args) {
		playlistControle p = new playlistControle();
		Lista<Musica> l = new Lista<Musica>();
		int x = 0;
		while (x!=9){
			x = Integer.parseInt(JOptionPane.showInputDialog("Menu\n1 - Adicionar M�sica\n2 - Remover M�sica\n3 - Tocar Playlist\n9 - Fim"));
			switch(x) {
			case 1:
				String nome = JOptionPane.showInputDialog("Insira o nome da m�sica: ");
				String artista = JOptionPane.showInputDialog("Insira o nome do artista: ");
				long duracao = Long.parseLong(JOptionPane.showInputDialog("Insira a dura��o da m�sica (em segundos): "));
				String musica = nome + ";" + artista + ";" + duracao;
				p.adicionaMusica(l, musica);
				break;
			case 2:
				int pos = Integer.parseInt(JOptionPane.showInputDialog("Insira a posi��o da m�sica a ser removida: "));
				try {
					p.removeMusica(l, pos);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					p.executaPlaylist(l);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 9:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Valor inv�lido");
			}
		}
	}

}
