package com.alexstrog.controller;

import com.alexstrog.model.Category;
import com.alexstrog.model.Product;
import com.alexstrog.service.CategoryService;
import com.alexstrog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView getAllById(@RequestParam("c_id") Long id, ModelAndView modelAndView) {
        List<Product> products = productService.getAllByCategoryId(id)
                .orElseGet(Collections::emptyList);

        modelAndView.addObject("products", products);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.addObject("product", new Product());
        modelAndView.setViewName("add-product");
        return modelAndView;
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Product product, @RequestParam("c_id") Long id, ModelAndView modelAndView) {
        Category category = categoryService.getById(id).orElseGet(Category::new);
        product.setCategory(category);
        productService.save(product);

        List<Product> products = productService.getAllByCategoryId(id)
                .orElseGet(Collections::emptyList);

        modelAndView.addObject("products", products);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping(value = "/delete-product", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("p_id") Long id, @RequestParam("c_id") Long categoryId, ModelAndView modelAndView) {
        productService.deleteById(id);

        List<Product> products = productService.getAllByCategoryId(categoryId)
                .orElseGet(Collections::emptyList);

        modelAndView.addObject("products", products);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-product", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("p_id") Long id, ModelAndView modelAndView){
        modelAndView.addObject("product", productService.getById(id).get());
        modelAndView.setViewName("edit-product");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-product", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute Product product, @RequestParam("c_id") Long id, ModelAndView modelAndView) {
        Category category = categoryService.getById(id).get();
        product.setCategory(category);
        productService.update(product);

        List<Product> products = productService.getAllByCategoryId(id)
                .orElseGet(Collections::emptyList);

        modelAndView.addObject("products", products);
        modelAndView.setViewName("products");
        return modelAndView;
    }
}
