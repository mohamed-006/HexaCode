package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.History;



@Service
public interface HistoryService {
    History addHistory(History history);
    History findHistoryByScore(Long score);
    History findHistoryByUsername(String username);
}
