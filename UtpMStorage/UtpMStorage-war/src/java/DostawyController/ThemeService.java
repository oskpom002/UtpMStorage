/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DostawyController;

/**
 *
 * @author Olek
 */
import java.util.ArrayList;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
 
import DostawyController.Theme;
 
@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService {
     
    private List<Theme> theme;
     
    
    @PostConstruct
    public void init() {
        theme = new ArrayList<Theme>();
        theme.add(new Theme(0, "Afterdark", "afterdark"));
        theme.add(new Theme(1, "Afternoon", "afternoon"));
        theme.add(new Theme(2, "Afterwork", "afterwork"));
        theme.add(new Theme(3, "Aristo", "aristo"));
        theme.add(new Theme(4, "Black-Tie", "black-tie"));
        theme.add(new Theme(5, "Blitzer", "blitzer"));
        theme.add(new Theme(6, "Bluesky", "bluesky"));
        theme.add(new Theme(7, "Bootstrap", "bootstrap"));
        theme.add(new Theme(8, "Casablanca", "casablanca"));
        theme.add(new Theme(9, "Cupertino", "cupertino"));
        theme.add(new Theme(10, "Cruze", "cruze"));
        theme.add(new Theme(11, "Dark-Hive", "dark-hive"));
        theme.add(new Theme(12, "Delta", "delta"));
        theme.add(new Theme(13, "Dot-Luv", "dot-luv"));
        theme.add(new Theme(14, "Eggplant", "eggplant"));
        theme.add(new Theme(15, "Excite-Bike", "excite-bike"));
        theme.add(new Theme(16, "Flick", "flick"));
        theme.add(new Theme(17, "Glass-X", "glass-x"));
        theme.add(new Theme(18, "Home", "home"));
        theme.add(new Theme(19, "Hot-Sneaks", "hot-sneaks"));
        theme.add(new Theme(20, "Humanity", "humanity"));
        theme.add(new Theme(21, "Le-Frog", "le-frog"));
        theme.add(new Theme(22, "Midnight", "midnight"));
        theme.add(new Theme(23, "Mint-Choc", "mint-choc"));
        theme.add(new Theme(24, "Overcast", "overcast"));
        theme.add(new Theme(25, "Pepper-Grinder", "pepper-grinder"));
        theme.add(new Theme(26, "Redmond", "redmond"));
        theme.add(new Theme(27, "Rocket", "rocket"));
        theme.add(new Theme(28, "Sam", "sam"));
        theme.add(new Theme(29, "Smoothness", "smoothness"));
        theme.add(new Theme(30, "South-Street", "south-street"));
        theme.add(new Theme(31, "Start", "start"));
        theme.add(new Theme(32, "Sunny", "sunny"));
        theme.add(new Theme(33, "Swanky-Purse", "swanky-purse"));
        theme.add(new Theme(34, "Trontastic", "trontastic"));
        theme.add(new Theme(35, "UI-Darkness", "ui-darkness"));
        theme.add(new Theme(36, "UI-Lightness", "ui-lightness"));
        theme.add(new Theme(37, "Vader", "vader"));
    }
     
    public List<Theme> getThemes() {
        return theme;
    } 
}