package artur.dudek.com.myDictionary.controller;


import artur.dudek.com.myDictionary.entity.Customer;
import artur.dudek.com.myDictionary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/list")
    public String listCustomers(Model model){
        List<Customer> customers = service.findAll();
        //List<Customer> customers = service.getCustometNativeQueryDudek();
        model.addAttribute("customers", customers);
        return "list-customers";
    }


    @RequestMapping("/showFormForAdd")
    public String formForAdd(Model model){
        Customer theCustomer = new Customer();
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

//    @GetMapping("/deleteCustomer")
//    public String deleteCustomer(@RequestParam("customerToDeleteId")int theId){
//        service.deleteCustomer(theId);
//        return "redirect:/customer/list";
//    }
    @PostMapping("/saveCustomer")
    public String processForm(@ModelAttribute("customer")Customer theCustomer){
        System.out.println("W saveCustomer theCustomer="+theCustomer);
        service.save(theCustomer);
        return "redirect:/customer/list";
    }
    @GetMapping("/showFormForUpdate/{theId}")
    //public String formForUpdate(@RequestParam("customerId") int theId, Model model)
    public String formForUpdate(@PathVariable int theId, Model model)
    {
        Optional<Customer> customer = service.findCustomerById(theId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }
//
//    @PostMapping("/search")
//    public String loadCustomerByName(@RequestParam("theSearchName")String theName, Model model){
//        List<Customer> selectedCustomers = service.getCustomer(theName);
//        model.addAttribute("customers", selectedCustomers);
//        return "list-customers";
//    }



}
