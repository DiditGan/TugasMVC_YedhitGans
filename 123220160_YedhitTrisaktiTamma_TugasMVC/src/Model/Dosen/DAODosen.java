package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODosen implements InterfaceDAODosen {
    @Override
    public void insert(ModelDosen dosen) {
        try {
            String query = "INSERT INTO dosen (nama, nidn) VALUES (?, ?);";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setString(1, dosen.getName());
            preparedStatement.setString(2, dosen.getNidn());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelDosen dosen) {
        try {
            String query = "UPDATE dosen SET nama=?, nidn=? WHERE id=?;";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setString(1, dosen.getName());
            preparedStatement.setString(2, dosen.getNidn());
            preparedStatement.setInt(3, dosen.getId());
            
            preparedStatement.executeUpdate();
           
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Update gagal: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM dosen WHERE id=?;";
            
            PreparedStatement preparedStatement;
            preparedStatement = Connector.connect().prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Delete gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelDosen> getAll() {
        List<ModelDosen> dosenList = new ArrayList<>();

        try {
            Statement statement = Connector.connect().createStatement();
            
            String query = "SELECT * FROM dosen;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelDosen dosen = new ModelDosen();
                
                dosen.setId(resultSet.getInt("id"));
                dosen.setName(resultSet.getString("nama"));
                dosen.setNidn(resultSet.getString("nidn"));
                
                dosenList.add(dosen);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return dosenList;
    }
}
