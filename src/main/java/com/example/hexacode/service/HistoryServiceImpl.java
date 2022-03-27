package tn.esprit.hexacode.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.History;
import tn.esprit.hexacode.Repository.HistoryRepository;



@Service
public class HistoryServiceImpl implements HistoryService{
    @Autowired
    HistoryRepository historyRepository;

    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History findHistoryByScore(Long score) {
        return historyRepository.findHistoryByScore(score);
    }

    @Override
    public History findHistoryByUsername(String username) {
        return historyRepository.findHistoryByUsername(username);
    }


}
