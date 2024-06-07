package com.ohgiraffers.springbootjpa.menu.controller;

import com.ohgiraffers.springbootjpa.common.Pagenation;
import com.ohgiraffers.springbootjpa.common.PagingButton;
import com.ohgiraffers.springbootjpa.menu.dto.CategoryDTO;
import com.ohgiraffers.springbootjpa.menu.dto.MenuDTO;
import com.ohgiraffers.springbootjpa.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j  // 로그 어노테이션
@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @GetMapping("/{menuCode}")
    public String findMenuByCode(@PathVariable("menuCode") int menuCode, Model model) {
        MenuDTO resultMenu = menuService.findMenuByMenuCode(menuCode);
        model.addAttribute("menu", resultMenu);
        return "menu/detail";
    }
    @GetMapping("/list")
    public String findAllMenuList(Model model ,  @PageableDefault Pageable pageable) {  //
//        List<MenuDTO> menuList = menuService.findMenuList();
//        model.addAttribute("menuList", menuList);
        log.info("pageable: {}", pageable );    // pageable: Page request [number: 0, size 10, sort: UNSORTED]
        Page<MenuDTO> menuList = menuService.findMenuList(pageable);
        log.info("{}", menuList.getContent());
        log.info("{}", menuList.getTotalPages());
        log.info("{}", menuList.getTotalElements());
        log.info("{}", menuList.getSize());
        log.info("{}", menuList.getNumberOfElements());
        log.info("{}", menuList.isFirst());
        log.info("{}", menuList.isLast());
        log.info("{}", menuList.getSort());
        log.info("{}", menuList.getNumber());
        PagingButton paging = Pagenation.getPagingButtonInfo(menuList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);
        return "menu/list";
    }

    @GetMapping("/querymethod") //
    public void queryMethodPage(){}

    @GetMapping("/search")
    public String findByMenuPrice(@RequestParam Integer menuPrice, Model model){
        List<MenuDTO> menuList = menuService.findByMenuPrice(menuPrice);
        model.addAttribute("menuList", menuList);
        model.addAttribute("menuPrice", menuPrice);
        return "menu/searchResult";
    }
    @GetMapping("/regist")
    public void registPage(){}

    @GetMapping("/category")
    @ResponseBody
    public List<CategoryDTO> findCategoryList(){
        return menuService.findAllCategory();
    }
    @PostMapping("/regist")
    public String registNewMenu(MenuDTO newMenu) {
        menuService.registMenu(newMenu);
        return "redirect:/menu/list";
    }
    @GetMapping("/modify")
    public void modifyPage(){}
    @PostMapping("/modify")
    public String modifyMenu(MenuDTO menuDTO) {
        menuService.modifyMenu(menuDTO);
        return "redirect:/menu/" + menuDTO.getMenuCode();
    }

    @GetMapping("/delete")
    public void deletePage(){}
    @PostMapping("/delete")
    public String deleteMenu(@RequestParam Integer menuCode){
        menuService.deleteMenu(menuCode);
        return "redirect:/menu/list";
    }
}
