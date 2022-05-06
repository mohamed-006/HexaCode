package tn.esprit.hexacode.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.OrikaBeanMapper;
import tn.esprit.hexacode.Entity.Theme;
import tn.esprit.hexacode.Repository.ThemeRepository;
import tn.esprit.hexacode.Service.ThemeService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    OrikaBeanMapper orikaBeanMapper;

    @Override
    public Theme addTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public void deleteTheme(Long idTheme) {
        themeRepository.deleteById(idTheme);
    }

    @Override
    public List<Theme> getThemes() {
//        List<Theme> themes = themeRepository.findAll();
//        return orikaBeanMapper.convertListDTO(themes, Theme.class);
        return themeRepository.findAll();
    }
//    @Override
//    public Theme getTheme(Long idTheme) {
//       return orikaBeanMapper.convertDTO(themeRepository.findById(idTheme).orElse(null),Theme.class);
//    }
}
