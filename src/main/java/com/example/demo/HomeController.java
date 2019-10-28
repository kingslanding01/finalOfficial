package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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
        model.addAttribute("songs", songRepository.findAll());
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
    @PostMapping("/refresh")
    public String albumRefresh(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "song";
    }


    @PostMapping("/purchase")
    public String purchase(@RequestBody Map<String, int[]> payload) {
        for (int albumId : payload.get("albums")) {
            Transaction transaction = new Transaction((int) Array.get(payload.get("priceEach"), 0), (int) Array.get(payload.get("user"), 0), albumId);
            transactionRepository.save(transaction);
        }
        int newBalance = (int) Array.get(payload.get("newUserBalance"), 0);
        userRepository.findById(new Long((int) Array.get(payload.get("user"), 0)));
        return "album";
    }
//    @RequestMapping("/refresh")
//    public String refreshAlbum(){
//        return "song";
//    }

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

        ArrayList<HashMap<String, Object>> songs = new ArrayList<>();

        for (Song s : songRepository.findAll()) {
            Album a = s.getAlbum();
            HashMap<String, Object> song = new HashMap<>();
            song.put("albumName", a.getAlbumname());
            song.put("genre", a.getGenre());
            song.put("year", a.getYear());
            song.put("songName", s.getSongname());
            song.put("duration", s.getDuration());
            song.put("artist", s.getArtist());
            song.put("albumId", a.getId());
            song.put("songId", s.getId());
            songs.add(song);
        }
        model.addAttribute("songs", songs);
        model.addAttribute("transactions", transactionRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
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