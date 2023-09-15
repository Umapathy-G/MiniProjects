package com.example.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.UserAccount;
import com.example.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getUserAccForm(Model model) {
		model.addAttribute("UserData", new UserAccount());
		return "useraccount";
	}

	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("UserData") UserAccount userAccount, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "useraccount";
		}
		String message = userService.saveOrUpdateUserAcc(userAccount);
		return "redirect:/saveUserSucces?msg=" + message;
	}

	@GetMapping("/saveUserSucces")
	public String saveUserSuccess(@ModelAttribute("UserData") UserAccount userAccount,
			@RequestParam("msg") String message, Model model) {
		model.addAttribute("msg", message);
		return "useraccount";
	}

	@GetMapping("/userList/{msg}")
	public String displayUsers(@PathVariable("msg") Integer msg, Model model) {
		List<UserAccount> allUserAccounts = userService.getAllUserAccounts();
		model.addAttribute("UserListData", allUserAccounts);
		model.addAttribute("msg", msg);
		return "userlist";
	}

	@GetMapping("/editUser/{id}")
	public String editUser(@PathVariable("id") Integer id, @ModelAttribute("UserData") UserAccount userAccount,
			Model model) {
		UserAccount userAcc = userService.getUserAcc(id);
		model.addAttribute("UserData", userAcc);
		return "edituser";
	}

	@PostMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") Integer id, @Valid @ModelAttribute("UserData") UserAccount userAccount,
			BindingResult result) {
		if (result.hasErrors()) {
			return "edituser";
		}
		userAccount.setId(id);
		userService.saveOrUpdateUserAcc(userAccount);
		return "redirect:/userList/1";
	}

	@GetMapping("/switchUserStatus")
	public String switchUserStatus(@RequestParam("id") Integer id, @RequestParam("active") String status) {
		userService.updateUserAccStatus(id, status);
		return "redirect:/userList/3";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id, Model model) {
		userService.deleteUserAcc(id);
		return "redirect:/userList/2";
	}

}
