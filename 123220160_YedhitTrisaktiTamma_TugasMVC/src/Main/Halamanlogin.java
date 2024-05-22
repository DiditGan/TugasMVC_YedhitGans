package Main;

import View.Mahasiswa.ViewData;
import View.Dosen.ViewDataDosen;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Halamanlogin extends JFrame implements ActionListener{
    JLabel tulisan = new JLabel("Selamat Datang!");
    JLabel tulisan2 = new JLabel("Silahkan Masuk Untuk Melanjutkan.");
    JLabel nama = new JLabel("Nama: Yedhit trisakti Tamma");
    JLabel nim = new JLabel("NIM: 123220160");
    JLabel user = new JLabel("Username");
    
    JTextField inputuser = new JTextField();
    
    JButton masuk = new  JButton ("Masuk");
    
    public Halamanlogin(){
    setVisible(true);
        setSize(520, 300);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        add(tulisan);
        tulisan.setBounds(20, 0, 300, 40);
        tulisan.setFont(new Font("Times new roman", Font.PLAIN, 30));
        
        add(tulisan2);
        tulisan2.setBounds(20, 20, 300, 40);
        tulisan2.setFont(new Font("Times new roman", Font.PLAIN, 15));
        
        add(nama);
        nama.setBounds(20, 50, 300, 40);
        nama.setFont(new Font("Times new roman", Font.PLAIN, 15));
        
        add(nim);
        nim.setBounds(20, 70, 300, 40);
        nim.setFont(new Font("Times new roman", Font.PLAIN, 15));
        
        add(user);
        user.setBounds(20, 100, 300, 40);
        user.setFont(new Font("Times new roman", Font.PLAIN, 15));
        
        add(inputuser);
        inputuser.setBounds(20, 135, 460, 40);
        
        add(masuk);
        masuk.setBounds(20, 200, 460, 40);
        masuk.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String username = inputuser.getText();
            
            if (username.isEmpty()){
                throw new Exception("Jangan kosong!!!.");
            }
            
                new Halamanhome(username);
                this.dispose();

        } catch (Exception error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}