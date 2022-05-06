package tn.esprit.hexacode.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.LevelDto;
import tn.esprit.hexacode.Entity.OrikaBeanMapper;
import tn.esprit.hexacode.Entity.Theme;
import tn.esprit.hexacode.Repository.LevelRepository;
import tn.esprit.hexacode.Repository.ThemeRepository;
import tn.esprit.hexacode.Service.LevelService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {
    @Autowired
    OrikaBeanMapper orikaBeanMapper;
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    LevelService levelService;

    @Override
    public Level addLevel(Level level, Long idTheme) {
        Theme theme= themeRepository.findById(idTheme).orElse(null);
        level.setTheme(theme);
        return levelRepository.save(level);
    }

    @Override
    public Level addLevel(Level level, Theme theme) {
        theme.addLevel(level);
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

    /*

   @Override
	public List<Client> listedeClients(Long idBoutique) {
		return clientrepository.findByBoutiquesId(idBoutique);
	}
     */
    @Override
    public List<Level> getLevels(Long idTheme) {
        return levelRepository.findByThemeId(idTheme);
    }

}
