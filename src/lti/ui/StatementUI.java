package lti.ui;


import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lti.dao.accountserv.AccountServiceImpl;
import lti.entity.AccountStatement;


public class StatementUI implements ActionListener {
	private JFrame frame;
	private JTable table;
	private JButton back;
	private String accountnumber;
	
	public StatementUI(String accountnumber){
		//ArrayList<Bus> b;
		this.accountnumber=accountnumber;
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.info);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 61, 851, 199);
		frame.getContentPane().add(scrollPane);
		frame.setVisible(true);
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		tableModel.addColumn("Transaction Date");
		tableModel.addColumn("Transfer Type");
		tableModel.addColumn("Transfer Amount");
		
		tableModel.addColumn("FinalBalance");
		
		
				for(AccountStatement as:new AccountServiceImpl().getTransactions(accountnumber)  ) {
					
						 { tableModel.insertRow(0, new Object[] {as.getTransdate(),as.getTransType(),as.getTransAmount(),as.getFinalBalance() }); }
					
				}
				
		back = new JButton("Back To DashBoard");
		back.setBounds(305, 344, 242, 25);
		frame.getContentPane().add(back);
		back.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			frame.dispose();
			new DashboardUi(accountnumber);
		}
		
	}
}
