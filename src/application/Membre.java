package application;

import java.util.Objects;

public class Membre {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String phone;

    public Membre(Long id, String nom, String prenom, String email, String phone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membre)) return false;
        Membre membre = (Membre) o;
        return Objects.equals(id, membre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    

   
}