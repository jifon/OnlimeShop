package com.info.demo.controller;

import com.info.demo.model.OrderDetail;
import com.info.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.info.demo.model.Category;
import com.info.demo.model.Product;
import com.info.demo.service.CategoryService;
import com.info.demo.service.FileUploadService;
import com.info.demo.service.ProductService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("manager")
public class ManagerController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private FileUploadService fileUploadService;

	@GetMapping("index")
	public String index() {
		return "manager/index";
	}

//	For Category--------------------------------------------------
	@GetMapping("category-form")
	public ModelAndView listCategory() {
		ModelAndView mv = new ModelAndView("manager/category-form");
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}

	@PostMapping("add-category")
	public ModelAndView addCategory(Category category) {
		ModelAndView mv = new ModelAndView("manager/category-form");
		categoryService.addCategory(category);
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("delete-Category/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("manager/category-form");
		categoryService.deleteCategory(Long.parseLong(categoryId));
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("updateCategory/{categoryId}")
	public ModelAndView updateCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("manager/updateCategory");
		mv.addObject("Category", categoryService.getCategory(Long.parseLong(categoryId)).get());
		return mv;
	}
	
//	For Product--------------------------------------------------
	@GetMapping("product-form")
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("manager/product-form");
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("productList", productService.listProduct());
		return mv;
	}

	@PostMapping("add-product")
	public ModelAndView addProduct(Product product, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("manager/product-form");
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		product.setImage(filePath);
		
		System.out.println(product.getImage());
		
		productService.addProduct(product);
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	@GetMapping("delete-Product/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("manager/product-form");
		productService.deleteProduct(Long.parseLong(productId));
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	@GetMapping("updateProduct/{productId}")
	public ModelAndView updateProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("manager/updateProduct");
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("Product", productService.getProductById(Long.parseLong(productId)).get());
		return mv;
	}

	//очет 1 самые продоваемые продукты (фильтр по времени)
	@GetMapping("report1/{dateStart}/{dateEnd}")
	public String reportFirst(@PathVariable("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @PathVariable("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd, Model model) {

		List<OrderDetail> list2 =orderDetailService.findByDate(dateStart, dateEnd);
		model.addAttribute("lists2", list2);
		return "reportFirst";
	}

	@GetMapping("report2/{dateStart}/{dateEnd}")
	public String reportSecond(@PathVariable("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart, @PathVariable("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd, Model model) {

		List<OrderDetail> list2 =orderDetailService.findNotCompleted(dateStart, dateEnd);
		model.addAttribute("lists2", list2);
		return "reportSecond";
	}


}
