package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.Theme;

import java.util.List;
import java.util.Set;

@Service
public interface LevelService {
    Level addLevel(Level level , Theme theme);
    Level addLevel(Level level , Long idTheme);
    Level getLevel(Long idLevel);
    void deleteLevel(Long idLevel);
    List<Level> getLevels(Long idTheme);
}
