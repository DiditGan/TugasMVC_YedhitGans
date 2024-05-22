package Main;

import View.Mahasiswa.ViewData;
import View.Dosen.ViewDataDosen;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Halamanhome extends JFrame {
    
    JLabel welcomeLabel = new JLabel();
    JLabel instructionLabel = new JLabel("Silahkan Klik untuk melanjutkan");
    
    JButton viewMahasiswaButton = new JButton("View Data Mahasiswa");
    JButton viewDosenButton = new JButton("View Data Dosen");
    
    public Halamanhome(String username){
        setVisible(true);
        setSize(480,250);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(welcomeLabel);
        welcomeLabel.setText("Welcome, " + username);
        welcomeLabel.setBounds(20, 20, 400, 24);
        welcomeLabel.setFont(new Font("Times new roman", Font.PLAIN, 25));
        add(instructionLabel);
        instructionLabel.setBounds(20, 50, 300, 25);
        instructionLabel.setFont(new Font("Times new roman", Font.PLAIN, 15));
        
        add(viewMahasiswaButton);
        viewMahasiswaButton.setBounds(20, 100, 425, 35);
        
        add(viewDosenButton);
        viewDosenButton.setBounds(20, 150, 425, 35);
        
        viewMahasiswaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewData();
            }
        });
        
        viewDosenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataDosen();
            }
        });
    }
}
