package payroll;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface DrugRepository extends JpaRepository<Drug, Long> {
    
    @Query(value = "SELECT * FROM drug WHERE UPPER(name) LIKE %:query%" + 
    " OR UPPER(action) LIKE %:query%" +
    " OR UPPER(location) LIKE %:query%" +
    " OR expired LIKE %:query%", nativeQuery = true)
    List<Drug> findByQuery(@Param("query")String query);
}