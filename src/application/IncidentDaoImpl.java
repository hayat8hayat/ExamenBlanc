package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDaoImpl implements IncidentDAO {
	private DatabaseConnection dbConnection = new DatabaseConnection();

    @Override
    public void inserer(Incident i) {
        try (Connection conn = dbConnection.getConnection()) {
            String sql = "INSERT INTO Incident (ref, time, status) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, i.getRef());
            pstmt.setString(2, i.getTime());
            pstmt.setString(3, i.getStatus());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'insertion de l'incident", e);
        }
    }

    @Override
    public void inser(Set<Incident> is) {
        for (Incident incident : is) {
            inserer(incident);
        }
    }
}
