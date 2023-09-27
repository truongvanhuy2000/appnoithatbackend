package com.huy.backendnoithat.Controller.ThongTinNoiThat;

import com.huy.backendnoithat.DTO.BangNoiThat.HangMuc;
import com.huy.backendnoithat.Service.ThongTinNoiThat.HangMuc.HangMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hangmuc")
public class HangMucController {
    HangMucService hangMucService;
    @Autowired
    public HangMucController(HangMucService hangMucService) {
        this.hangMucService = hangMucService;
    }
    @GetMapping("")
    public List<HangMuc> findAll(@RequestParam(value = "owner") String owner) {
        return hangMucService.findAll(owner);
    }
    @GetMapping("/search")
    public HangMuc findUsingName(@RequestParam(value = "owner") String owner, @RequestParam(value = "name") String name) {
        return hangMucService.findUsingName(owner, name);
    }
    @GetMapping("/{id}")
    public HangMuc findById(@RequestParam(value = "owner") String owner, @PathVariable int id) {
        return hangMucService.findUsingId(owner, id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam(value = "owner") String owner, @PathVariable int id) {
        hangMucService.deleteById(owner, id);
    }
    @PutMapping("")
    public void update(@RequestParam(value = "owner") String owner, @RequestBody HangMuc hangMuc) {
        hangMucService.update(owner, hangMuc);
    }
    @PostMapping("")
    public void save(@RequestParam(value = "owner") String owner, @RequestBody HangMuc hangMuc, @RequestParam("parentId") int parentId) {
        hangMucService.save(owner, hangMuc, parentId);
    }
    @GetMapping("/searchByNoiThat/{id}")
    public List<HangMuc> searchByNoiThat(@RequestParam(value = "owner") String owner, @PathVariable int id) {
        return hangMucService.searchByNoiThat(owner, id);
    }
    // Dont use this API yet
    @GetMapping("/fetch")
    public List<HangMuc> joinFetchHangMuc(@RequestParam(value = "owner") String owner) {
        return hangMucService.joinFetchHangMuc();
    }
    @GetMapping("/fetch/{id}")
    public HangMuc joinFetchHangMucUsingId(@RequestParam(value = "owner") String owner, @PathVariable int id) {
        return hangMucService.joinFetchHangMucUsingId(id);
    }
}
