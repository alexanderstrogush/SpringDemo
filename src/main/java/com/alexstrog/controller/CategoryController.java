package com.alexstrog.controller;

import com.alexstrog.model.Category;
import com.alexstrog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Category> categories = categoryService.getAll()
                .orElse(Collections.emptyList());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.addObject("category", new Category());
        modelAndView.setViewName("add-category");
        return modelAndView;
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Category category, ModelAndView modelAndView) {
        categoryService.create(category);
        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("categories");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("c_id") Long id, ModelAndView modelAndView) {
        modelAndView.addObject("category", categoryService.getById(id));
        modelAndView.setViewName("edit-category");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Category category, ModelAndView modelAndView) {
        categoryService.update(category);

        return getAllCategoriesAndBindToMv();

//        return updateData.apply(categoryService.getAll()
//                .orElseGet(Collections::emptyList))
//                .apply(modelAndView);

//        List<Category> categories = categoryService.getAll()
//                .orElseGet(Collections::emptyList);
//
//        modelAndView.addObject("categories", categories);
//        modelAndView.setViewName("categories");
//        return modelAndView;
    }

    @RequestMapping(value = "/delete-category", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("c_id") Long id, ModelAndView modelAndView) {
        categoryService.delete(id);

        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);

        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("categories");
        return modelAndView;
    }

//    private Supplier<List<Category>> bindModelAndView = () -> categoryService.getAll().orElseGet(Collections::emptyList);
//
//    private Function<List<Category>, Function<ModelAndView, ModelAndView>> updateData = l -> mv -> {
//        mv.addObject("categories", l);
//        mv.setViewName("categories");
//        return mv;
//    };

    private ModelAndView getAllCategoriesAndBindToMv() {
        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories", categories);
        modelAndView.setViewName("categories");
        return modelAndView;
    }
}
