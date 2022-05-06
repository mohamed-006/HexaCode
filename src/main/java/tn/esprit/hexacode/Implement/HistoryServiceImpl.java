package tn.esprit.hexacode.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.History;
import tn.esprit.hexacode.Entity.OrikaBeanMapper;
import tn.esprit.hexacode.Repository.HistoryRepository;
import tn.esprit.hexacode.Service.HistoryService;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@Component
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryRepository historyRepository;
    @Autowired
    HistoryService historyService;
    @Autowired
    OrikaBeanMapper orikaBeanMapper;


    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public List<History> getHistories() {
        List<History> histories = historyRepository.findAll();
        histories.sort((f1, f2) -> Long.compare(f2.getScore(), f1.getScore()));
        return orikaBeanMapper.convertListDTO(histories,History.class);
    }

    @Override
    public History findHistoryByScore(Long score) {
        return historyRepository.findHistoryByScore(score);
    }

    @Override
    public History findHistoryByUsername(String username) {
        return historyRepository.findHistoryByUsername(username);
    }

    @Override
    public History editHistory(History history, String username) {
        History history1 = orikaBeanMapper.map(history, History.class);
        History history2 = historyRepository.findHistoryByUsername(username);
        return orikaBeanMapper.convertDTO(historyService.editHistory(history1, history2), History.class);
    }

    @Override
    public History editHistory(History history, History history1) {
        history.setUsername(history1.getUsername());
        history.setLevelName(history1.getLevelName());
        history.setThemeName(history1.getThemeName());
        history.setScore(history1.getScore());
        history.setTotal(history1.getTotal());
        return historyRepository.save(history);
    }


}
