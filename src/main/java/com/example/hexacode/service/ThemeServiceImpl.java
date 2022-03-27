package tn.esprit.hexacode.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Theme;
import tn.esprit.hexacode.Repository.ThemeRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService{

    @Autowired
    ThemeRepository themeRepository;

    @Override
    public Theme addTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public void deleteTheme(Long idTheme) {
        themeRepository.deleteById(idTheme);
    }
}
