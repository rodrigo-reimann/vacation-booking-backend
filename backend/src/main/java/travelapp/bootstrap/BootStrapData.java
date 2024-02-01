package travelapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import travelapp.dao.CountryRepository;
import travelapp.dao.CustomerRepository;
import travelapp.dao.DivisionRepository;
import travelapp.entities.Country;
import travelapp.entities.Customer;
import travelapp.entities.Division;

// CommandLineRunner = interface to tell Spring to run it.
@Component
public class BootStrapData implements CommandLineRunner {

    // dependency injection constructor for instances of customer and division repos
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    private final CountryRepository countryRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CountryRepository countryRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.findByFirstName("Julius").isEmpty()) {
            // create new divisions
            Division rome = new Division("Rome");
            Division transAlpineGaul = new Division("TransAlpineGaul");
            Division macedon = new Division("Macedon");
            Division steppe = new Division("Steppe");
            Division carthage = new Division("Carthage");

            // create new countries
            Country italy = new Country("Italy");
            countryRepository.save(italy);

            Country gaul = new Country("Gaul");
            countryRepository.save(gaul);

            Country greece = new Country("Greece");
            countryRepository.save(greece);

            Country mongolia = new Country("Mongolia");
            countryRepository.save(mongolia);

            Country turkey = new Country("Turkey");
            countryRepository.save(turkey);

            // Create a new Customer instance, address details, and associated division.
            // Then, add this customer to the associated division's list of customers.
            // Finally, save the updated  division into the repository.
            // Since Division is the owning side of the relationship and operations are cascading all, saving it Division suffices
            Customer ceasar = new Customer("Julius", "Ceasar", "Forum", "00186", "100-44", rome );
            rome.setCountry(italy);
            rome.addCustomer(ceasar);
            divisionRepository.save(rome);

            Customer vercingetorix = new Customer("Vercingetorix", "The Gaul", "Averni", "00900", "80-46", transAlpineGaul);
            transAlpineGaul.setCountry(gaul);
            transAlpineGaul.addCustomer(vercingetorix);
            divisionRepository.save(transAlpineGaul);

            Customer alexander = new Customer("Alexander", "The Great", "Pella", "00800", "356-323", macedon);
            macedon.setCountry(greece);
            macedon.addCustomer(alexander);
            divisionRepository.save(macedon);

            Customer genghis = new Customer("Genghis", "Khan", "Borjigin clan", "00200", "1162-1227", steppe);
            steppe.setCountry(mongolia);
            steppe.addCustomer(genghis);
            divisionRepository.save(steppe);

            Customer hannibal = new Customer("Hannibal", "Barca", "Carthage", "00186", "100-44", carthage);
            carthage.setCountry(turkey);
            carthage.addCustomer(hannibal);
            divisionRepository.save(carthage);

            System.out.println("Number of customers: " + customerRepository.count());
        } else {
            System.out.println("Data already bootstrapped");
        }
    }


}
