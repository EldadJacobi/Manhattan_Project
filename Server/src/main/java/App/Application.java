package App;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner init(BankRepository bankRepository, DictionaryRepository dictionaryRepository) {

        List<String> banks = new ArrayList<>();
        banks.add("JP Morgan");
        banks.add("HSBC");
        banks.add("Bank of New-York");
        banks.add("Bank of America");


        return args -> {

            banks.stream().forEach(bankName -> {
                Bank bank = new Bank();
                bank.setName(bankName);
                Dictionary dictionary = new Dictionary();

                bank.setDictionary(dictionary);

                dictionaryRepository.save(dictionary);
                bankRepository.save(bank);
            });
            bankRepository.findAll().forEach(System.out::println);
        };
    }
}
