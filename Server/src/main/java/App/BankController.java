package App;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class BankController {
    private BankRepository repository;

    public BankController(BankRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/banks")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Bank> banks() {
        return repository.findAll()
                .stream()
//                .filter(this::activeBanks)
                .collect(Collectors.toList());
    }

    private boolean activeBanks(Bank bank) {
        return bank.getName().equals("Select Bank") ||
                bank.getName().equals("JP Morgan") ||
                bank.getName().equals("Bank of America") ||
                bank.getName().equals("HSBC") ||
                bank.getName().equals("Bank of New-York");
    }
}