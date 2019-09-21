package th.co.bda.applytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.co.bda.applytest.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
