

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ResourceBundle;

public class JanelaAlterarFunc extends JFrame implements ActionListener{
	private JLabel user, empresa, cpf, nasc, horarioEntr, horarioSaida;
	private JTextField txtUser, txtEmpresa,txtCpf, txtNasc, txtHorarioEntr, txtHorarioSaida;
	private JButton alterar, confirmar, excluir;
	private Container container;
	private Dimension dime;
	public ResourceBundle bn = null;
	
	public JanelaAlterarFunc(ResourceBundle bn)
	{
		super("Alterar Funcionário");
		this.bn = bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		dime = new Dimension(150, 25);
		
		//criar usuario
		local.gridx = 0;
		local.gridy = 0;
		user = new JLabel(bn.getString("telaAlteraFunc.label.usuario"));
		container.add(user, local);
		local.gridx = 1;
		txtUser = new JTextField();
		txtUser.setPreferredSize(dime);
		txtUser.setEditable(false);
		container.add(txtUser, local);
		
		//criar empresa
		local.gridx = 0;
		local.gridy = 1;
		empresa = new JLabel(bn.getString("telaAlteraFunc.label.empresa"));
		container.add(empresa, local);
		local.gridx = 1;
		txtEmpresa = new JTextField();
		txtEmpresa.setPreferredSize(dime);
		txtEmpresa.setEditable(false);
		container.add(txtEmpresa, local);
		
		//criar CPF
		local.gridx = 0;
		local.gridy = 2;
		cpf = new JLabel(bn.getString("telaAlteraFunc.label.CPF"));
		container.add(cpf, local);
		local.gridx = 1;
		txtCpf = new JTextField();
		txtCpf.setPreferredSize(dime);
		txtCpf.setEditable(false);
		container.add(txtCpf, local);
		
		//criar nascimento
		local.gridx = 2;
		local.gridy = 2;
		nasc = new JLabel(bn.getString("telaAlteraFunc.label.Nasc"));
		container.add(nasc, local);
		local.gridx = 3;
		txtNasc = new JTextField();
		txtNasc.setPreferredSize(dime);
		txtNasc.setEditable(false);
		container.add(txtNasc, local);
		
		//horarios
		local.gridx = 0;
		local.gridy = 3;
		horarioEntr = new JLabel(bn.getString("telaAlteraFunc.label.horarioEn"));
		container.add(horarioEntr, local);
		local.gridx = 1;
		txtHorarioEntr = new JTextField();
		txtHorarioEntr.setPreferredSize(dime);
		txtHorarioEntr.setEditable(false);
		container.add(txtHorarioEntr, local);
		
		local.gridx = 2;
		local.gridy = 3;
		horarioSaida = new JLabel(bn.getString("telaAlteraFunc.label.horarioSai"));
		container.add(horarioSaida, local);
		local.gridx = 3;
		txtHorarioSaida = new JTextField();
		txtHorarioSaida.setPreferredSize(dime);
		txtHorarioSaida.setEditable(false);
		container.add(txtHorarioSaida, local);
		
		//Criar botao
		local.gridx = 1;
		local.gridy = 4;
		alterar = new JButton(bn.getString("telaAlteraFunc.botao.alterar"));
		container.add(alterar, local);
		alterar.addActionListener(this);
		confirmar = new JButton(bn.getString("telaAlteraFunc.botao.confirmar"));
		container.add(confirmar, local);
		confirmar.setVisible(false);
		confirmar.addActionListener(this);	
		
		local.gridx = 2;
		excluir = new JButton(bn.getString("telaAlteraFunc.botao.excluir"));
		container.add(excluir, local);
		excluir.addActionListener(this);
		
		setTitle(bn.getString("telaAlteraFunc.titulo"));
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == alterar)
		{
			confirmar.setVisible(true);
			alterar.setVisible(false);
			txtUser.setEditable(true);
			txtCpf.setEditable(true);
			txtEmpresa.setEditable(true);
			txtHorarioEntr.setEditable(true);
			txtHorarioSaida.setEditable(true);
			txtNasc.setEditable(true);
			
		}
		if(event.getSource() == confirmar)
		{
			confirmar.setVisible(false);
			alterar.setVisible(true);
			txtUser.setEditable(false);
			txtCpf.setEditable(false);
			txtEmpresa.setEditable(false);
			txtHorarioEntr.setEditable(false);
			txtHorarioSaida.setEditable(false);
			txtNasc.setEditable(false);
		}
		if(event.getSource() == excluir)
		{
			ExcluirFuncGUI f = new ExcluirFuncGUI(bn);
			f.setVisible(true);//Deixa visivel o container
			f.setSize(500,400);//Tamanho do container
			f.setLocation(540,220);//Onde o container vai ser posicionado
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Ao clicar em sair, fecha a operação
			
		}
	}
	
}