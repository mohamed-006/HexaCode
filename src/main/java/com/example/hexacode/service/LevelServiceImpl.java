package tn.esprit.hexacode.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.Theme;
import tn.esprit.hexacode.Repository.LevelRepository;
import tn.esprit.hexacode.Repository.ThemeRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class LevelServiceImpl implements LevelService{
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    ThemeRepository themeRepository;

    @Override
    public Level addLevel(Level level, Long idTheme) {
        Theme theme= themeRepository.findById(idTheme).orElse(null);
        level.setTheme(theme);
        return levelRepository.save(level);
    }

    @Override
    public Level getLevel(Long idLevel) {
        return levelRepository.findById(idLevel).orElse(null);
    }

    @Override
    public void deleteLevel(Long idLevel) {
         levelRepository.deleteById(idLevel);
    }
}
