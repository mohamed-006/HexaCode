package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.History;

import java.util.List;


@Service
public interface HistoryService {
    History addHistory(History history);
    List<History> getHistories();
    History findHistoryByScore(Long score);
    History findHistoryByUsername(String username);
    History editHistory(History history, String username);
    History editHistory(History history, History history1);
}
