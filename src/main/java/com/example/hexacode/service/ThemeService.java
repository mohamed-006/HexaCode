package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Theme;

@Service
public interface ThemeService {
    Theme addTheme(Theme theme);
    void deleteTheme(Long idTheme);
}
