package payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class DrugController {

    @Autowired
    private final DrugRepository repository;

    DrugController(DrugRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/api/DrugsApi")
    List<Drug> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/api/DrugsApi/search")
    List<Drug> allByQuery(
        @RequestParam(value = "query") String query
    ) {
        return repository.findByQuery(query.toUpperCase());
    }

    @PostMapping("/api/DrugsApi")
    Drug newDrug(@RequestBody Drug newDrug) {
        return repository.save(newDrug);
    }

    // Single item

    @GetMapping("/api/DrugsApi/{drugid}")
    Drug one(@PathVariable Long drugid) {
        return repository.findById(drugid)
        .orElseThrow(() -> new DrugNotFoundException(drugid));
    }

    @PutMapping("/api/DrugsApi/{drugid}")
    Drug replaceDrug(@RequestBody Drug newDrug, @PathVariable Long drugid) {

        Drug drug = repository.findById(drugid).get();
            drug.setName(newDrug.getName());
            drug.setAction(newDrug.getAction());
            drug.setLocation(newDrug.getLocation());
            drug.setExpired(newDrug.getExpired());
            repository.save(drug);
            return drug;
    }
    @DeleteMapping("/api/DrugsApi/{drugid}")
    void deleteDrug(@PathVariable Long drugid) {
        repository.deleteById(drugid);
    }
}
