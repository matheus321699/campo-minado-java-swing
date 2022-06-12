package matheus321699.com.github.cm.visao;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import matheus321699.com.github.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")

// O JPanel é um container, ou seja, é um agrupador de componentes 
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(
				tabuleiro.getQuantidadeLinhas(), tabuleiro.getQuantidadeColunas()));
	
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		
		tabuleiro.registrarObservador(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou()) {
					JOptionPane.showMessageDialog(this, "Ganhou :)");
				} else {
					JOptionPane.showMessageDialog(this, "Perdeu :(");
				}
				
				tabuleiro.reiniciar();
				});
		});
//		int total = tabuleiro.getQuantidadeLinhas() * tabuleiro.getQuantidadeColunas();
	
//		for (int i = 0; i < total; i++) {
//			add(new BotaoCampo(null));
//		}
	}
}
