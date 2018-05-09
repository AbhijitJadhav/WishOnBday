package com.bdaywish.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bdaywish.bo.BaseResponse;
import com.bdaywish.bo.CommonRs;
import com.bdaywish.bo.ListRs;
import com.bdaywish.bo.UserBO;
import com.bdaywish.pojo.User;
import com.bdaywish.services.BdayWishService;
import com.bdaywish.utils.WishOnBdayException;

/**
 * 
 * @author Abhijit.Jadhav
 *
 */
@RestController
public class BdayWishController {
	
	@Autowired
	private BdayWishService bdayWishService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ResponseEntity<BaseResponse> addUser(@RequestBody User user) {
		BaseResponse baseResponse = new BaseResponse();
		HttpStatus httpstatus = null;
		try {
			bdayWishService.addUser(user);
			baseResponse.setMessage("user added sucessfully");
			baseResponse.setStatus("success");
			httpstatus=HttpStatus.OK;
		}catch(Exception e) {
			baseResponse.setMessage(e.getMessage());
			httpstatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<BaseResponse>(baseResponse,httpstatus);
	}
	
	@RequestMapping(value="/findUserById",method=RequestMethod.GET)
	public ResponseEntity<CommonRs<UserBO>> getUserById(@RequestParam(name="id",required=true,defaultValue="0") Integer id){
		CommonRs<UserBO> commonRs = new CommonRs<>();
		HttpStatus httpStatus = null;
		try {
			commonRs.setData(bdayWishService.findUserById(id));
			httpStatus = HttpStatus.OK;
			commonRs.setMessage("user found for id :"+id);
			commonRs.setStatus("success");
		}catch(Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			commonRs.setMessage(e.getMessage());
			commonRs.setStatus("user not found for id :"+id );
		}
		return new ResponseEntity<CommonRs<UserBO>>(commonRs,httpStatus);
	}
	
	@RequestMapping(value="/getUserByTime",method=RequestMethod.GET)
	public ResponseEntity<ListRs<UserBO>> getUserByTime(){
		ListRs<UserBO> listRs = new ListRs<>();
		HttpStatus httpStatus = null;
		try {
			listRs.setData(bdayWishService.getUsersByTime());
			httpStatus = HttpStatus.OK;
			listRs.setMessage("users foud for time");
			listRs.setStatus("success");
		}catch(WishOnBdayException e) {
			httpStatus = HttpStatus.OK;
			listRs.setMessage("No one is having bday today");
			listRs.setStatus("success");
		}catch(Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			listRs.setMessage(e.getMessage());
		}
		return new ResponseEntity<ListRs<UserBO>>(listRs,httpStatus);
	}
}
