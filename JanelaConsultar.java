
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;


public class JanelaConsultar extends JFrame implements ActionListener{
	private JLabel cnpj;
	private JTextField txtCnpj;
	private JButton busca;
	private Container container;
	public ResourceBundle bn= null;
	
	public JanelaConsultar(ResourceBundle bn)
	{
		//criar janela
		super("Consultar Empresa");
		this.bn=bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		
		//criar cnpj
		local.gridx = 0;
		local.gridy = 0;
		cnpj = new JLabel(bn.getString("telaConsulEmpre.CNPJ"));
		container.add(cnpj,local);
		local.gridx = 1;
		txtCnpj = new JTextField();
		txtCnpj.setPreferredSize(new Dimension(300, 25));
		container.add(txtCnpj, local);
		
		//criar botao
		local.gridx = 3;
		local.gridy = 0;
		
		busca = new JButton(bn.getString("telaConsulEmpre.buscar"));
		container.add(busca, local);
		busca.addActionListener(this);
		
		setTitle(bn.getString("telaConsultaFunc.titulo"));
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == busca)
		{
			JanelaAlterar layout = new JanelaAlterar(bn);
			layout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			layout.setSize(600,350);
			layout.setVisible(true);
			layout.setLocation(400,150);
			layout.setResizable(false);
		}
	}
	
	
}
