
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Home extends JFrame implements ActionListener {
	public JButton funcionario, empresa;
	public ResourceBundle bn = null;
	private Container container;
	
	public Home(ResourceBundle bn)
	{
		super("Inicio");
		
		//LoginGUI l = new LoginGUI();
		this.bn = bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		
		//criar botoes
		local.gridx = 0;
		local.gridy = 0;
		funcionario = new JButton(bn.getString("telaInicio.botao.funcionario"));
		container.add(funcionario, local);
		funcionario.addActionListener(this);
		
		local.gridx = 1;
		empresa = new JButton(bn.getString("telaInicio.botao.empresa"));
		container.add (empresa, local);
		empresa.addActionListener(this);
		
		setTitle(bn.getString("telaInicio.titulo"));
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == funcionario)
		{
			HomeFunc g = new HomeFunc(bn);
			g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			g.setSize(600,350);
			g.setVisible(true);
			g.setLocation(400,150);
			g.setResizable(false);
		}
		if(event.getSource() == empresa)
		{
			HomeEmpresa h = new HomeEmpresa(bn);
			h.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			h.setSize(600,350);
			h.setVisible(true);
			h.setLocation(400,150);
			h.setResizable(false);
		}
	}
}
