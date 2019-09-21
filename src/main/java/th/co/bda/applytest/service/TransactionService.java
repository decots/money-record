package th.co.bda.applytest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.bda.applytest.entity.Transaction;
import th.co.bda.applytest.model.Result;
import th.co.bda.applytest.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TransactionRepository transactionRepository;

    public Result saveTransaction(Transaction transaction){
        Result result = new Result();
        try{
            transactionRepository.save(transaction);
            result.setStatus("T");
            result.setDescription("SUCCESS");
            return result;
        }catch (Exception e){
            result.setStatus("F");
            result.setDescription("error: "+ e.getMessage());
            logger.error("error while adding transaction: {}", e.getMessage());
            return result;
        }
    }

    public List<Transaction> getAllTransaction(){
        try {
            List<Transaction> transactions = transactionRepository.findAll();
            return transactions;
        }catch (Exception e){
            logger.error("error while getting transactions: {}", e.getMessage());
            return null;
        }
    }

    public Result deleteTransaction(long id){
        Result result = new Result();
        try{
            transactionRepository.deleteById(id);
            result.setStatus("T");
            result.setDescription("SUCCESS");
            return result;
        }catch (Exception e){
            result.setStatus("F");
            result.setDescription("error: "+ e.getMessage());
            logger.error("error while deleting transaction: {}", e.getMessage());
            return result;
        }
    }


}
