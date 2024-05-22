package Controller;

import Model.Dosen.*;
import View.Dosen.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerDosen {
    ViewDataDosen viewTableDosen;
    InputDataDosen viewInputDosen;
    EditDataDosen viewEditDosen;

    InterfaceDAODosen daoDosenImpl;

    List<ModelDosen> listDosen;
 
    public ControllerDosen(ViewDataDosen viewTableDosen) {
        this.viewTableDosen = viewTableDosen;
        this.daoDosenImpl = new DAODosen();
    }
    
    public ControllerDosen(InputDataDosen viewInputDosen) {
        this.viewInputDosen = viewInputDosen;
        this.daoDosenImpl = new DAODosen();
    }
    
    public ControllerDosen(EditDataDosen viewEditDosen) {
        this.viewEditDosen = viewEditDosen;
        this.daoDosenImpl = new DAODosen();
    }

    public void showAllDosen() {
        listDosen = daoDosenImpl.getAll();

        ModelTableDosen table = new ModelTableDosen(listDosen);

        viewTableDosen.getTableDosen().setModel(table);
    }

    public void insertDosen() {
        try {
            ModelDosen dosenBaru = new ModelDosen();
            
            String name = viewInputDosen.getInputNama();
            String nidn = viewInputDosen.getInputNIDN();

            if ("".equals(name) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            dosenBaru.setName(name);
            dosenBaru.setNidn(nidn);
            
            daoDosenImpl.insert(dosenBaru);
            
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan");
            
            viewInputDosen.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editDosen(int id) {
        try {
            ModelDosen dosenToEdit = new ModelDosen();
                        
            String name = viewEditDosen.getInputNama();
            String nidn = viewEditDosen.getInputNIDN();

            if ("".equals(name) || "".equals(nidn)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }
            
            dosenToEdit.setId(id);
            dosenToEdit.setName(name);
            dosenToEdit.setNidn(nidn);
            
            daoDosenImpl.update(dosenToEdit);

            JOptionPane.showMessageDialog(null, "Data Dosen berhasil diupdate");

            viewEditDosen.dispose();
            new ViewDataDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteDosen(Integer row) {
        Integer id = (int) viewTableDosen.getTableDosen().getValueAt(row, 0);
        String name = viewTableDosen.getTableDosen().getValueAt(row, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Delete " + name + "?",
                "Delete Dosen",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoDosenImpl.delete(id);

            JOptionPane.showMessageDialog(null, "Hapus Data berhasil");

            showAllDosen();
        }
    }
}
