package ma.ensa.projet.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull(message = "Montant total is mandatory")
    private Double montantTotal;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @NotNull(message = "Client is mandatory")
    private Client client;

    public Facture() {
        this.date = new Date();
    }

    public Facture(Double montantTotal, Client client) {
        this.date = new Date();
        this.montantTotal = montantTotal;
        this.client = client;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}