package Model.Mahasiswa;

import java.util.List;

public interface InterfaceDAOMahasiswa {
    public void insert(ModelMahasiswa mahasiswa);
    
    public void update(ModelMahasiswa mahasiswa);
    
    public void delete(int id);
    
    public List<ModelMahasiswa> getAll();
}
