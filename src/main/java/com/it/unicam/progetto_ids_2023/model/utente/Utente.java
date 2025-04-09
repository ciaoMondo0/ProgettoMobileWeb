package main.java.com.it.unicam.progetto_ids_2023.model.utente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.it.unicam.progetto_ids_2023.model.contenuto.Contenuto;
import main.java.com.it.unicam.progetto_ids_2023.model.puntodiinteresse.PuntoDiInteresse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "utente")
@Data
@NoArgsConstructor
public class Utente implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
    private boolean autorizzatoCreazioneContenuto;

    @ManyToMany
    @JoinTable(
            name = "utente_preferiti_contenuti",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "contenuto_id")
    )
    private List<Contenuto> preferitiContenuti;

    @ManyToMany
    @JoinTable(
            name = "utente_preferiti_punti_di_interesse",
            joinColumns = @JoinColumn(name = "utente_id"),
            inverseJoinColumns = @JoinColumn(name = "punto_di_interesse_id")
    )
    private List<PuntoDiInteresse> preferitiPuntiDiInteresse;

    public Utente(String nome, String email, Ruolo ruolo, boolean autorizzatoCreazioneContenuto, String password) {
        this.nome = nome;
        this.email = email;
        this.ruolo = ruolo;
        this.autorizzatoCreazioneContenuto = autorizzatoCreazioneContenuto;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + ruolo.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
