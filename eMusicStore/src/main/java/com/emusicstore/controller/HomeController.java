package com.emusicstore.controller;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.ECField;
import java.util.List;

/**
 * Created by Alexander on 015 10 15 2016 .
 */
@Controller
public class HomeController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    private Path getImagePath(int productId, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        return Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = productDao.getAllProducts();

        /**instead of actionbean, this is how you use the variable 'products' in the model*/
        model.addAttribute("products", products);

        return "products";
    }

    @RequestMapping("/products/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
//        product.setName("new product name");
//        product.setCategory("new product category");
//        product.setDescription("new product ");
//        product.setPrice(-.009);
//        product.setCondition("new product ");
//        product.setStatus("new product ");
//        product.setUnitsInStock(-1);
//        product.setManufacturer("new product ");

        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        productDao.addProduct(product);

        MultipartFile productImage = product.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = getImagePath(product.getId(), request);

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to save product image", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable("productId") int productId, Model model) {
        Product product = productDao.getProductById(productId);

        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProductPost(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) {
        MultipartFile productImage = product.getImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = getImagePath(product.getId(), request);

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to update product image", e);
            }
        }

        productDao.editProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = getImagePath(productId, request);

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(productId);
        return "redirect:/admin/productInventory";
    }
}
