package application;

import java.util.List;

public interface MembreDAO {
	void insere(Membre m);
    List<Membre> chargerListIncidents();
}