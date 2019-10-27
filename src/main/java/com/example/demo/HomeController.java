package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;


    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("users", new User());

        return "homepage";
    }

    @RequestMapping("/album")
    public String albumList(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "album";
    }

    @RequestMapping("/admin")
    public String adminList(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "admin";
    }

    @RequestMapping("/updatealbum")
    public String updateAlbum(@Valid Album album,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "album";
        }
        albumRepository.save(album);
        return "redirect:/updatealbum";
    }

    @GetMapping("/homepage")
    public String userForm(Model model) {
        model.addAttribute("users", new User());

        return "homepage";

    }

    @PostMapping("/purchase")
    public String purchase(@RequestBody Map<String, int[]> payload) {
        for (int albumId : payload.get("albums")) {
            Transaction transaction = new Transaction((int) Array.get(payload.get("priceEach"), 0), (int) Array.get(payload.get("user"), 0), albumId);
            transactionRepository.save(transaction);
        }
        int newBalance = (int) Array.get(payload.get("newUserBalance"), 0);
        userRepository.findById((long) Array.get(payload.get("user"), 0));
        return "album";
    }

    @GetMapping("/transaction")
    public String transaction(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        model.addAttribute("user", userRepository.findAll());
        return "transaction";
    }


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("album", albumRepository.findAll());
        return "admin";
    }

    @GetMapping("/song")
    public String song(Model model) {
        model.addAttribute("song", songRepository.findAll());
        return "song";

    }

    @GetMapping("/add")
    public String albumForm(Model model) {
        model.addAttribute("album", new Album());
        return "updatealbum";
    }

    @PostMapping("/processalbum")
    public String processUpdateAlbum(@Valid Album album,
                                     BindingResult result) {
        if (result.hasErrors()) {
            return "updatealbum";
        }
        albumRepository.save(album);
        return "redirect:/album";
    }


    @PostMapping("/processuser")
    public String processUser(@Valid User user,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "homepage";
        }
        userRepository.save(user);
        return "redirect:/album";
    }


    @PostMapping("/transaction")
    public String processTransaction(@Valid Transaction transaction,
                                     BindingResult result) {
        if (result.hasErrors()) {
            return "transaction";
        }
        transactionRepository.save(transaction);
        return "redirect:/";
    }

    @RequestMapping("/detailalbum/{id}")
    public String showAlbum(@PathVariable("id") long id, Model model) {
        model.addAttribute("album", albumRepository.findById(id));
        return "album";
    }

    @RequestMapping("/updatealbum/{id}")
    public String updateAlbum(@PathVariable("id") long id, Model model) {
        model.addAttribute("album", albumRepository.findById(id));
        return "updatealbum";
    }

    @RequestMapping("/deletealbum/{id}")
    public String delAlbum(@PathVariable("id") long id) {
        albumRepository.deleteById(id);
        return "redirect:/";
    }


}