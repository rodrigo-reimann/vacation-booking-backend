package travelapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String division_name;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    //private long countryID;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Customer> customers = new HashSet<>();

    public Division () {}

    public Division (String division_name) {
        this.division_name = division_name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Associates the given customer with this division.
     * This method ensures that the relationship between the division
     * and its customers remains consistent on both sides:
     * 1. The customer is added to the division's list of customers.
     * 2. The division reference in the customer object is set to this division.
     *
     * @param customer The customer to be associated with this division.
     */
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        customer.setDivision(this);
    }
}
