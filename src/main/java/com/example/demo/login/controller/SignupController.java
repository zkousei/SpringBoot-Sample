package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;

@Controller
public class SignupController {
	//ラジオボタンの実装
	private Map<String, String> radioMarriage;

	//ラジオボタン初期化メソッド
	private Map<String,String> initRadioMarriage(){
		Map<String,String> radio = new LinkedHashMap<>();

		//既婚、未婚をMAPに格納
		radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio;
	}

	//ユーザ登録画面用のGETコントローラ
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form ,Model model) {
		//ラジオボタン初期化呼び出し
		radioMarriage = initRadioMarriage();

		//ラジオボタン用MAPをModelに登録
		model.addAttribute("radioMarriage",radioMarriage);

		return "login/signup";

	}

	//ユーザ登録画面用POSTコントローラ
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult,Model model) {

		//データバインド失敗の場合の処理
		if (bindingResult.hasErrors()) {
			//GET用のメソッド呼び出してユーザ登録が画面に戻るをする
			return getSignUp(form,model);
		}

		System.out.println(form);

		//リダイレクト
		//login.htmlへリダイレクト

		return "redirect:/login";

	}


}
