package tn.esprit.hexacode.Entity;

import java.util.List;
import java.util.Set;

public class ThemeDTO {

    private Long id;

    private String name;

    private List<LevelDto> levels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }
}
