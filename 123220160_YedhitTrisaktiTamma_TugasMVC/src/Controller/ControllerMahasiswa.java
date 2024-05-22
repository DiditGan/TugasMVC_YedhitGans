package Controller;

import Model.Mahasiswa.*;
import View.Mahasiswa.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerMahasiswa {
    
    ViewData viewTableMahasiswa;
    InputData viewInputMahasiswa;
    EditData viewEditMahasiswa;

    InterfaceDAOMahasiswa daoMahasiswaImpl;

    List<ModelMahasiswa> listMahasiswa;
    
    public ControllerMahasiswa(ViewData viewTableMahasiswa) {
        this.viewTableMahasiswa = viewTableMahasiswa;
        this.daoMahasiswaImpl = new DAOMahasiswa();
    }
    
    public ControllerMahasiswa(InputData viewInputMahasiswa) {
        this.viewInputMahasiswa = viewInputMahasiswa;
        this.daoMahasiswaImpl = new DAOMahasiswa();
    }
    
    public ControllerMahasiswa(EditData viewEditMahasiswa) {
        this.viewEditMahasiswa = viewEditMahasiswa;
        this.daoMahasiswaImpl = new DAOMahasiswa();
    }

    public void showAllMahasiswa() {
        
        listMahasiswa = daoMahasiswaImpl.getAll();

        ModelTable table = new ModelTable(listMahasiswa);

        viewTableMahasiswa.getTableMahasiswa().setModel(table);
    }

    public void insertMahasiswa() {
        try {
            ModelMahasiswa mahasiswaBaru = new ModelMahasiswa();
            
            String nama = viewInputMahasiswa.getInputNama();
            String nim = viewInputMahasiswa.getInputNIM();

            if ("".equals(nama) || "".equals(nim)) {
                throw new Exception("Nama atau NIM tidak boleh kosong!");
            }
            
            mahasiswaBaru.setNama(nama);
            mahasiswaBaru.setNim(nim);
            
            daoMahasiswaImpl.insert(mahasiswaBaru);

            JOptionPane.showMessageDialog(null, "Mahasiswa baru berhasil ditambahkan.");

            viewInputMahasiswa.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editMahasiswa(int id) {
        try {
            ModelMahasiswa mahasiswaYangMauDiedit = new ModelMahasiswa();
                        
            String nama = viewEditMahasiswa.getInputNama();
            String nim = viewEditMahasiswa.getInputNIM();

            if ("".equals(nama) || "".equals(nim)) {
                throw new Exception("Nama atau NIM tidak boleh kosong!");
            }

            mahasiswaYangMauDiedit.setId(id);
            mahasiswaYangMauDiedit.setNama(nama);
            mahasiswaYangMauDiedit.setNim(nim);
            
            daoMahasiswaImpl.update(mahasiswaYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil diubah.");

            viewEditMahasiswa.dispose();
            new ViewData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(Integer baris) {
        Integer id = (int) viewTableMahasiswa.getTableMahasiswa().getValueAt(baris, 0);
        String nama = viewTableMahasiswa.getTableMahasiswa().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Mahasiswa",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoMahasiswaImpl.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllMahasiswa();
        }
    }
}
