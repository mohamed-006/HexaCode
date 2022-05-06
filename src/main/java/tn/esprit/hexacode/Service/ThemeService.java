package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Theme;

import java.util.List;

@Service
public interface ThemeService {
    Theme addTheme(Theme theme);
//
    void deleteTheme(Long idTheme);
//
    List<Theme> getThemes();
//
//    Theme getTheme(Long idTheme);
}
