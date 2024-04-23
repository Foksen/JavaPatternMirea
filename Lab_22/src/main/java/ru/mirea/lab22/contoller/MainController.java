package ru.mirea.lab22.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import ru.mirea.lab22.service.BackupService;

@Controller
public class MainController {
    @Autowired
    BackupService backupService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        return "index";
    }

    @GetMapping("/make_backup")
    public String makeBackups(Model model) {
        backupService.makeBackup();
        return "redirect:/";
    }
}
