package com.notification.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.notification.model.AccountDetails;
import com.notification.model.BankAccountDetails;
import com.notification.model.Database;
import com.notification.model.LoginBean;

@Controller
@RequestMapping("/aggregator")
public class AggregatorController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Aggregator");
        return "index";

    }

    @RequestMapping(value = "/saveAccDetails", method = RequestMethod.POST)
    public String saveAccountDetails(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        System.out.println("save account details");
        String chkboxValues[] = request.getParameterValues("bankChk");
        System.out.println("values :: " + chkboxValues.length);

        String email = request.getParameter("email");
        System.out.println("email :: " + email);

        String bankDetails = null;
        String accountDetails[] = null;
        String accNickName = null;
        String custId = null;
        String accType = null;
        String accNo = null;
        Database database = null;
        AccountDetails details = null;
        List<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();
        BankAccountDetails bankAccountDetails = new BankAccountDetails();

        ApplicationContext context = new ClassPathXmlApplicationContext("/accountDetails.xml");
        database = (Database) context.getBean("database");

        for (int i = 0; i < chkboxValues.length; i++) {
            if (chkboxValues[i].equalsIgnoreCase("BarclaysAccount1")) {
                bankDetails = request.getParameter("bankValuesForBar1");
            } else if (chkboxValues[i].equalsIgnoreCase("BarclaysAccount2")) {
                bankDetails = request.getParameter("bankValuesForBar2");
            } else if (chkboxValues[i].equalsIgnoreCase("LLoydsAccount")) {
                bankDetails = request.getParameter("bankValuesForLLoyds");
            }
            System.out.println("bank details :: " + bankDetails);
            accountDetails = bankDetails.split(",");
            accNickName = accountDetails[0];
            custId = accountDetails[1];
            accType = accountDetails[2];
            accNo = accountDetails[3];

            details = new AccountDetails();
            details.setAccountId(accNo);
            details.setAccountNickName(accNickName);
            details.setAccountType(accType);
            details.setCustomerId(custId);
            details.setEmail(email);
        }
        accountDetailsList.add(details);
        bankAccountDetails.setAccountDetails(accountDetailsList);

        database.putData(email, bankAccountDetails);

        System.out.println("values :: " + database.getMap());
        return "confirmationPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean) {
        ModelAndView model = null;
        boolean isValidUser = isValidUser(loginBean.getUsername(), loginBean.getPassword());
        if (isValidUser) {
            System.out.println("User Login Successful");
            request.setAttribute("loggedInUser", loginBean.getUsername());
            model = new ModelAndView("welcome");
        } else {
            model = new ModelAndView("login");
            model.addObject("loginBean", loginBean);
            request.setAttribute("message", "Invalid credentials!!");
        }
        return model;
    }

    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("login");
        LoginBean loginBean = new LoginBean();
        model.addObject("loginBean", loginBean);
        return model;
    }
    
    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("register");
        return model;
    }
    
    @RequestMapping(value = "/transactionDetails", method = RequestMethod.GET)
    public ModelAndView transactionDetails(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView("transactionDetails");
        return model;
    }

    private boolean isValidUser(String username, String password) {
        // TODO Auto-generated method stub
        if (null != username && null != password && username.equalsIgnoreCase("tushar.gorde@gmail.com") && password.equalsIgnoreCase("test123")) {
            return true;
        } else
            return false;
    }

}
