package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDAO {
	private DatabaseConnection dbConnection = new DatabaseConnection();

    @Override
    public void insere(Membre m) {
        try (Connection conn = dbConnection.getConnection()) {
            String sql = "INSERT INTO Membre (id, nom, prenom, email, phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setLong(1, m.getId());
            pstmt.setString(2, m.getNom());
            pstmt.setString(3, m.getPrenom());
            pstmt.setString(4, m.getEmail());
            pstmt.setString(5, m.getPhone());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion du membre", e);
        }
    }

    @Override
    public List<Membre> chargerListIncidents() {
        List<Membre> membres = new ArrayList<>();
        try (Connection conn = dbConnection.getConnection(); 
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Membre")) {

            while (rs.next()) {
                Membre membre = new Membre(
                    rs.getLong("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                membres.add(membre);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du chargement des membres", e);
        }
        return membres;
    }
}

