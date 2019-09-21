package th.co.bda.applytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.co.bda.applytest.entity.Transaction;
import th.co.bda.applytest.model.Result;
import th.co.bda.applytest.service.TransactionService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Result saveTransaction(@RequestBody Transaction transaction) throws Exception{
        return transactionService.saveTransaction(transaction);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public List<Transaction> getAllTransaction() throws Exception{
        return transactionService.getAllTransaction();
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public Result deleteTransaction(@RequestBody long id) throws Exception{
        return transactionService.deleteTransaction(id);
    }
}
