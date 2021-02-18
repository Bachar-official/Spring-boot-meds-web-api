package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

interface DrugRepository extends JpaRepository<Drug, Long> {
    
}