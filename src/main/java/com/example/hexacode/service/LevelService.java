package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;

@Service
public interface LevelService {
    Level addLevel(Level level , Long idTheme);
    Level getLevel(Long idLevel);
    void deleteLevel(Long idLevel);
}
