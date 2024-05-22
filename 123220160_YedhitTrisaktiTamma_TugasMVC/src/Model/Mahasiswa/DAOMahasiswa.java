package Model.Mahasiswa;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOMahasiswa implements InterfaceDAOMahasiswa {
    
    @Override
    public void insert(ModelMahasiswa mahasiswa) {
       try {
            String query = "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?);";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setString(1, mahasiswa.getNama());
            preparedStatement.setString(2, mahasiswa.getNim());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelMahasiswa mahasiswa) {
        try {
            String query = "UPDATE mahasiswa SET nama=?, nim=? WHERE id=?;";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setString(1, mahasiswa.getNama());
            preparedStatement.setString(2, mahasiswa.getNim());
            preparedStatement.setInt(3, mahasiswa.getId());
            
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Update Gagal: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM mahasiswa WHERE id=?;";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Delete Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelMahasiswa> getAll() {
         List<ModelMahasiswa> listMahasiswa = null;

        try {
            listMahasiswa = new ArrayList<>();
            
            Statement statement = Connector.connect().createStatement();

            String query = "SELECT * FROM mahasiswa;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelMahasiswa mhs = new ModelMahasiswa();

                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNim(resultSet.getString("nim"));

                listMahasiswa.add(mhs);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listMahasiswa;
    }
}
