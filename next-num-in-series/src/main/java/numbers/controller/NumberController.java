package numbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import numbers.entity.Sixnums;
import numbers.service.CustomerService;


@Controller
@RequestMapping(value="/number",method=RequestMethod.GET)
public class NumberController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showFormForEnteringIntegers")
	public String showFormForEnteringIntegers(Model theModel) {
		
		Sixnums theNums=new Sixnums();
		
		theModel.addAttribute("sixnums", theNums);
			
		return "number-form";
	}
	
	@PostMapping("/displayNumbers")
		public String displayNumbers(Sixnums theNums, ModelMap model) throws InterruptedException {
				
		theNums.setnextnum(customerService.nextNumInSeries(theNums.getNum1(),theNums.getNum2(),theNums.getNum3(),theNums.getNum4(),theNums.getNum5(),theNums.getNum6(),0));
			
		model.addAttribute("num1", theNums.getNum1());
		model.addAttribute("num2", theNums.getNum2());
		model.addAttribute("num3", theNums.getNum3());
		model.addAttribute("num4", theNums.getNum4());
		model.addAttribute("num5", theNums.getNum5());
		model.addAttribute("num6", theNums.getNum6());
		model.addAttribute("nextnum", theNums.getnextnum());		
		
		return "display-numbers";
	}
		
}

