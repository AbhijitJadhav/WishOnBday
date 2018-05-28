package com.bdaywish.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bdaywish.bo.BaseResponse;
import com.bdaywish.bo.CommonRs;
import com.bdaywish.bo.ListRs;
import com.bdaywish.bo.UserBO;
import com.bdaywish.services.BdayWishService;
import com.bdaywish.utils.WishOnBdayException;

/**
 * 
 * @author Abhijit.Jadhav
 *
 */
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class BdayWishController {
	
	@Autowired
	private BdayWishService bdayWishService;
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public ResponseEntity<ListRs<UserBO>> getUsers(){
		ListRs<UserBO> listRs = new ListRs<>();
		HttpStatus httpStatus = null;
		try {
			listRs.setData(bdayWishService.getUsers());
			httpStatus = HttpStatus.OK;
			listRs.setMessage("users foud	");
			listRs.setStatus("success");
			listRs.setCount(listRs.getData().size());
		}catch(Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			listRs.setMessage(e.getMessage());
		}
		return new ResponseEntity<ListRs<UserBO>>(listRs,httpStatus);
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ResponseEntity<BaseResponse> addUser(@RequestBody UserBO user) {
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
	
	@RequestMapping(value="/sendMail",method=RequestMethod.GET)
	public ResponseEntity<BaseResponse> sendMail(){
		BaseResponse baseResponse = new BaseResponse();
		HttpStatus httpStatus = null;
		List<Integer> idsList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		try{
			bdayWishService.sendMail(idsList);
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(baseResponse,httpStatus);
	}
	
	@RequestMapping(value="/sendSMS",method=RequestMethod.GET)
	public ResponseEntity<BaseResponse> sendSMS(){
		BaseResponse baseResponse = new BaseResponse();
		HttpStatus httpStatus = null;
		List<Integer> idsList = new ArrayList<Integer>(Arrays.asList(1,2,7,8,9));
		try{
			bdayWishService.sendSMS(idsList);
			httpStatus = HttpStatus.OK;
		}catch(Exception e){
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(baseResponse,httpStatus);
	}
}
